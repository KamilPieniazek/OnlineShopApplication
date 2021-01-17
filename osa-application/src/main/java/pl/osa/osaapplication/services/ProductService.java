package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.AuthorRepository;
import pl.osa.osaapplication.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AuthorRepository authorRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(final ProductForm productForm) throws IOException {
        final Product product = productMapper.toProduct(productForm);
//        try {
//            product.setImage(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        productRepository.save(product);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow();
    }


    public void updateProduct(final ProductForm productForm, final String id) {
        final Product existingProduct = getProductById(id);
        if (productForm.getTitle() != null) {
            existingProduct.setTitle(productForm.getTitle());
        }

        if (productForm.getDescription() != null) {
            existingProduct.setDescription(productForm.getDescription());
        }

//        if (productForm.getImage() != null) {
//            existingProduct.getImage(productForm.setImage(new
//                    byte[]));
//        }

        if (productForm.getPrice() != 0.0) {
            existingProduct.setPrice(productForm.getPrice());
        }

        if (productForm.getAuthorName() != null) {
            existingProduct.setAuthor(authorRepository.findAuthorByName(productForm.getAuthorName()));
        }

        if (productForm.getCategoryName() != null) {
            existingProduct.setCategory(productForm.getCategoryName());
        }
        productRepository.save(existingProduct);
    }

    public void removeProduct(final String id) {
        getProductById(id);
        productRepository.deleteById(id);
    }

    public void reduceAmount(String id, int count) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new Exception("Product not found");
        }
        Product product = optionalProduct.get();
        product.setInStock(product.getInStock() - count);
        productRepository.save(product);
    }

}
