package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.AuthorRepository;
import pl.osa.osaapplication.repositories.StockRepository;

@RequiredArgsConstructor
@Component
public class ProductMapper {
    private final AuthorRepository authorRepository;
    private final StockRepository stockRepository;

    public Product toProduct(final ProductForm productForm) {
        final Product product = new Product();
        product.setTitle(productForm.getTitle());
        product.setDescription(productForm.getDescription());
        product.setAuthor(authorRepository.findAuthorByName(productForm.getAuthorName()));
        product.setImage(productForm.getImage());
        product.setType(productForm.getProductType());
        product.setPrice(productForm.getPrice());
        product.setCategory(productForm.getCategoryName());
        product.setInStock(productForm.getQuantity().intValue());
      //  product.setQuantity(productForm.getQuantity());
        return product;
    }
}
