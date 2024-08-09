/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service;

import com.dht.pojo.Quizz;
import java.util.List;
import java.util.Map;

public interface QuizzService {
    List<Quizz> getQuizz(Map<String, String> params);
    void addOrUpdate(Quizz c);
    public Quizz getQuizzById(int id);
    void deleteQuizz(int id);
}
