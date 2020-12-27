package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.AuthorRepository;
import pl.osa.osaapplication.repositories.StockRepository;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class ProductMapper {
    private final AuthorRepository authorRepository;
    private final StockRepository stockRepository;

    public Product toProduct(final ProductForm productForm) throws IOException {
        final Product product = new Product();

        product.setTitle(productForm.getTitle());
        product.setDescription(productForm.getDescription());
        product.setAuthor(authorRepository.findAuthorByName(productForm.getAuthorName()));
        product.setType(productForm.getProductType());
        product.setImage(productForm.getImage().getBytes());
        product.setPrice(productForm.getPrice());
        product.setCategory(productForm.getCategoryName());
        product.setInStock(productForm.getQuantity().intValue());

        return product;
    }


}
