package org.excellinter.validator;

import org.excellinter.employee.RawEmployee;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateOfBirthValidator implements FieldValidator {

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void validate(RawEmployee employee, List<String> errors) {
        if (!isValid(employee)) {
            errors.add(String.format("birthday '%s' does not match 'yyyy-MM-dd' format", employee.getBirthDay()));
        }
    }

    private boolean isValid(RawEmployee employee) {
        try {
            var date = DATE_FORMAT.parse(employee.getBirthDay());
            return true;
        } catch (DateTimeException ex) {
            return false;
        }
    }
}
