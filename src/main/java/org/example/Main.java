package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        System.out.println("Starting Employee program...");
        MenuSystem menuSystem = MenuSystem.getInstance();

        while (true) {
            menuSystem.execute();
        }

       /* // To get the total no. of staff
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

    */
    }
}