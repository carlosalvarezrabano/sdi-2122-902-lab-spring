package com.uniovi.sdi2122902spring.controllers;

import com.uniovi.sdi2122902spring.entities.Mark;
import com.uniovi.sdi2122902spring.entities.Professor;
import com.uniovi.sdi2122902spring.services.MarksService;
import com.uniovi.sdi2122902spring.services.ProfessorService;
import com.uniovi.sdi2122902spring.validators.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorsService;
    @Autowired
    private ProfessorValidator validator;

    @RequestMapping(value = "/professor/add")
    public String getProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("professorsList", professorsService.getProfessors());
        return "professor/list";
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setMark(@Validated Professor professor, BindingResult result) {
        validator.validate(professor, result);
        if(result.hasErrors()) {
            return "professor/add";
        }
        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }
    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        professorsService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(@PathVariable Long id) {
        return "Editando..." + professorsService.getProfessor(id).toString();
    }

    @RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@PathVariable Long id){
        Professor professor = professorsService.getProfessor(id);
        professor.setDni(professor.getDni());
        professorsService.addProfessor(professor);
        return "Ok";
    }
}
