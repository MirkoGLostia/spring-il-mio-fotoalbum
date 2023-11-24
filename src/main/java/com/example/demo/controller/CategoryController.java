package com.example.demo.controller;

import com.example.demo.exceptions.CategoryNameUniqueException;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Photo;
import com.example.demo.service.CategoryService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showCategories(Model model) {
        model.addAttribute("area", "category-list");
        model.addAttribute("categoryList", categoryService.getAllCategories());
        model.addAttribute("category", new Category());
        return "categories/managerCat";
    }

    @PostMapping("/create")
    public String newCategory(Model model, @Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("area", "category-list");
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "categories/managerCat";
        }
        try {

            categoryService.saveCategory(formCategory);
            return "redirect:/category";
        } catch (CategoryNameUniqueException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The category " + e.getMessage() + " already exists");
        }

    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Category categoryToDelete = categoryService.getCategoryById(id);
            categoryService.deleteCategory(id);
            redirectAttributes.addFlashAttribute("message",
                    "Category " + categoryToDelete.getName() + " deleted!");
            return "redirect:/category";
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
