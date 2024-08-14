/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Course;
import com.dht.service.CourseService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dht.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Course> getCourses() {
        return this.courseRepo.getCourses();
    }
    
    public List<Course> getCourses(Map<String, String> params) {
        return this.courseRepo.getCourses(params);
    }

    @Override
    public void addOrUpdate(Course c) {
        this.courseRepo.addOrUpdate(c);
    }

    @Override
    public Course getCourseById(int id) {
        return this.courseRepo.getCourseById(id);
    }

    @Override
    public void deleteCourse(int id) {
        this.courseRepo.deleteCourse(id);
    }
    
}
