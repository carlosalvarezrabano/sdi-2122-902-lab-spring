package com.uniovi.sdi2122902spring.validators;

import com.uniovi.sdi2122902spring.entities.Mark;
import com.uniovi.sdi2122902spring.entities.Professor;
import com.uniovi.sdi2122902spring.services.MarksService;
import com.uniovi.sdi2122902spring.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MarksValidator implements Validator {

    @Autowired
    private MarksService marksService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Mark.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.description.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.score.empty");
        if (mark.getDescription().length() < 20) {
            errors.rejectValue("description", "Error.mark.description.length");}
        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.mark.score.value");}

    }
}
