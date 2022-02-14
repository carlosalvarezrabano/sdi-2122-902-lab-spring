package com.uniovi.sdi2122902spring.services;

import com.uniovi.sdi2122902spring.entities.Mark;
import com.uniovi.sdi2122902spring.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {

    List<Professor> professors = new LinkedList<>();

    @PostConstruct
    public void init() {
        professors.add(new Professor("1", "Pepe", "Gonzalez", "informatica"));
        professors.add(new Professor("2", "Manolo", "Alvarez", "fisica"));
        professors.add(new Professor("3", "Jose", "Martinez", "medicina"));
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public Professor getProfessor(String dni) {
        return professors.stream()
                .filter(professor -> professor.getDni().equals(dni)).findFirst().get();
    }

    public void addProfessor(Professor professor) {
        if (professor.getDni() == null) {
            professor.setDni(professors.get(professors.size() - 1).getDni() + 1);
        }
        professors.add(professor);
    }

    public void deleteProfessor(String dni) {
        professors.removeIf(professor -> professor.getDni().equals(dni));
    }
}
