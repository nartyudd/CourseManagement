/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;


import com.dht.pojo.Course;
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
import com.dht.repository.CourseRepository;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {

    private static final int PAGE_SIZE = 4;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Course> getCourses() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Course");
        return q.getResultList();
    }

    @Override
    public List<Course> getCourses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Course> q = b.createQuery(Course.class);
        Root root = q.from(Course.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                Predicate p4 = b.equal(root.get("cateId"), Integer.parseInt(cateId));
                predicates.add(p4);
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
    public void addOrUpdate(Course c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() != null) {
            s.update(c);
        } else {
            s.save(c);
        }
    }

    @Override
    public Course getCourseById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Course.class, id);

    }

    @Override
    public void deleteCourse(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Course c = this.getCourseById(id);
        s.delete(c);
    }
}
