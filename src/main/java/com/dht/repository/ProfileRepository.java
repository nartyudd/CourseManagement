/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;


import com.dht.pojo.Profile;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zear2
 */
public interface ProfileRepository {

    Profile getProfileById(Integer id);

    List<Profile> getAllProfiles(Map<String, String> params);

    List<Profile> searchProfiles(String keyword);

    void addProfile(Profile profile);

    void updateProfile(Profile profile);

    void deleteProfile(int id);

}
