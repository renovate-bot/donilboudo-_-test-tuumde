package ca.nsidetech.tuumde.service;

import ca.nsidetech.tuumde.model.Category;
import ca.nsidetech.tuumde.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(Category category) {
        category.setSubCategory(false);
        Set<Category> subCategories = category.getSubCategories();
        if (subCategories != null)
        {
            subCategories.forEach(subCategory -> {
                subCategory.setSubCategory(true);
            });
        }
        categoryRepository.save(category);
    }

    public Iterable<Category> getCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        List<Category> filteredCategories = new ArrayList<>();
        categories.forEach(category -> {
            if (!category.isSubCategory())
            {
                filteredCategories.add(category);
            }
        });
        return filteredCategories;
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
}
