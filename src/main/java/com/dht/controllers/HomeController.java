/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.repository.impl.CategoryRepositoryImpl;
import com.dht.service.AnswerService;
import com.dht.service.CategoryService;
import com.dht.service.CourseService;
import com.dht.service.LessonService;
import com.dht.service.ProfileService;
import com.dht.service.QuestionService;
import com.dht.service.VideoService;

import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CategoryService cateService;

    @Autowired
    private ProfileService profileService;
    


    @Autowired
    private LessonService lessonService;
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private AnswerService answerService;

    @ModelAttribute
    public void commAttrs(Model model) {
        model.addAttribute("categories", cateService.getCates());
        model.addAttribute("Course", courseService.getCourses());
        model.addAttribute("lessons", lessonService.getLessons());
        model.addAttribute("video", videoService.getVideos());
        model.addAttribute("questions", questionService.getQuestions());
        model.addAttribute("answers", answerService.getAnswers());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("course", this.courseService.getCourses(params));
        return "home";
    }
    @RequestMapping("/lessons")
    public String lesson(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("lesson", this.lessonService.getLessons(params));
        return "lessons";
    }
    @RequestMapping("/profile")
    public String profile(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("profiles", this.profileService.getAllProfiles(params));
        return "profile"; 
    }
}
