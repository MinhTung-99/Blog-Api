package com.example.blogapi.service;

import com.example.blogapi.convert.CategoryConvert;
import com.example.blogapi.dto.CategoryDTO;
import com.example.blogapi.dto.SearchCategoryDTO;
import com.example.blogapi.entity.CategoryEntity;
import com.example.blogapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConvert categoryConvert;

    public CategoryDTO save (CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConvert.toEntity(categoryDTO);
        categoryEntity = categoryRepository.save(categoryEntity);

        return categoryConvert.toDTO(categoryEntity);
    }

    public CategoryDTO update (CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConvert.toEntity(categoryDTO);
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity = categoryRepository.save(categoryEntity);

        return categoryConvert.toDTO(categoryEntity);
    }

    public void delete (Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> findAll() {
        List<CategoryDTO> results = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll();

        for(CategoryEntity item : entities) {
            CategoryDTO categoryDTO = categoryConvert.toDTO(item);
            results.add(categoryDTO);
        }

        return results;
    }

    public List<CategoryDTO> searchCategory(SearchCategoryDTO searchCategoryDTO) {
        List<CategoryDTO> results = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll();

        for(CategoryEntity item : entities) {
            if (item.getName().contains(searchCategoryDTO.getTitle())) {
                CategoryDTO categoryDTO = categoryConvert.toDTO(item);
                results.add(categoryDTO);
            }
        }

        return results;
    }
}
