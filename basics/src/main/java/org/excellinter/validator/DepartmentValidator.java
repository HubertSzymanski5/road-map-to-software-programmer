package org.excellinter.validator;

import org.excellinter.employee.Department;
import org.excellinter.employee.RawEmployee;

import java.util.List;

public class DepartmentValidator implements FieldValidator {
    @Override
    public void validate(RawEmployee employee, List<String> errors) {
        if (!isValid(employee)) {
            errors.add(String.format("department '%s' does not exist", employee.getDepartment()));
        }
    }

    private boolean isValid(RawEmployee employee) {
        if (employee.getDepartment() == null) return false;
        try {
            Department.valueOf(employee.getDepartment().toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
