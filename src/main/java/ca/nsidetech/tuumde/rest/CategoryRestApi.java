package ca.nsidetech.tuumde.rest;

import ca.nsidetech.tuumde.model.Category;
import ca.nsidetech.tuumde.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryRestApi {
    private CategoryService categoryService;

    @Autowired
    public CategoryRestApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/categories")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @GetMapping(value = "/categories")
    public Iterable<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(value = "/categories/{id}")
    public Category findCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id).orElse(null);
    }

    @PutMapping(value = "/categories")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }
}
