package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.Author;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.AuthorRepository;
import pl.osa.osaapplication.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    private final AuthorRepository authorRepository;

    @GetMapping
    public String showUsersView(final ModelMap modelMap) {
        modelMap.addAttribute("products", productService.getAllProducts());
        modelMap.addAttribute("productForm", new ProductForm());
        modelMap.addAttribute("authors",authorRepository.findAll());

        return "products";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
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



    @RequestMapping(value = "/{title}")
    public Product getProduct(@PathVariable(name = "title") final String title) {
        return productService.getProductByName(title);
    }
}
