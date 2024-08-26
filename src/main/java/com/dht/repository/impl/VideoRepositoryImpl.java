/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

/**
 *
 * @author Duy
 */
import com.dht.pojo.Video;
import com.dht.repository.VideoRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.Query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VideoRepositoryImpl implements VideoRepository {

    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Video> getVideos() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Video");
        return q.getResultList();
    }
    
    @Override
    public void save(Video video) {
        Session session = this.factory.getObject().getCurrentSession();
        session.save(video);
    }

    @Override
    public Video findById(Integer id) {
        Session session = this.factory.getObject().getCurrentSession();
        Video video = session.get(Video.class, id);
        return video;
    }

    @Override
    public List<Video> findByLessonId(Integer lessonId) {
        Session session = this.factory.getObject().getCurrentSession();
        List<Video> videos = session.createQuery("FROM Video WHERE lesson_id = :lessonId", Video.class)
                                    .setParameter("lessonId", lessonId)
                                    .getResultList();
        return videos;
    }
    @Override
    public void deleteVideo(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Video v = this.findById(id);
        s.delete(v);
    }
}

