package com.uniovi.sdi2122902spring.validators;

import com.uniovi.sdi2122902spring.entities.Professor;
import com.uniovi.sdi2122902spring.entities.User;
import com.uniovi.sdi2122902spring.services.ProfessorService;
import com.uniovi.sdi2122902spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorValidator implements Validator {

    @Autowired
    private ProfessorService professorService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        String dni = professor.getDni();
        if (dni.length() < 9) {
            errors.rejectValue("dni", "Error.professor.dni.length");}
        if (!Character.isLetter(dni.charAt(dni.length()-1))) {
            errors.rejectValue("dni", "Error.professor.dni.letter");}

        if (professorService.getProfessorByDni(dni) != null) {
            errors.rejectValue("dni", "Error.professor.dni.duplicate");}
    }
}
