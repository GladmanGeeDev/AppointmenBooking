package com.goneka.payload.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class SalonDTO {


    private Long id;


    private String name;

    @ElementCollection
    private List<String> images;



    private String address;


    private String phoneNumber;


    private String email;


    private String city;


    private Long ownerId;

    private UserDTO owner;


    private LocalTime openTime;


    private LocalTime closeTime;
}


