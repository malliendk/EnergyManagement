package com.dillian.energymanagement.utils;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@AllArgsConstructor
public class ImageCreator {

    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get("photos", imageName + ".png");
            if (Files.exists(imagePath) && Files.isReadable(imagePath)) {
                byte[] image = Files.readAllBytes(imagePath);
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

