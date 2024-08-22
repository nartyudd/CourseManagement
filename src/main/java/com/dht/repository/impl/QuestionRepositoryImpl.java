/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Answer;
import com.dht.pojo.Question;
import com.dht.repository.QuestionRepository;
import com.dht.service.AnswerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Duy
 */
@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository {

    private static final int PAGE_SIZE = 4;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private AnswerService answerService;

    @Override
    public List<Question> getQuestions() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Question");
        return q.getResultList();
    }

    @Override
    public List<Question> getQuestions(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Question> q = b.createQuery(Question.class);
        Root root = q.from(Question.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("content"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }
            q.where(predicates.toArray(new Predicate[0]));
        }
        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }

        return query.getResultList();
    }

    @Override
    public void addOrUpdate(Question q) {
        Session s = this.factory.getObject().getCurrentSession();

        if (q.getId() != null) {
            s.update(q); // Thay vì dùng s.update(q)
        } else {
            s.save(q);
        }
    }

    @Override
    public Question getQuestionById(Integer id) {
        Session s = this.factory.getObject().getCurrentSession();
        Question question = s.get(Question.class, id);
        return question;
    }

    @Override
    public void deleteQuestion(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Question q = this.getQuestionById(id);
        List<Answer> answers = answerService.findByQuestionId(id);
        for (Answer answer : answers) {
            s.delete(answer);
        }
        s.delete(q);
    }
}
