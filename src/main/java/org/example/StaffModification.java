package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StaffModification extends Menu {

    private static  EmployeeRepo employeeRepo = new ListBackedEmployee();
    private static InternRepo internRepo = new ListBackedIntern();
    private static final Scanner scanner = new Scanner(System.in);

    int noOfStaff = Staff.getNoOfStaff();

    public StaffModification() {
        super("Modify staff details ");
        menuOptions = List.of(
                new MenuOption(1,"Modify employee details", () -> modifyAnEmployee()),
                new MenuOption(2,"Modify intern details", () -> modifyAnIntern()),
                new MenuOption(3,"Go back to previous menu", () -> MenuSystem.setState(new StaffCrudMenu()))
        );
    }

    private void modifyAnIntern() {
        Intern internToModify = null;
        int newId;
        String newName, newPerformance;
        Gender newGender;
        LocalDate newEndDate;
        System.out.println("What is the id of intern you want to modify?");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Existing details of the selected intern: \n");
        for (Intern intern : internRepo.getInternById(id)) {
            System.out.println(intern);
            internToModify = intern;
            break;
        }
        if (internToModify == null) {
            System.out.println("No intern with such id exists. ");
        } else {
            int indexOfInternToModify = internRepo.getInternList().indexOf(internToModify);
            System.out.println(" Existing id is: " + internToModify.getId() + "\n");
            System.out.println("Do you want to modify id? \n  YES/NO");
            String useConfirmationForId = scanner.nextLine();
            if (useConfirmationForId.equalsIgnoreCase("yes")) {
                System.out.println("What is the new id ? ");
                newId = scanner.nextInt();
                for (Intern intern : internRepo.getInternList()) {
                    while (intern.getId() == newId) {
                        System.out.println("This id belongs to another staff and can't be used here. \n Please choose another id , preferably number after " + noOfStaff);
                        newId = scanner.nextInt();
                    }
                    scanner.nextLine();
                }
            }
            else{
                    newId = internToModify.getId();
                }

                System.out.println(" Existing name is: " + internToModify.getName() + "\n");
                System.out.println("Do you want to modify name? \n  YES/NO");
                String useConfirmationForName = scanner.nextLine();
                if (useConfirmationForName.equalsIgnoreCase("yes")) {
                    System.out.println("What is the new name ? ");
                    newName = scanner.nextLine();
                } else {
                    newName = internToModify.getName();
                }


                System.out.println(" Existing gender is: " + internToModify.getGender() + "\n");
                System.out.println("Do you want to modify gender? \n  YES/NO");
                String useConfirmationForGender = scanner.nextLine();
                if (useConfirmationForGender.equalsIgnoreCase("yes")) {
                    System.out.println("What is the new gender ? ");
                    String genderInput = scanner.nextLine();
                    newGender = Gender.valueOf(genderInput);
                } else {
                    newGender = internToModify.getGender();
                }

                System.out.println(" Existing end date is: " + internToModify.getEndDate() + "\n");
                System.out.println("Do you want to modify salary? \n  YES/NO");
                String useConfirmationForEndDate = scanner.nextLine();
                if (useConfirmationForEndDate.equalsIgnoreCase("yes")) {
                    System.out.println("What is the new salary ? ");
                    newEndDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                } else {
                    newEndDate = internToModify.getEndDate();
                }


                System.out.println(" Existing performance is: " + internToModify.getPerformance() + "\n");
                System.out.println("Do you want to modify performance? \n  YES/NO");
                String useConfirmationForPerformance = scanner.nextLine();
                if (useConfirmationForPerformance.equalsIgnoreCase("yes")) {
                    System.out.println("How is the performance now ? ");
                    newPerformance = scanner.nextLine();
                } else {
                    newPerformance = internToModify.getPerformance();
                }


                Intern.InternBuilder updatedInternBuilder = new Intern.InternBuilder(newId, newName, newGender)
                        .endDate(newEndDate)
                        .performance(newPerformance);

                Intern modifiedIntern = updatedInternBuilder.build();

                internRepo.getInternList().set(indexOfInternToModify, modifiedIntern);
                System.out.println("Intern details has been modified.");
            }

    }

    private void modifyAnEmployee() {
        Employee employeeToModify = null;
        int newId, newSalary;
        String newName;
        Gender newGender;
        LocalDate newJoiningDate;
        System.out.println("What is the id of employee you want to modify?");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Existing details of the selected employee: \n");
        for (Employee employee : employeeRepo.getEmployeeById(id)) {
            System.out.println(employee);
            employeeToModify = employee;
            break;
        }
        if (employeeToModify == null) {
            System.out.println("No employee with such id exists. ");
        } else {
            int indexOfEmployeeToModify = employeeRepo.getEmployeeList().indexOf(employeeToModify);
            System.out.println(" Existing id is: " + employeeToModify.getId() + "\n");
            System.out.println("Do you want to modify id? \n  YES/NO");
            String useConfirmationForId = scanner.nextLine();
            if(useConfirmationForId.equalsIgnoreCase("yes")){
                System.out.println("What is the new id ? ");
                 newId = scanner.nextInt();
                 for(Employee employee: employeeRepo.getEmployeeList()){
                    while(employee.getId() == newId){
                        System.out.println("This id belongs to another staff and can't be used here. \n Please choose another id , preferably number after " + noOfStaff);
                        newId = scanner.nextInt();
                    }
                }
                 scanner.nextLine();
            }
            else{
                newId = employeeToModify.getId();
            }

            System.out.println(" Existing name is: " + employeeToModify.getName() + "\n");
            System.out.println("Do you want to modify name? \n  YES/NO");
            String useConfirmationForName = scanner.nextLine();
            if(useConfirmationForName.equalsIgnoreCase("yes")){
                System.out.println("What is the new name ? ");
                newName = scanner.nextLine();
            }
            else{
                newName = employeeToModify.getName();
            }


            System.out.println(" Existing gender is: " + employeeToModify.getGender() + "\n");
            System.out.println("Do you want to modify gender? \n  YES/NO");
            String useConfirmationForGender = scanner.nextLine();
            if(useConfirmationForGender.equalsIgnoreCase("yes")){
                System.out.println("What is the new gender ? ");
                String genderInput = scanner.nextLine();
                newGender = Gender.valueOf(genderInput);
            }
            else{
                newGender = employeeToModify.getGender();
            }

            System.out.println(" Existing salary is: " + employeeToModify.getSalary() + "\n");
            System.out.println("Do you want to modify salary? \n  YES/NO");
            String useConfirmationForSalary = scanner.nextLine();
            if(useConfirmationForSalary.equalsIgnoreCase("yes")){
                System.out.println("What is the new salary ? ");
                newSalary = scanner.nextInt();
                scanner.nextLine();
            }
            else{
                newSalary = employeeToModify.getSalary();
            }


            System.out.println(" Existing joining date is: " + employeeToModify.getJoiningDate() + "\n");
            System.out.println("Do you want to modify joining date? \n  YES/NO");
            String useConfirmationForJoiningDate = scanner.nextLine();
            if(useConfirmationForJoiningDate.equalsIgnoreCase("yes")){
                System.out.println("What is the new joining date ? ");
                newJoiningDate= LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
            }
            else{
                newJoiningDate = employeeToModify.getJoiningDate();
            }


                Employee.EmployeeBuilder updatedEmployeeBuilder = new Employee.EmployeeBuilder(newId, newName, newGender)
                                                                          .salary(newSalary)
                                                                          .joiningDate(newJoiningDate);

                Employee modifiedEmployee = updatedEmployeeBuilder.build();

                employeeRepo.getEmployeeList().set(indexOfEmployeeToModify, modifiedEmployee);
                System.out.println("Employee details has been modified.");
            }

        }

}
