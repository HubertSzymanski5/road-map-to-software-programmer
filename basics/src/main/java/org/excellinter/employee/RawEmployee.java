package org.excellinter.employee;

import java.lang.reflect.Field;

public class RawEmployee {
  private String firstName;
  private String lastName;
  private String birthDay;
  private String salary;
  private String department;

  public RawEmployee(String... fields) {
    Field[] employeeFields = this.getClass().getDeclaredFields();
    try {
      for (int i = 0; i < fields.length && i < employeeFields.length; i++) {
        employeeFields[i].set(this, fields[i]);
      }
    } catch (IllegalAccessException e) {
      System.err.println("ERROR: Cannot construct employee object");
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public String getSalary() {
    return salary;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public String toString() {
    return "RawEmployee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", birthDay='" + birthDay + '\'' +
            ", salary='" + salary + '\'' +
            ", department='" + department + '\'' +
            '}';
  }
}
