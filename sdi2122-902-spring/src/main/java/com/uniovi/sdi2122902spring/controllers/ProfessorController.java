package com.uniovi.sdi2122902spring.controllers;

import com.uniovi.sdi2122902spring.entities.Mark;
import com.uniovi.sdi2122902spring.entities.Professor;
import com.uniovi.sdi2122902spring.services.MarksService;
import com.uniovi.sdi2122902spring.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorsService;

    @RequestMapping(value = "/professor/add")
    public String getMark() {
        return "Ok";
    }

    @RequestMapping("/professor/list")
    public String getList() {
        return professorsService.getProfessors().toString();
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setMark(Professor professor) {
        professorsService.addProfessor(professor);
        return "Ok";
    }
    @RequestMapping("/professor/details/{dni}")
    public String getDetail(@PathVariable String dni) {
        return professorsService.getProfessor(dni).toString();
    }

    @RequestMapping("/professor/delete/{dni}")
    public String deleteMark(@PathVariable String dni) {
        professorsService.deleteProfessor(dni);
        return "Ok";
    }

    @RequestMapping(value = "/mark/edit/{dni}")
    public String getEdit(@PathVariable String dni) {
        return "Editando..." + professorsService.getProfessor(dni).toString();
    }

    @RequestMapping(value="/mark/edit/{dni}", method=RequestMethod.POST)
    public String setEdit(@PathVariable String dni){
        Professor professor = professorsService.getProfessor(dni);
        professor.setDni(dni);
        professorsService.addProfessor(professor);
        return "Ok";
    }
}
