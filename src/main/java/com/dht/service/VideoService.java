/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.service;

/**
 *
 * @author Duy
 */
import com.dht.pojo.Lesson;
import com.dht.pojo.Video;
import java.util.List;

public interface VideoService {
    void saveVideo(Video video);
    List<Video> getVideosByLessonId(Integer lessonId);
    List<Video> getVideos();
    void deleteVideo(int id);
}
