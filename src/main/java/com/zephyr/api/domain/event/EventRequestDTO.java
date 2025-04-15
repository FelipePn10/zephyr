package com.zephyr.api.domain.event;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

public record EventRequestDTO(
        String title,
        String description,
        Long date,
        String city,
        String state,
        String country,
        Number zip,
        String address,
        String email,
        String phone,
        String eventUrl,
        MultipartFile imageUrl,
        Boolean remote,
        UUID eventId
) {

}
