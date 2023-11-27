package com.example.demo.api;

import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return photoService.getPhotoList(search);
    }
}
