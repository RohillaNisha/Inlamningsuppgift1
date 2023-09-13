package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListBackedIntern implements InternRepo {

    private static List<Intern> internList = new ArrayList<>(List.of(
            new Intern.InternBuilder(4, "Jokopo", Gender.MALE)
                    .endDate(LocalDate.of(2023, 6, 22))
                    .performance("Good")
                    .build(),
            new Intern.InternBuilder(5, "Miyocin", Gender.FEMALE)
                    .endDate(LocalDate.of(2023, 5, 02))
                    .performance("Excellent")
                    .build()

    ));

    @Override
    public List<Intern> getInternById(int id) {
        List<Intern> returnList = new ArrayList<>();
        for (Intern intern : internList) {
            if (intern.getId() == id) {
                returnList.add(intern);
            }
        }
        return returnList;
    }

    @Override
    public List<Intern> getInternList() {
        return internList;
    }

    @Override
    public Intern add(Intern intern) {
        internList.add(intern);
        return intern;
    }

    @Override
    public List<Intern> deleteById(int id) {
        List<Intern> returnList = new ArrayList<>();
        for (Intern intern : internList) {
            if (intern.getId() == id) {
                returnList.remove(intern);
            }
        }
        return returnList;
    }
}
