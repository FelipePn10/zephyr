package com.zephyr.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.zephyr.api.domain.event.Event;
import com.zephyr.api.domain.event.EventRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class EventService {
    @Value("${aws.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3;

    public Event createEvent(EventRequestDTO data) {
        String imageUrl = null;
        if (data.imageUrl() != null) {
            MultipartFile file = data.imageUrl();
            imageUrl = this.uploadImg(file);
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(String.valueOf(new Date(data.date())));
        newEvent.setImageUrl(imageUrl);

        return newEvent;
    }

    private String uploadImg(MultipartFile file) {
        String imageName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        try {
            File convertedFile = this.convertMultipartToFile(file);
            // Upload the file to S3
            s3.putObject(bucketName, imageName, convertedFile);
            return s3.getUrl(bucketName, imageName).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(multipartFile.getBytes());
        }
        return convertedFile;
    }
}