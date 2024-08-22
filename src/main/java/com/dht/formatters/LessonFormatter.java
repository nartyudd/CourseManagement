/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.formatters;

/**
 *
 * @author Duy
 */

import com.dht.pojo.Lesson;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

public class LessonFormatter implements Formatter<Lesson>{
    @Override
    public String print(Lesson lesson, Locale locale) {
        return String.valueOf(lesson.getId());
    }

    @Override
    public Lesson parse(String lessonId, Locale locale) throws ParseException {
        Lesson l = new Lesson();
        l.setId(Integer.parseInt(lessonId));
        
        return l;
    }
}
