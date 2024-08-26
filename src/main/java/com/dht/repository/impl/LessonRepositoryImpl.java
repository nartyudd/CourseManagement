/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Course;
import com.dht.pojo.Lesson;
import com.dht.pojo.Video;
import com.dht.repository.LessonRepository;
import com.dht.service.VideoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;
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
public class LessonRepositoryImpl implements LessonRepository {

    private static final int PAGE_SIZE = 4;

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private VideoService videoService;
    @Override
    public List<Lesson> getLessons() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Lesson");
        return q.getResultList();
    }
    
    @Override
    public List<Lesson> getLessons(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Lesson> q = b.createQuery(Lesson.class);
        Root root = q.from(Lesson.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }
            String courseId = params.get("courseId");
            if (courseId != null && !courseId.isEmpty()) {
                Predicate p2 = b.equal(root.get("courseId"), Integer.parseInt(courseId));
                predicates.add(p2);
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
    public void addOrUpdate(Lesson l) {
        Session s = this.factory.getObject().getCurrentSession();
        if (l.getId() != null) {
            s.update(l);
        } else {
            s.save(l);
        }
    }

    @Override
    public Lesson getLessonById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Lesson.class, id);
    }

    @Override
    public void deleteLesson(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Lesson c = this.getLessonById(id);
        List<Video> videos = this.videoService.getVideosByLessonId(id);
        for (Video video : videos) {
        video.setLessonId(null);
        s.update(video);
    }
        s.delete(c);
    }
}
