package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;

@RequiredArgsConstructor
@Component
public class ProductMapper {

    public Product toProduct(final ProductForm productForm) {
        final Product product = new Product();
        product.setTitle(productForm.getTitle());
        product.setDescription(productForm.getDescription());
        product.setAuthor(null);
        product.setImage(productForm.getImage());
        product.setType(productForm.getProductType());
        product.setPrice(productForm.getPrice());
        return product;
    }
}
