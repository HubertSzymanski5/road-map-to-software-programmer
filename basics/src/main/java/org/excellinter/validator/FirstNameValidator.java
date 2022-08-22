package org.excellinter.validator;

import org.excellinter.employee.RawEmployee;

import java.util.List;

public class FirstNameValidator implements FieldValidator {

  private static final String LATIN_ONLY_REGEXP = "[A-Za-z]+";

  @Override
  public void validate(RawEmployee employee, List<String> errors) {
    if (employee == null || employee.getFirstName().isBlank()) {
      errors.add("first name cannot be empty");
    } else if (!isLatinOnly(employee.getFirstName())) {
      errors.add(String.format("first name '%s' contains illegal character", employee.getFirstName()));
    }
  }

  private boolean isLatinOnly(String string) {
    return string.trim().matches(LATIN_ONLY_REGEXP);
  }
}
