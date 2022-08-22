package org.excellinter.validator;

import org.excellinter.employee.RawEmployee;

import java.util.List;

import static java.lang.Double.parseDouble;

public class SalaryValidator implements FieldValidator {
    @Override
    public void validate(RawEmployee employee, List<String> errors) {
        double salary;
        try {
            salary = parseDouble(employee.getSalary());
            if (salary < 0) {
                errors.add("salary must be positive number");
            }
        } catch (NumberFormatException e) {
            errors.add(String.format("salary '%s' is not valid number format", employee.getSalary()));
        }
    }
}
