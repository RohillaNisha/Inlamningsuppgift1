package org.example;

import java.time.LocalDate;

public class Intern extends Staff {

     private String performance;
     private LocalDate endDate ;

    public Intern(int id, String name, Gender gender, LocalDate endDate, String performance) {
        super(id, name, gender);
        this.endDate = endDate;
        this.performance = performance;
    }

    public static class InternBuilder {

        private final int id;
        private String name;
        private Gender gender;
        private String performance;
        private LocalDate endDate ;

        public InternBuilder( int id, String name, Gender gender){
            this.id = id;
            this.name = name;
            this.gender = gender;
        }

        public InternBuilder endDate(LocalDate endDate){
            this.endDate = endDate;
            return this;
        }

        public InternBuilder performance(String performance){
            this.performance = performance;
            return this;
        }

        public Intern build() { return new Intern(id, name,gender, endDate, performance);}
    }

    public String getPerformance() {
        return performance;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " performance='" + performance + '\'' +
                ", endDate=" + endDate ;
    }
}
