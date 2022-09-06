package org.excellinter.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
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
        // TODO: implement
        fail();
    }

    @Test
    void shouldReturnFalse_WhenInvalidFormat() {
        // TODO: implement
        fail();
    }

    @Test
    void shouldReturnFalse_WhenDateInFuture() {
        // TODO: implement
        fail();
    }

    @Test
    void shouldReturnFalse_When15YearsOld() {
        // TODO: implement
        fail();
    }

    @Test
    void shouldReturnTrue_WhenTurning16ThisYear() {
        // TODO: implement
        fail();
    }

    @Test
    void shouldReturnFalse_WhenOver70() {
        // TODO: implement
        fail();
    }
}