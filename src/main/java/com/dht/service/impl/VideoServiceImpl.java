/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

/**
 *
 * @author Duy
 */
import com.dht.pojo.Video;
import com.dht.repository.VideoRepository;
import com.dht.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepo;
    
    
    @Override
    public List<Video> getVideos() {
        return this.videoRepo.getVideos();
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveVideo(Video video) {
        videoRepo.save(video);
    }

    @Override
    public List<Video> getVideosByLessonId(Integer lessonId) {
        return videoRepo.findByLessonId(lessonId);
    }
    @Override
    public void deleteVideo(int id) {
        this.videoRepo.deleteVideo(id);
    }
}

