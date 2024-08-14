/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Lesson;
import com.dht.service.CourseService;
import com.dht.service.LessonService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Duy
 */
@Controller
@ControllerAdvice
public class LessonController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @GetMapping("/lessons")
    public String createView(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "lessons";
    }

    @PostMapping("/lessons")
    public String createView(Model model,
            @ModelAttribute(value = "lesson") @Valid Lesson l,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "lessons";
        }

        try {
            this.lessonService.addOrUpdate(l);
            return "redirect:/lessons";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "lessons";
    }

    @GetMapping("/lessons/{lessonId}")
    public String detailsView(Model model, @PathVariable(value = "lessonId") int id) {
        model.addAttribute("lesson", this.lessonService.getLessonById(id));
        return "lessons";
    }
}
