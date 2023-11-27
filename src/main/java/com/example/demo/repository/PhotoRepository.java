package com.example.demo.repository;

import com.example.demo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findByTitleContainingIgnoreCase(String x);

    List<Photo> findByTitleContainingIgnoreCaseAndVisibleTrue(String x);

    List<Photo> findByVisibleTrue();

}
