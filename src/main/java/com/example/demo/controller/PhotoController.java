package com.example.demo.controller;

import com.example.demo.exceptions.PhotoNotFoundException;
import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model) {
        model.addAttribute("area", "photo-list");
        model.addAttribute("photoList", photoService.getPhotoList(search));
        return "photos/list";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("area", "photo-detail");
        try {
            Photo photo = photoService.getPhotoById(id);
            model.addAttribute("photo", photo);
            return "photos/detail";
        } catch (PhotoNotFoundException e) {
            throw new PhotoNotFoundException(e.getMessage());
        }
    }
}
