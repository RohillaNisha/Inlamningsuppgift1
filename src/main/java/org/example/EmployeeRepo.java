package org.example;

import java.util.List;

public interface EmployeeRepo {

    List<Employee> getEmployeeById(int id);

    List<Employee> getEmployeeList();

    Employee add(Employee employee);

    List<Employee> deleteById(int id);

}
