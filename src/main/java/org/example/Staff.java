package org.example;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    private String name;
    private Gender gender;
    private int id;
    private static int noOfStaff =0;
    private static List<Staff> allStaff = new ArrayList<>();
    public Staff(int id,String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        allStaff.add(this);
        noOfStaff++;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public Gender setGender(Gender gender) {
        this.gender = gender;
        return gender;
    }

    public static List<Staff> getAllStaff(){
        return allStaff;
    }


    public int getId(){
        return id;
    }

    public static int getNoOfStaff(){

     return noOfStaff;
    }

    @Override
    public String toString() {
        return "Staff{" +
                " id=" + id +
                " name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Gender getGender(Gender gender) {
        return this.gender;
    }


}


