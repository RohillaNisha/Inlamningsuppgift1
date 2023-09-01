package org.example;

import java.time.LocalDate;

public class Intern extends Staff {

     private String performance;
     private LocalDate endDate ;

    public Intern(String name, String gender, LocalDate endDate, String performance) {
        super(name, gender);
        this.endDate = endDate;
        this.performance = performance;

    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
