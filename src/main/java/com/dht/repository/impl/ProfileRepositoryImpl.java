/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Profile;
import com.dht.repository.ProfileRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zear2
 */
@Repository
@Transactional
public class ProfileRepositoryImpl implements ProfileRepository {

    
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Profile getProfileById(Integer id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Profile.class, id);
    }

    @Override
    public List<Profile> getAllProfiles(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        query.select(root);
        
        // Additional filtering logic can be applied here using params if needed
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Profile> searchProfiles(String keyword) {
        String query = "FROM Profile WHERE fullName LIKE :keyword OR email LIKE :keyword OR phone LIKE :keyword";
        return sessionFactory.getCurrentSession().createQuery(query, Profile.class)
                .setParameter("keyword", "%" + keyword + "%").list();

    }

    @Override
    public void addProfile(Profile profile) {
         Session session = sessionFactory.getCurrentSession();
        session.save(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        Session session = sessionFactory.getCurrentSession();
        session.update(profile);
    }

    @Override
    public void deleteProfile(int i) {
        Session session = sessionFactory.getCurrentSession();
        Profile profile = session.get(Profile.class, i);
        if (profile != null) {
            session.delete(profile);
        }
    }
}
