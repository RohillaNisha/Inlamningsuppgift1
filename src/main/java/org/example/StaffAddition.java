package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StaffAddition extends Menu {
    private static  EmployeeRepo employeeRepo = new ListBackedEmployee();
    private static InternRepo internRepo = new ListBackedIntern();
    private static final Scanner scanner = new Scanner(System.in);
    int noOfStaff = Staff.getNoOfStaff();

    public StaffAddition() {
        super("Adding a staff ");
        menuOptions = List.of(
                new MenuOption(1,"Add an employee", () -> addAnEmployee()),
                new MenuOption(2, "Add an intern", () -> addAnIntern()),
                new MenuOption(3,"Go back to previous menu", () -> MenuSystem.setState(new StaffCrudMenu()))
        );
    }

    public void addAnEmployee() {
        boolean idExists = false;
        int id = 0;
        do{
            System.out.println("What is the id of the new employee?");
            id = scanner.nextInt();
            idExists = false;

            for(Staff staff: Staff.getAllStaff()){
                if(staff.getId() == id){
                    idExists = true;
                    System.out.println("This id belongs to another staff and can't be used here. \n Please choose another id , preferably number after " + noOfStaff);
                    break;
                }
            }
            scanner.nextLine();

        } while (idExists);

        System.out.println("What is the name of the new employee?");
        String name = scanner.nextLine();
        System.out.println("Is the employee MALE/FEMALE? (use capital letters only) ");
        String genderInput = scanner.nextLine();
        Gender gender =Gender.valueOf(genderInput);
        System.out.println(" Enter salary of the employee ");
        int salary = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" Enter date of joining. ");
        LocalDate joiningDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        employeeRepo.add(new Employee.EmployeeBuilder(id,name,gender)
                .salary(salary)
                .joiningDate(joiningDate)
                .build());
        System.out.println("New employee " + name + " added to the system. \n");
        for(Employee employee: employeeRepo.getEmployeeById(id)){
            if(employee.getId() == id){
            System.out.println(employee + "\n");}
        }
    }

    public void addAnIntern(){
        boolean idExists = false;
        int id = 0;
        do{
            System.out.println("What is the id of the new intern?");
             id = scanner.nextInt();
            idExists = false;

            for(Staff staff: Staff.getAllStaff()){
                if(staff.getId() == id){
                    idExists = true;
                    System.out.println("This id belongs to another staff and can't be used here. \n Please choose another id , preferably number after " + noOfStaff);
                    break;
                }
            }
            scanner.nextLine();

        } while (idExists);

        System.out.println("What is the name of the intern? ");
        String name = scanner.nextLine();
        System.out.println("Is the intern MALE/FEMALE? (use capital letters only) ");
        String genderInput = scanner.nextLine();
        Gender gender =Gender.valueOf(genderInput);
        System.out.println(" Enter end date of internship. ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("How was the performance of the intern? ( Good / Bad / Excellent etc) ");
        String performance = scanner.nextLine();
        internRepo.add(new Intern.InternBuilder(id,name,gender)
                .endDate(endDate)
                .performance(performance)
                .build());
        System.out.println("New intern " + name + " added to the system. \n ");
        for(Intern intern: internRepo.getInternById(id)){
            if(intern.getId() == id){
                System.out.println(intern + "\n");}
        }


    }
}
