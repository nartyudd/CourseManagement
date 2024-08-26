/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Profile;
import com.dht.repository.ProfileRepository;
import com.dht.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zear2
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public String listProfiles(Model model, @RequestParam(value = "q", required = false) String keyword) {
        List<Profile> profiles = profileService.searchProfiles(keyword);
        model.addAttribute("profiles", profiles);
        model.addAttribute("action", "list"); // Thêm thuộc tính action để xác định hành động đang thực hiện
        return "profile"; // Điều hướng đến file profile.jsp
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Profile profile;
        if (id != null) {
            profile = profileService.getProfileById(id);
            model.addAttribute("action", "edit");
        } else {
            profile = new Profile();
            model.addAttribute("action", "add");
        }
        model.addAttribute("profile", profile);
        return "profile"; // Điều hướng đến file profile.jsp
    }

    @PostMapping("/save")
    public String saveProfile(@ModelAttribute("profile") Profile profile, @RequestParam("action") String action,@RequestParam(value = "id", required = false) Integer id) {
        if ("edit".equals(action)  && id != null ) {
             profile.setId(id);
            profileService.updateProfile(profile);
        } else if ("add".equals(action)) {
            profileService.addProfile(profile);
        } else {
            // Xử lý lỗi nếu action không hợp lệ
            return "error"; // Đưa đến trang lỗi nếu action không hợp lệ
        }
        return "redirect:/profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteProfile(@PathVariable("id") int id) {
        profileService.deleteProfile(id);
        return "redirect:/profile";
    }
}

