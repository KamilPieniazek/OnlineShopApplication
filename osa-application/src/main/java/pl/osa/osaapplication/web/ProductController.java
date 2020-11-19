package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.Author;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.AuthorRepository;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.services.OrderLineService;
import pl.osa.osaapplication.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    private final AuthorRepository authorRepository;

    private final OrderLineService orderLineService;

    @GetMapping
    public String showProductsView(final ModelMap modelMap) {
        modelMap.addAttribute("products", productService.getAllProducts());
        modelMap.addAttribute("productForm", new ProductForm());
        modelMap.addAttribute("authors", authorRepository.findAll());

        return "products";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @RequestMapping(value = "/addProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public String addProduct(@Valid @ModelAttribute(name = "productForm") final ProductForm productForm,
                             final Errors errors) {

        if (errors.hasErrors()) {
            return "products";
        }
        productService.addProduct(productForm);
        return "redirect:/products";
    }


    @GetMapping(value = "/details/{title}")
    @RequestMapping(value = "/details/{title}", method = {RequestMethod.GET, RequestMethod.POST})
    public String getProduct(@PathVariable final String title, ModelMap model) {

        Product product = productService.getProductById(title);
        model.addAttribute("product_details",product);
        return "product_details";
    }

    @RequestMapping(value = "/details/{title}/addToChart", method = {RequestMethod.GET, RequestMethod.POST})
    public String createOrderLine(final ProductForm productForm) {
        orderLineService.createOrderLine(productForm);
        return "redirect:/products/details/{title}";
    }


    @RequestMapping(value = "/details/{title}/update", method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})

    public String updateProduct(@PathVariable final String title, @Valid @ModelAttribute(name = "productForm") final ProductForm productForm, final Errors errors) {
        if (errors.hasErrors()) {
            return "product_details";
        }

        productService.updateProduct(productForm, title);
        return "redirect:/products";
    }


    @RequestMapping(value = "/details/{title}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteProduct(@PathVariable final String title) {
        productService.removeProduct(title);
        return "redirect:/products";
    }


}
