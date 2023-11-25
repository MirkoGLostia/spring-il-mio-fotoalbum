package com.example.demo.controller;

import com.example.demo.exceptions.PhotoNotFoundException;
import com.example.demo.model.Photo;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model) {
        List<Photo> photo = photoService.getPhotoList(search);
        model.addAttribute("area", "photo-list");
        model.addAttribute("photoList", photo);
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

    @GetMapping("create")
    public String createPhoto(Model model) {
        model.addAttribute("area", "photo-create");
        model.addAttribute("photo", new Photo());
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "photos/createEdit";
    }

    @PostMapping("create")
    public String doCreatePhoto(Model model, @Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("area", "photo-create");
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "photos/createEdit";
        }


        Photo savedPhoto = photoService.savePhoto(formPhoto);
        return "redirect:/detail/" + savedPhoto.getId();
    }

    @GetMapping("edit/{id}")
    public String editPhoto(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("area", "photo-create");
            model.addAttribute("photo", photoService.getPhotoById(id));
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "photos/createEdit";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }



    @PostMapping("edit/{id}")
    public String doEditPhoto(Model model, @PathVariable Integer id, @Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("area", "photo-create");
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "photos/createEdit";
        }
        try {
            Photo editPhoto = photoService.editPhoto(formPhoto);
            return "redirect:/detail/" + editPhoto.getId();
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    @PostMapping("delete/{id}")
    public String deletePhoto(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Photo photoToDelete = photoService.getPhotoById(id);
            photoService.deletePhoto(id);
            redirectAttributes.addFlashAttribute("message",
                    photoToDelete.getTitle() + " deleted!");
            return "redirect:/";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
