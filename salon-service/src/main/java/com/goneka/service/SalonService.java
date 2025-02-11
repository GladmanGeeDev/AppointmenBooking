package com.goneka.service;

import com.goneka.model.Salon;
import com.goneka.payload.dto.SalonDTO;
import com.goneka.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId);

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwner(Long ownerId);

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);




}
