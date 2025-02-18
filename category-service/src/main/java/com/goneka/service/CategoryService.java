package com.goneka.service;

import com.goneka.payload.dto.SalonDTO;
import com.goneka.model.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getAllCategoriesBySalon(Long salonDTO);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id, Long salonId) throws Exception;





}
