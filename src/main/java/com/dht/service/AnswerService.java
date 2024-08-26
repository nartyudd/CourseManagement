/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.service;

import com.dht.pojo.Answer;
import com.dht.pojo.Question;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Duy
 */
public interface AnswerService {
    List<Answer> getAnswers(Map<String, String> params);
    void addOrUpdate(Answer a);
    public Answer getAnswerById(int id);
    void deleteAnswer(int id);
    List<Answer> getAnswers();
    List<Answer> findByQuestionId(Integer questionId);
}
