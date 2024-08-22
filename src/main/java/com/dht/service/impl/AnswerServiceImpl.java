/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Answer;
import com.dht.pojo.Question;
import com.dht.repository.AnswerRepository;
import com.dht.service.AnswerService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duy
 */
@Service
public class AnswerServiceImpl implements AnswerService{
    
    @Autowired
    private AnswerRepository answerRepo;
    
    @Override
    public List<Answer> getAnswers() {
        return this.answerRepo.getAnswers();
    }
    
    @Override
    public List<Answer> getAnswers(Map<String, String> params) {
        return this.answerRepo.getAnswers(params);
    }

    @Override
    public void addOrUpdate(Answer a) {
        this.answerRepo.addOrUpdate(a);
    }

    @Override
    public Answer getAnswerById(int id) {
        return this.answerRepo.getAnswerById(id);
    }

    @Override
    public void deleteAnswer(int id) {
        this.answerRepo.deleteAnswer(id);
    }
    
    @Override
    public List<Answer> findByQuestionId(Integer questionId) {
        return answerRepo.findByQuestionId(questionId);
    }
}
