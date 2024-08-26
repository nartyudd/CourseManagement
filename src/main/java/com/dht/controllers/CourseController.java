/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Course;
import com.dht.pojo.Lesson;
import com.dht.service.CourseService;
import com.dht.service.LessonService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;
    
    @GetMapping("/courses")
    public String createView(Model model) {
        model.addAttribute("course", new Course());
        return "courses";
    }

    @PostMapping("/courses")
    public String createView(Model model,
            @ModelAttribute(value = "course") @Valid Course c,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "courses";
        }

        try {
            this.courseService.addOrUpdate(c);

            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "courses";
    }

    @GetMapping("/courses/{courseId}")
    public String detailsView(Model model, @PathVariable(value = "courseId") int id) {
        model.addAttribute("course", this.courseService.getCourseById(id));
        return "courses";
    }
}
