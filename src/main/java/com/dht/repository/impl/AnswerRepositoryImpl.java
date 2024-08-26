/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Answer;
import com.dht.pojo.Question;
import com.dht.repository.AnswerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
public class AnswerRepositoryImpl implements AnswerRepository{
    private static final int PAGE_SIZE = 4;

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Answer> getAnswers() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Answer");
        return q.getResultList();
    }
    
    @Override
    public List<Answer> getAnswers(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Answer> a = b.createQuery(Answer.class);
        Root root = a.from(Answer.class);
        a.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("a");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }
            a.where(predicates.toArray(new Predicate[0]));
        }
        Query query = s.createQuery(a);

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
    public void addOrUpdate(Answer a) {
        Session s = this.factory.getObject().getCurrentSession();
        if (a.getId() != null) {
            s.merge(a);
        } else {
            s.save(a);
        }
    }

    @Override
    public Answer getAnswerById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Answer.class, id);
    }
    
    @Override
    public List<Answer> findByQuestionId(Integer questionId) {
        Session session = this.factory.getObject().getCurrentSession();
        List<Answer> videos = session.createQuery("FROM Answer WHERE question_id = :questionId", Answer.class)
                                    .setParameter("questionId", questionId)
                                    .getResultList();
        return videos;
    }
    
    @Override
    public void deleteAnswer(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Answer a = this.getAnswerById(id);
        s.delete(a);
    }
    
}
