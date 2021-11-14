package com.example.blogapi.api;

import com.example.blogapi.dto.CategoryDTO;
import com.example.blogapi.dto.SearchCategoryDTO;
import com.example.blogapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "*")
    @GetMapping("api/category")
    public List<CategoryDTO> showCategory () {
        return categoryService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/category/search")
    public List<CategoryDTO> searchCategory (@RequestBody SearchCategoryDTO searchCategoryDTO) {
        return categoryService.searchCategory(searchCategoryDTO);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/category")
    public CategoryDTO saveCategory (@RequestBody CategoryDTO model) {
        return categoryService.save(model);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("api/category/{id}")
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.delete(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("api/category/{id}")
    public CategoryDTO updateCategory (@RequestBody CategoryDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return categoryService.update(model);
    }
}
