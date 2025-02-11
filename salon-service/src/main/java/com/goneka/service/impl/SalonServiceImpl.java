package com.goneka.service.impl;

import com.goneka.model.Salon;
import com.goneka.payload.dto.SalonDTO;
import com.goneka.payload.dto.UserDTO;
import com.goneka.repository.SalonRepository;
import com.goneka.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO req, UserDTO user) {

        Salon salon = new Salon();
        salon.setName(req.getName());
        salon.setAddress(req.getAddress());
        salon.setCity(req.getCity());
        salon.setEmail(req.getEmail());
        salon.setImages(req.getImages());
        salon.setOwnerId(req.getOwnerId());
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());

        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) {

        Salon existingSalon = salonRepository.findById(salonId).orElse(null);

        if (existingSalon != null && salon.getOwnerId().equals(user.getId())) {
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setCity(salon.getCity());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOwnerId(salon.getOwnerId());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());

            // ✅ Save and return the updated salon
            return salonRepository.save(existingSalon);
        }

        throw new RuntimeException("Salon not found or Unauthorized");
    }


    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon == null) {
            throw new RuntimeException("Salon not found");
        } else {
            return salon;
        }
    }

    @Override
    public Salon getSalonByOwner(Long ownerId) {
        return null;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return (Salon) salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
