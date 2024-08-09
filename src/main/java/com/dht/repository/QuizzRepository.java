/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java 
 */
package com.dht.repository;

import com.dht.pojo.Quizz;
import java.util.List;
import java.util.Map;

public interface QuizzRepository{
    List<Quizz> getQuizz(Map<String, String> params);
    void addOrUpdate(Quizz c);
    public Quizz getQuizzById(int id);
    void deleteQuizz(int id);
}
