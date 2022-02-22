package com.uniovi.sdi2122902spring.repositories;

import com.uniovi.sdi2122902spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    Professor getProfessorByDni(String dni);
}
