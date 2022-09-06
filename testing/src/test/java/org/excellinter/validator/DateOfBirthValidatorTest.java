package org.excellinter.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DateOfBirthValidatorTest {

    @Mock
    private TimeProvider timeProvider;

    @InjectMocks
    private DateOfBirthValidator validator;

    @Test
    void shouldReturnTrue_WhenForValidBirthDay() {
        when(timeProvider.getCurrentDate()).thenReturn(LocalDate.of(2020, 1, 1));
        assertTrue(validator.validate("1995-02-27"));
    }

    @Test
    void shouldReturnFalse_WhenRandomString() {
        assertFalse(validator.validate("ADWsdgeaf12345sd"));
    }

    @Test
    void shouldReturnFalse_WhenInvalidDate() {
        assertFalse(validator.validate("2000-02-29"));
    }

    @Test
    void shouldReturnFalse_WhenInvalidFormat() {
        assertFalse(validator.validate("1995/02/27"));
    }

    @Test
    void shouldReturnFalse_WhenDateInFuture() {
        when(timeProvider.getCurrentDate()).thenReturn(LocalDate.of(2020, 1, 1));
        assertFalse(validator.validate("2022-02-02"));
    }

    @Test
    void shouldReturnFalse_When15YearsOld() {
        when(timeProvider.getCurrentDate()).thenReturn(LocalDate.of(2020, 1, 1));
        assertFalse(validator.validate("2005-03-20"));
    }

    @Test
    void shouldReturnTrue_WhenTurning16ThisYear() {
        when(timeProvider.getCurrentDate()).thenReturn(LocalDate.of(2020, 1, 1));
        assertTrue(validator.validate("2004-12-31"));
    }

    @Test
    void shouldReturnFalse_WhenOver70() {
        when(timeProvider.getCurrentDate()).thenReturn(LocalDate.of(2020, 1, 1));
        assertFalse(validator.validate("1950-01-01"));
    }
}