package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee extends Staff  {
    final int salary;

    LocalDate joiningDate ;

    public Employee(int salary, LocalDate joiningDate,  String name, String gender) {

        super(name, gender);

        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public static List getFemaleEmployeeList(List<Employee> employeeList){

        // Creates a list of only Male employees from the total employeeList
        List<Employee> femaleEmployeeList = new ArrayList<Employee>();

        for (Employee employee: employeeList){
            if(employee.getGender() == "Female"){
                femaleEmployeeList.add(employee);
            }
        }
        return femaleEmployeeList;
    }

    public static List getMaleEmployeeList(List<Employee> employeeList){

        // Creates a list of only Male employees from the total employeeList
        List<Employee> maleEmployeeList = new ArrayList<Employee>();

        for (Employee employee: employeeList){
            if(employee.getGender() == "Male"){
                maleEmployeeList.add(employee);
            }
        }
        return maleEmployeeList;
    }

    public static int calculateAverageSalaryOneGender(List<Employee> genderBasedEmployeeList){

        int totalMaleSalary = 0;

        // Calculates Average Salary of Male employees from the list generated above.

        for(Employee oneGenderEmployee: genderBasedEmployeeList){
            totalMaleSalary+= oneGenderEmployee.getSalary();
        }

        return totalMaleSalary/genderBasedEmployeeList.size();

    }

    public static void getDateSortedEmployeeList( List<Employee> employeeList){
        Collections.sort(employeeList, new EmployeeSortingComparator());
        System.out.println("\n\nEmployee list sorted from joining date. ");
        for(Employee emp: employeeList){
            System.out.println(emp);
        }

    }



}
