/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Profile;
import static com.dht.pojo.ProfileQuizz_.profile;
import com.dht.repository.ProfileRepository;
import com.dht.service.ProfileService;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zear2
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepo;
     @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Profile getProfileById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public List<Profile> getAllProfiles(Map<String, String> params) {
        return this.profileRepo.getAllProfiles(params);
    }

    @Override
    public List<Profile> searchProfiles(String keyword) {
        return profileRepo.searchProfiles(keyword);
    }

    @Override
    public void addProfile(Profile profile) {
        profileRepo.addProfile(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
         profileRepo.updateProfile(profile);
    }

    @Override
    public void deleteProfile(int i) {
        profileRepo.deleteProfile(i);
    }
}
