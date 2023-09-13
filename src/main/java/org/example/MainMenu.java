package org.example;

import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu {

    private static final EmployeeRepo employeeRepo = new ListBackedEmployee();
    private static final InternRepo internRepo = new ListBackedIntern();

    private static final Scanner scanner = new Scanner(System.in);

    public MainMenu() {
        super(" \n \n Main Menu");
        menuOptions = List.of(
                new MenuOption(1,"Amend staff list", () -> MenuSystem.setState(new StaffCrudMenu()) ),
                new MenuOption(2, "Get the total number of staff" , () -> {
                    int noOfStaff = Staff.getNoOfStaff();
                    System.out.println("Total number of staff is " + noOfStaff);
                }),
                new MenuOption(3, "Get average salary of the female employees in the system ", () -> {
                    List<Employee> femaleEmployeeList = Employee.getFemaleEmployeeList(employeeRepo.getEmployeeList());
                    double averageFemaleSalary = Employee.calculateAverageSalaryOneGender(femaleEmployeeList);
                    System.out.println("Average salary of female employees: " + averageFemaleSalary);}
                    ),
                new MenuOption(4, "Get average salary of the male employees in the system ", () -> {
                    List<Employee> maleEmployeeList = Employee.getMaleEmployeeList(employeeRepo.getEmployeeList());
                    double averageMaleSalary = Employee.calculateAverageSalaryOneGender(maleEmployeeList);
                    System.out.println("Average salary of male employees: " + averageMaleSalary);}
                ),
                new MenuOption(5, "Get the employee list order-by joining date ( earliest to latest) ", () ->  { Employee.getDateSortedEmployeeList(employeeRepo.getEmployeeList());} ),
                new MenuOption(6, "Get total list of employees in the system", () -> {
                    List<Employee> employeeList = employeeRepo.getEmployeeList();
                    System.out.println("List of employees in system: \n " + employeeList);
                }),
                new MenuOption(7, "Get total list of interns in the system", () -> {
                    List<Intern> internList = internRepo.getInternList();
                    System.out.println("List of interns in system: \n " + internList);
                }),
                new MenuOption(8, "Get total list of STAFF in the system", () -> {
                    List<Staff> staffList = Staff.getAllStaff();
                    System.out.println("List of interns in system: \n " + staffList);
                }),

                new MenuOption(9, "Quit", ()-> System.exit(0))


        );
    }


}
