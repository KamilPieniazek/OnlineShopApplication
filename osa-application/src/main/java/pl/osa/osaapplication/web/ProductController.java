package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.ProductService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public String showUsersView(final ModelMap modelMap) {
        modelMap.addAttribute("products", productService.getAllProducts());
        modelMap.addAttribute("productForm", new ProductForm());
        return "products";
    }

    @RequestMapping(value = "/addProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public String addProduct(@Valid @ModelAttribute(name = "productForm") final ProductForm productForm,
                             final Errors errors) {
        if (errors.hasErrors()) {
            return "/products";
        }
        productService.addProduct(productForm);
        return "redirect:/products";
    }
}
