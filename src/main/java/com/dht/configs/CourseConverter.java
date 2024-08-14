/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.configs;

import com.dht.pojo.Course;
import com.dht.service.CourseService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Duy
 */

@Component
public class CourseConverter implements Converter<String, Course> {

    private final CourseService courseService;

    public CourseConverter(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public Course convert(String source) {
        try {
            Integer id = Integer.valueOf(source);
            return courseService.getCourseById(id);
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu cần
            return null; // Hoặc ném một ngoại lệ nếu cần
        }
    }
}


