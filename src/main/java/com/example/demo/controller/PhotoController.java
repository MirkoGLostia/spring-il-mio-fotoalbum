package com.example.demo.controller;

import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("photoList", photoService.getPhotoList());
        return "photos/list";
    }
}
