/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Lesson;
import com.dht.repository.LessonRepository;
import com.dht.service.LessonService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    
    @Override
    public List<Lesson> getLessons() {
        return this.lessonRepository.getLessons();
    }
    
    public List<Lesson> getLessons(Map<String, String> params) {
        return this.lessonRepository.getLessons(params);
    }

    @Override
    public void addOrUpdate(Lesson l) {
        this.lessonRepository.addOrUpdate(l);
    }
    
    @Override
    
    public Lesson getLessonById(int id){
        return this.lessonRepository.getLessonById(id);
    }
    @Override
    public void deleteLesson(int id) {
        this.lessonRepository.deleteLesson(id);
    }

}
