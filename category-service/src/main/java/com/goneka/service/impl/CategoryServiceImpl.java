package com.goneka.service.impl;

import com.goneka.model.Category;
import com.goneka.payload.dto.SalonDTO;
import com.goneka.repository.CategoryRepository;
import com.goneka.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {

        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setSalonId(salonDTO.getId());
        newCategory.setImage(category.getImage());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(SalonDTO salonDTO) {
        return categoryRepository.findBySalonId(salonDTO.getId());
    }


    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category == null) {
            throw new Exception("Category not exist with id" + id);
        }

        return category;
    }

    @Override
    public void deleteCategoryById(Long id, Long salonId) throws Exception {
        Category category = getCategoryById(id);
        if(category.getSalonId().equals(salonId)) {
            throw new Exception("No permission to delete category with id" + id);
        }
        categoryRepository.deleteById(id);




    }
}
