/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.EagerTransformation;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Answer;
import static com.dht.pojo.Answer_.questionId;
import com.dht.pojo.Lesson;
import com.dht.pojo.Question;
import com.dht.pojo.Video;
import com.dht.service.AnswerService;
import com.dht.service.CourseService;
import com.dht.service.LessonService;
import com.dht.service.QuestionService;
import com.dht.service.VideoService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Duy
 */
@Controller
@ControllerAdvice
public class LessonController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/lessons")
    public String createView(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "lessons";
    }

    @PostMapping("/lessons")
    public String createView(Model model,
            @ModelAttribute(value = "lesson") @Valid Lesson l,
            @ModelAttribute(value = "questions") @Valid Question q,
            BindingResult rs,
            @RequestParam("courseId") Integer courseId,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam Map<String, String> params) {

        if (rs.hasErrors()) {
            return "lessons";
        }

        try {
            // Cập nhật hoặc thêm bài giảng
            this.lessonService.addOrUpdate(l);

            Questions(l, params);
            // Xử lý video nếu có
            if (file != null && !file.isEmpty()) {
                String contentType = file.getContentType();
                if (contentType == null || !contentType.startsWith("video/")) {
                    throw new RuntimeException("Invalid file type. Please upload a valid video.");
                }

                Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                        "resource_type", "video",
                        "public_id", "video_" + UUID.randomUUID().toString() + "_" + l.getId()
                ));
                String videoUrl = (String) uploadResult.get("url");

                Video video = new Video();
                video.setUrl(videoUrl);
                Lesson lesson = lessonService.getLessonById(l.getId());
                video.setLessonId(lesson);
                this.videoService.saveVideo(video);
            }

            return "redirect:/lessons/" + l.getId();
        } catch (IOException e) {
            model.addAttribute("errMsg", "Failed to upload video: " + e.getMessage());
            return "lessons";
        } catch (RuntimeException e) {
            model.addAttribute("errMsg", "Invalid file: " + e.getMessage());
            return "lessons";
        }
    }

    private void Questions(Lesson lesson, Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            // Xử lý câu hỏi
            if (key.startsWith("questionContent")) {
                try {
                    Integer questionId = Integer.parseInt(key.replace("questionContent[", "").replace("]", ""));
                    Question question = questionService.getQuestionById(questionId);

                    if (question == null) {
                        // Nếu câu hỏi không tồn tại, tạo mới
                        question = new Question();
                        question.setLessonId(lesson);
                    }

                    question.setContent(value);
                    this.questionService.addOrUpdate(question);
                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi parse số
                    throw new RuntimeException("Invalid question ID format: " + key, e);
                }
            }
        }
        Answer(params);
    }

    private void Answer(Map<String, String> allParams) {
        for (Map.Entry<String, String> ansEntry : allParams.entrySet()) {
            String ansKey = ansEntry.getKey();
            String ansValue = ansEntry.getValue();

            if (ansKey.startsWith("answerContent")) {
                try {
                    // Tách ID của câu hỏi và đáp án từ key
                    String[] parts = ansKey.split("\\[|\\]");
                    if (parts.length < 2) {
                        throw new RuntimeException("Invalid answer key format: " + ansKey);
                    }

                    // Xử lý trường hợp không có phần tử thứ hai
                    String[] idParts = parts[1].split("_");
                    Integer questionId = null;
                    Integer answerId = null;

                    if (idParts.length == 2) {
                        questionId = Integer.parseInt(idParts[0]);
                        answerId = Integer.parseInt(idParts[1]);
                    } else if (idParts.length == 1) {
                        // Trường hợp chỉ có answerId mà không có questionId
                        answerId = Integer.parseInt(idParts[0]);
                    } else {
                        throw new RuntimeException("Invalid answer ID format: " + ansKey);
                    }

                    // Tìm câu hỏi và đáp án tương ứng
                    Question question = (questionId != null) ? questionService.getQuestionById(questionId) : null;
                    Answer answer = answerService.getAnswerById(answerId);

                    // Nếu đáp án không tồn tại, tạo mới
                    if (answer == null) {
                        answer = new Answer();
                        if (question != null) {
                            answer.setQuestionId(question);
                        }
                    }

                    // Cập nhật nội dung đáp án
                    answer.setContent(ansValue);

                    // Kiểm tra nếu đáp án là đúng
                    String isCorrectFlag = allParams.get("isCorrect[" + (questionId != null ? questionId + "_" : "") + answerId + "]");
                    boolean isCorrect = "on".equals(isCorrectFlag);
                    answer.setIsCorrect(isCorrect);

                    // Lưu hoặc cập nhật đáp án
                    answerService.addOrUpdate(answer);

                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi phân tích số
                    throw new RuntimeException("Invalid number format in answer ID: " + ansKey, e);
                } catch (RuntimeException e) {
                    // Xử lý lỗi định dạng không hợp lệ
                    throw new RuntimeException("Invalid answer key format: " + ansKey, e);
                }
            }
        }
    }

    @GetMapping("/lessons/{lessonId}")
    public String detailsView(Model model, @PathVariable(value = "lessonId") int id) {
        model.addAttribute("lesson", this.lessonService.getLessonById(id));
        return "lessons";
    }

}
