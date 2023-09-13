package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListBackedEmployee implements EmployeeRepo {

    private static List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee.EmployeeBuilder(1,"Nisha", Gender.FEMALE)
                    .salary(30000)
                    .joiningDate(LocalDate.of(2015,6,22))
                    .build(),
            new Employee.EmployeeBuilder(2,"Shahd", Gender.FEMALE)
                    .salary(32000)
                    .joiningDate(LocalDate.of(2014,5,02))
                    .build(),
            new Employee.EmployeeBuilder(3,"Deep", Gender.MALE)
                    .salary(40000)
                    .joiningDate(LocalDate.of(2012,6,04))
                    .build()

    ));


    @Override
    public List<Employee> getEmployeeById(int id) {
        List<Employee> returnList = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getId() == id){
              returnList.add(employee);
            }
        }
       return returnList;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Employee add(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> deleteById(int id) {
        List<Employee> returnList = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getId() == id){
                returnList.remove(employee);
            }
        }
       return returnList;
    }


}
