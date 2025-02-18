package com.goneka.controller;


import com.goneka.mapper.SalonMapper;
import com.goneka.model.Salon;
import com.goneka.payload.dto.SalonDTO;
import com.goneka.payload.dto.UserDTO;
import com.goneka.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor

public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO, userDTO);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PatchMapping("/{salonId}")
    public ResponseEntity<SalonDTO> updateSalon(
        @PathVariable("salonId") Long salonId,
        @RequestBody SalonDTO salonDTO) throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<SalonDTO>> getSalons() throws Exception {

//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(1L);
        List<Salon> salons = salonService.getAllSalons();

        List<SalonDTO> salonDTOS = salons.stream().map((salon)->
        {
            SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
            return salonDTO;
        }).toList();

        return ResponseEntity.ok(salonDTOS);

    }


    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getSalonById(
        @PathVariable Long salonId
    ) throws Exception {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(1L);
        Salon salon = salonService.getSalonById(salonId);

        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO);

    }


    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalon(
        @RequestParam String city
    ) throws Exception {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(1L);
        List<Salon> salons = salonService.searchSalonByCity(city);

        List<SalonDTO> salonDTOS = salons.stream().map((salon)->
        {
            SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
            return salonDTO;
        }).toList();

        return ResponseEntity.ok(salonDTOS);

    }


    public ResponseEntity<SalonDTO> getSalonByOwnerId(
        @PathVariable Long ownerId
    ) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.getSalonByOwnerId(ownerId);
        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }









}
