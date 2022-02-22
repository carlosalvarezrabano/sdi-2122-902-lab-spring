package com.uniovi.sdi2122902spring.controllers;

import com.uniovi.sdi2122902spring.entities.Mark;
import com.uniovi.sdi2122902spring.services.MarksService;
import com.uniovi.sdi2122902spring.services.UsersService;
import com.uniovi.sdi2122902spring.validators.MarksValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MarksController {
    @Autowired //Inyectar el servicio
    private MarksService marksService;

    // Inyectamos el servicio
    @Autowired
    private UsersService usersService;

    @Autowired
    private MarksValidator validator;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "/mark/add")
    public String getMark(Model model) {
        model.addAttribute("usersList", usersService.getUsers());
        model.addAttribute("mark", new Mark());
        return "mark/add";
    }

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }
    @RequestMapping("/mark/list/update")
    public String updateList(Model model){
        model.addAttribute("markList", marksService.getMarks() );
        return "mark/list :: tableMarks";
    }
    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@Validated Mark mark, Model model, BindingResult result) {
        validator.validate(mark, result);
        if(result.hasErrors()) {
            model.addAttribute("usersList", usersService.getUsers());
            return "mark/add";
        }
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }
    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@Validated Mark mark, @PathVariable Long id, Model model, BindingResult result) {
        validator.validate(mark, result);
        if(result.hasErrors()) {
            model.addAttribute("mark", mark);
            model.addAttribute("usersList", usersService.getUsers());
            return "mark/edit";
        }
        Mark originalMark = marksService.getMark(id);
        // modificar solo score y description
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/"+id;
    }

}
