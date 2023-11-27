package com.example.demo.service;

import com.example.demo.exceptions.PhotoNotFoundException;
import com.example.demo.model.Photo;
import com.example.demo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getPhotoList() {
        return photoRepository.findAll();
    }

    public List<Photo> getPhotoList(Optional<String> search) {
        if (search.isPresent()) {
            return photoRepository.findByTitleContainingIgnoreCase(search.get());
        } else {
            return photoRepository.findAll();
        }
    }

    public List<Photo> getPhotoListVisible(Optional<String> search) {
        if (search.isPresent()) {
            return photoRepository.findByTitleContainingIgnoreCaseAndVisibleTrue(search.get());
        } else {
            return photoRepository.findByVisibleTrue();
        }
    }

    public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
        Optional<Photo> result = photoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new PhotoNotFoundException("Photo with id " + id + " not found");
        }
    }

    public Photo savePhoto(Photo p) {
        p.setId(null);
        return photoRepository.save(p);
    }

    public Photo editPhoto(Photo photo) throws PhotoNotFoundException {
        Photo photoToEdit = getPhotoById(photo.getId());

        photoToEdit.setTitle(photo.getTitle());
        photoToEdit.setDescription(photo.getDescription());
        photoToEdit.setImage(photo.getImage());
        photoToEdit.setVisible(photo.getVisible());
        photoToEdit.setCategories(photo.getCategories());

        return photoRepository.save(photoToEdit);
    }

    public void deletePhoto(Integer id) {

        photoRepository.deleteById(id);

    }
}
