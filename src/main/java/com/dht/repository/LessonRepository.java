/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.Lesson;
import java.util.List;
import java.util.Map;

public interface LessonRepository{
    List<Lesson> getLessons(Map<String, String> params);
    void addOrUpdate(Lesson l);
    public Lesson getLessonById(int id);
    void deleteLesson(int id);
    List<Lesson> getLessons();
}
