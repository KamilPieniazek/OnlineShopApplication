package pl.osa.osaapplication.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.Category;
import pl.osa.osaapplication.model.CategoryForm;
import pl.osa.osaapplication.repositories.CategoryRepository;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    private final CategoryRepository categoryRepository;

    public Category toCategory(final CategoryForm categoryForm) {
        final Category category = new Category();

        category.setName(categoryForm.getName());
        category.setParentName(category.getParentName());

        return category;
    }
}
