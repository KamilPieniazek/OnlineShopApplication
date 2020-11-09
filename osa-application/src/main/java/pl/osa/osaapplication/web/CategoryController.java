package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.Category;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.model.CategoryForm;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.services.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String showCategoryView(final ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.getAllCategories());
        modelMap.addAttribute("categoryForm", new CategoryForm());

        return "categories";
    }
    @GetMapping("/products")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }


    @PostMapping("/addCategory")
    public String addProduct(@Valid @ModelAttribute(name = "categoryForm") final CategoryForm categoryForm,
                             final Errors errors) {
        if (errors.hasErrors()) {
            return "categories";
        }
        categoryService.addCategory(categoryForm);
        return "redirect:/categories";

    }
}
