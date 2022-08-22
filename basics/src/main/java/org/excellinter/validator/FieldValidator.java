package org.excellinter.validator;

import org.excellinter.employee.RawEmployee;

import java.util.List;

public interface FieldValidator {

  void validate(RawEmployee employee, List<String> errors);
}
