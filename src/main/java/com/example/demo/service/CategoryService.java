package com.example.demo.service;

import com.example.demo.exceptions.CategoryNameUniqueException;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Photo;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PhotoRepository photoRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findByOrderByName();
    }

    public Category saveCategory(Category category) throws CategoryNameUniqueException{
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryNameUniqueException(category.getName());
        }

        category.setName(category.getName().toLowerCase());

        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new CategoryNotFoundException("Category with id " + id + " not found");
        }
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.getReferenceById(id);

        for (Photo o : category.getPhotos()) {
            Set<Category> x = o.getCategories();
            x.remove(category);
        }
        categoryRepository.deleteById(id);
    }
}
