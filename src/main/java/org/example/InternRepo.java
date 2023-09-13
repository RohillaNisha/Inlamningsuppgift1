package org.example;

import java.util.List;

public interface InternRepo {

    List<Intern> getInternById(int id);

    List<Intern> getInternList();

    Intern add(Intern intern);

    List<Intern> deleteById(int id);
}
