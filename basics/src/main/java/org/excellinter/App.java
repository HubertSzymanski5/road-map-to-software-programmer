package org.excellinter;

import org.excellinter.employee.RawEmployee;
import org.excellinter.reader.Reader;
import org.excellinter.validator.EmployeeValidator;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No input file!");
            return;
        }
        String fileName = args[0];
        var lines = Reader.getLines(fileName);
        var validator = new EmployeeValidator();
        var result = IntStream.range(0, lines.size()).mapToObj(i -> {
            var fields = lines.get(i).split(";");
            Optional<String> employeeErrors = validator.validate(new RawEmployee(fields));
            return employeeErrors.map(s -> String.format("line %d: %s%n", i + 1, s)).orElse(null);
        }).filter(Objects::nonNull).toList();
        if (result.isEmpty()) {
            System.out.printf("%s is valid", fileName);
        } else {
            System.err.printf("%s is invalid%n%s", fileName, result.stream().reduce((msg, err) -> msg + err).get());
        }
    }
}
