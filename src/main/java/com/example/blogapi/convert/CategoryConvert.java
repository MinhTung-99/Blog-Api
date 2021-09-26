package com.example.blogapi.convert;

import com.example.blogapi.dto.CategoryDTO;
import com.example.blogapi.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConvert {

    public CategoryEntity toEntity (CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDTO.getName());

        return categoryEntity;
    }

    public CategoryDTO toDTO (CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setId(categoryEntity.getId());

        return categoryDTO;
    }
}
