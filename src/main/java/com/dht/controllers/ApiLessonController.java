/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.service.LessonService;
import com.dht.service.QuestionService;
import com.dht.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duy
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiLessonController {
    @Autowired
    private LessonService lessonService;
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private QuestionService questionService;
    
    @DeleteMapping("/lessons/{lessonId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "lessonId") int id) {
        this.lessonService.deleteLesson(id);
    }
    @DeleteMapping("/video/{videoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVideo(@PathVariable(value = "videoId") int id) {
        this.videoService.deleteVideo(id);
    }
    @DeleteMapping("/question/{questionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable(value = "questionId") int id) {
        this.questionService.deleteQuestion(id);
    }
}
