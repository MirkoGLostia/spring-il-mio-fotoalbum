package com.example.demo.api;

import com.example.demo.exceptions.PhotoNotFoundException;
import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/photo")
@CrossOrigin
public class PhotoRestController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> photoApiList(@RequestParam Optional<String> search) {
        return photoService.getPhotoListVisible(search);
    }

    @GetMapping("/{id}")
    public Photo photoDetail(@PathVariable Integer id) {
        try {
            return photoService.getPhotoById(id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
