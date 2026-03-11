package com.bunmetop.controller;

import com.bunmetop.service.ImageUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class ImageUploadController {

    private final ImageUploadService imageUploadService;

    public ImageUploadController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @PostMapping("/image")
    public Mono<ResponseEntity<Map<String, String>>> uploadImage(@RequestPart("file") FilePart filePart) {
        return imageUploadService.uploadImage(filePart)
                .map(url -> ResponseEntity.ok(Map.of("url", url)))
                .onErrorResume(e -> Mono.just(ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()))));
    }
}
