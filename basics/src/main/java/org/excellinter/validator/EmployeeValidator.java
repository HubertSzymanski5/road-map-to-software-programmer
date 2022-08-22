package org.excellinter.validator;

import org.excellinter.employee.RawEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class EmployeeValidator {

  private final List<FieldValidator> fieldValidators = new ArrayList<>();

  public EmployeeValidator() {
    fieldValidators.add(new FirstNameValidator());
    fieldValidators.add(new LastNameValidator());
    fieldValidators.add(new DateOfBirthValidator());
    fieldValidators.add(new SalaryValidator());
    fieldValidators.add(new DepartmentValidator());
  }

  public Optional<String> validate(RawEmployee employee) {
    List<String> errors = new ArrayList<>();
    fieldValidators.forEach(validator -> validator.validate(employee, errors));
    return errors.stream()
            .reduce((message, error) -> message + "; " + error)
            .map(message -> Character.toUpperCase(message.charAt(0)) + message.substring(1));
  }
}
