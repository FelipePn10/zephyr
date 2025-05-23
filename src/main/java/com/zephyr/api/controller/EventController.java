package com.zephyr.api.controller;

import com.zephyr.api.domain.event.Event;
import com.zephyr.api.domain.event.EventRequestDTO;
import com.zephyr.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;

    public ResponseEntity<Event> create(@RequestBody EventRequestDTO body) {
        Event newEvent = this.eventService.createEvent(body);
        return ResponseEntity.ok(newEvent);
    }
}
