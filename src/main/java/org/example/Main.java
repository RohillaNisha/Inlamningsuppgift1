package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Employee emp1 = new Employee(14000, LocalDate.of(2015,6,22) , "Guillaume", "Male");
        Employee emp2 = new Employee(17000, LocalDate.of(2013,3,12) , "Colin", "Male");
        Employee emp3 = new Employee(24000, LocalDate.of(2011,10,8) , "Zohra", "Female");
        Employee emp4 = new Employee(34000, LocalDate.of(2009,9,8) , "Luca", "Male");
        Intern intern1 = new Intern("Fabian", "Male", LocalDate.of(2023,5,19), "Good");
        Intern intern2 = new Intern("Nisha", "Female", LocalDate.of(2023,7,2), "Good");

        // An Array list of employees for doing collective calculations on employees
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);


        // To get the total no. of staff
        int totalStaff = Staff.getTotalStaff();
        System.out.println("Total staff in company are " + totalStaff);

        // To get the list of all male employees
       List maleEmployeeList = Employee.getMaleEmployeeList(employeeList);
       System.out.println(maleEmployeeList);

        // To get the list of all female employees
        List femaleEmployeeList = Employee.getFemaleEmployeeList(employeeList);
        System.out.println(femaleEmployeeList);


        // To get average male salary
       int averageMaleSalary = Employee.calculateAverageSalaryOneGender(maleEmployeeList);
       System.out.println("Average male salary is " + averageMaleSalary);


        // To get average female salary
       int averageFemaleSalary = Employee.calculateAverageSalaryOneGender(femaleEmployeeList);
       System.out.println("Average male salary is " + averageFemaleSalary);

       // To get the list of employees sorted with joining dates
        Employee.getDateSortedEmployeeList(employeeList);


    }
}