package com.dillian.energymanagement.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageCreationService {

    public byte[] getImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get("photos", imageName + ".png");
            if (Files.exists(imagePath) && Files.isReadable(imagePath)) {
                return Files.readAllBytes(imagePath);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error in getImage method");
        }
    }
}

