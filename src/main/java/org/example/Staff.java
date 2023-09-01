package org.example;

import java.util.ArrayList;
import java.util.List;

public class Staff {
   private String name;
   private String gender;
   private static int id = 0;

    public Staff(String name, String gender) {
        this.name = name;
        this.gender = gender;
        id++;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', gender='" + gender + "'}";
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setId(int id) {
        Staff.id = id;
    }

    public static int getTotalStaff(){
        return id;
    }


}
