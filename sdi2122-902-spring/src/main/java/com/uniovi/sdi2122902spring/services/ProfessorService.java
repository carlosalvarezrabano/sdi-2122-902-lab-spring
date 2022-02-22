package com.uniovi.sdi2122902spring.services;

import com.uniovi.sdi2122902spring.entities.Mark;
import com.uniovi.sdi2122902spring.entities.Professor;
import com.uniovi.sdi2122902spring.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    /*public void init() {
        professorRepository.save(new Professor("1", "Pepe", "Gonzalez", "informatica"));
        professorRepository.save(new Professor("2", "Manolo", "Alvarez", "fisica"));
        professorRepository.save(new Professor("3", "Jose", "Martinez", "medicina"));
    }*/

    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<Professor>();
        professorRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(Long id) {
        return professorRepository.findById(id).get();
    }

    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public Professor getProfessorByDni(String dni) {
        return professorRepository.getProfessorByDni(dni);
    }
}
