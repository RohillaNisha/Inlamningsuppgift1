package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee extends Staff  {
    private int salary;
    private LocalDate joiningDate ;

    private Employee(int id, String name,Gender gender, int salary, LocalDate joiningDate ) {

        super(id, name, gender);
        this.salary = salary;
        this.joiningDate = joiningDate;
    }


    public static class EmployeeBuilder {

        private final int id;
        private String name;
        private Gender gender;
        private int salary;
        private LocalDate joiningDate;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public int getSalary() {
            return salary;
        }

        public LocalDate getJoiningDate() {
            return joiningDate;
        }

        public EmployeeBuilder(int id, String name, Gender gender){
           this.id = id;
           this.name = name;
           this.gender = gender;
        }

        public EmployeeBuilder salary(int salary){
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder joiningDate(LocalDate joiningDate){
            this.joiningDate = joiningDate;
            return this;
        }

        public Employee build(){
            return new Employee(id,name,gender,salary, joiningDate );
        }

    }


   public int getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }


    public static List getFemaleEmployeeList(List<Employee> employeeList){

        // Creates a list of only Male employees from the total employeeList
        List<Employee> femaleEmployeeList = new ArrayList<Employee>();

        for (Employee employee: employeeList){
            if(employee.getGender() == Gender.FEMALE){
                femaleEmployeeList.add(employee);
            }
        }
        return femaleEmployeeList;
    }

    public static List getMaleEmployeeList(List<Employee> employeeList){

        // Creates a list of only Male employees from the total employeeList
        List<Employee> maleEmployeeList = new ArrayList<Employee>();

        for (Employee employee: employeeList){
            if(employee.getGender() == Gender.MALE){
                maleEmployeeList.add(employee);
            }
        }
        return maleEmployeeList;
    }

    public static int calculateAverageSalaryOneGender(List<Employee> genderBasedEmployeeList){

        int totalGenderBasedSalary = 0;

        // Calculates Average Salary of Male employees from the list generated above.

        for(Employee oneGenderEmployee: genderBasedEmployeeList){
            totalGenderBasedSalary+= oneGenderEmployee.getSalary();
        }

        return totalGenderBasedSalary/genderBasedEmployeeList.size();

    }

    public static void getDateSortedEmployeeList( List<Employee> employeeList){
        Collections.sort(employeeList, new EmployeeSortingComparator());
        System.out.println("\n\nEmployee list sorted from joining date. ");
        for(Employee emp: employeeList){
            System.out.println(emp);
        }

    }

    @Override
    public String toString() {
        return   super.toString() +
                " salary=" + salary +
                ", joiningDate=" + joiningDate
                 ;
    }
}
