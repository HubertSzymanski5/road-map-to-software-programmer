package org.excellinter.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateOfBirthValidator {

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final TimeProvider timeProvider;

    public DateOfBirthValidator(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public boolean validate(String date) {
        try {
            LocalDate parsedDate = LocalDate.parse(date, DATE_FORMAT);
            LocalDate now = timeProvider.getCurrentDate();
            return isNotTooYoung(parsedDate, now) && isNotTooOld(parsedDate, now);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isNotTooOld(LocalDate parsedDate, LocalDate now) {
        return parsedDate.isAfter(now.minusYears(70));
    }

    private static boolean isNotTooYoung(LocalDate parsedDate, LocalDate now) {
        return isOver16YearsOld(parsedDate, now) || doesTurn16ThisYear(parsedDate, now);
    }

    private static boolean isOver16YearsOld(LocalDate parsedDate, LocalDate now) {
        return parsedDate.isBefore(now.minusYears(16));
    }

    private static boolean doesTurn16ThisYear(LocalDate parsedDate, LocalDate now) {
//        return isOver16YearsOld(parsedDate.minusMonths(parsedDate.getMonthValue()-now.getMonthValue()), now);
        return parsedDate.getYear() == now.minusYears(16).getYear();
    }
}
