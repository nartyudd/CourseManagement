/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.Course;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CourseRepository {
    List<Course> getCourses(Map<String, String> params);
    void addOrUpdate(Course c);
    public Course getCourseById(int id);
    void deleteCourse(int id);
    List<Course> getCourses();
}
