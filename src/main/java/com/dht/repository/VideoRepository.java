/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

/**
 *
 * @author Duy
 */
import com.dht.pojo.Video;
import java.util.List;
import org.springframework.stereotype.Repository;


public interface VideoRepository{
    void save(Video video);
    Video findById(Integer id);
    List<Video> findByLessonId(Integer lessonId);
    List<Video> getVideos();
    void deleteVideo(int id);
}

