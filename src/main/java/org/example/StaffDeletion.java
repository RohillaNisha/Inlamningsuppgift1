package org.example;

import java.util.List;
import java.util.Scanner;

public class StaffDeletion extends Menu{

    private static  EmployeeRepo employeeRepo = new ListBackedEmployee();
    private static InternRepo internRepo = new ListBackedIntern();
    private static final Scanner scanner = new Scanner(System.in);

    public StaffDeletion() {
            super("Deleting a staff ");
        menuOptions = List.of(
                new MenuOption(1,"Delete an employee", () -> deleteAnEmployee()),
                new MenuOption(2, "Delete an intern", () -> deleteAnIntern()),
                new MenuOption(3,"Go back to previous menu", () -> MenuSystem.setState(new StaffCrudMenu()))
        );
    }

    public void deleteAnEmployee() {
        Employee employeeToDelete = null;
        System.out.println("What is the id of the employee you want to delete? ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee employee : employeeRepo.getEmployeeById(id)) {
            System.out.println(employee);
            employeeToDelete = employee;
            break;
        }
        if (employeeToDelete == null) {
            System.out.println("No employee with such id exists. ");
        } else {
            System.out.println("Are you sure you want to delete? \n ");
            System.out.println("Type YES/ NO \n ");
            String userConfirmation = scanner.nextLine();
            if (userConfirmation.equalsIgnoreCase("YES") && employeeToDelete != null) {
                for (int i = 0; i < employeeRepo.getEmployeeList().size(); i++) {            // Traditional for loop to prevent ConcurrentModificationException
                    if (employeeRepo.getEmployeeList().get(i).getId() == id) {
                        employeeRepo.getEmployeeList().remove(employeeToDelete);
                    }
                }
                System.out.println("Employee " + employeeToDelete + " is deleted from the system. ");
            } else {
                System.out.println("No employee deleted. \n");
            }
        }
    }

    public void deleteAnIntern(){
        Intern internToDelete = null;
        System.out.println("What is the id of the intern you want to delete? ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Intern intern : internRepo.getInternById(id)){
            System.out.println(intern);
            internToDelete = intern;
            break;
        }
        if (internToDelete == null){
            System.out.println("No intern with such id exists. ");

        }else{
            System.out.println("Are you sure you want to delete? \n ");
            System.out.println("Type YES/ NO \n ");
            String userConfirmation = scanner.nextLine();
            if (userConfirmation.equalsIgnoreCase("YES") && internToDelete != null) {
                for (int i = 0; i < internRepo.getInternList().size(); i++) {            // Traditional for loop to prevent ConcurrentModificationException
                    if (internRepo.getInternList().get(i).getId() == id) {
                        internRepo.getInternList().remove(internToDelete);
                    }
                }
                System.out.println("Intern " + internToDelete + " is deleted from the system. ");
            } else {
                System.out.println("No intern deleted. \n");
            }

        }



    }
}
