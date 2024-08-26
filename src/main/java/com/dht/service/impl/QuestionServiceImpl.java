/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Question;
import com.dht.repository.QuestionRepository;
import com.dht.service.QuestionService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duy
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    
    @Autowired
    private QuestionRepository questionRepo;
    
    @Override
    public List<Question> getQuestions() {
        return this.questionRepo.getQuestions();
    }
    
    public List<Question> getQuestions(Map<String, String> params) {
        return this.questionRepo.getQuestions(params);
    }

    @Override
    public void addOrUpdate(Question q) {
        this.questionRepo.addOrUpdate(q);
    }

    @Override
    public Question getQuestionById(Integer id) {
        return this.questionRepo.getQuestionById(id);
    }

    @Override
    public void deleteQuestion(int id) {
        this.questionRepo.deleteQuestion(id);
    }
}
