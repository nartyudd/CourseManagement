/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CourseConverter courseConverter;

    public WebConfig(CourseConverter courseConverter) {
        this.courseConverter = courseConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(courseConverter);
    }
}

