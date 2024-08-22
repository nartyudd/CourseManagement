/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.service;

import com.dht.pojo.Question;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Duy
 */
public interface QuestionService {
    List<Question> getQuestions(Map<String, String> params);
    void addOrUpdate(Question q);
    public Question getQuestionById(Integer id);
    void deleteQuestion(int id);
    List<Question> getQuestions();
}
