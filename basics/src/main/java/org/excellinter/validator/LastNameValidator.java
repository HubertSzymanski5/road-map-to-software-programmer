package org.excellinter.validator;

import org.excellinter.employee.RawEmployee;

import java.util.List;

public class LastNameValidator implements FieldValidator {

  private static final String LATIN_ONLY_REGEXP = "[A-Za-z]+";

  @Override
  public void validate(RawEmployee employee, List<String> errors) {
    if (employee == null || employee.getLastName().isBlank()) {
      errors.add("last name cannot be empty");
    } else if (!employee.getLastName().trim().matches(LATIN_ONLY_REGEXP)) {
      errors.add(String.format("last name '%s' contains illegal character", employee.getLastName()));
    }
  }
}
