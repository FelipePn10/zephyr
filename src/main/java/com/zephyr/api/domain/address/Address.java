package com.zephyr.api.domain.address;

import com.zephyr.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "address")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
