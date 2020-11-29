package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.ProductRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderLineMapper {
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;

    public OrderLine toOrder(final ProductForm productForm) {
        final OrderLine orderLine = new OrderLine();
        Optional<Product> product = productRepository.findById(productForm.getTitle());
//        Optional<Product> product1 = orderLineRepository.findByProduct(productForm.getTitle());

        orderLine.setProduct(product.get().getTitle());
        orderLine.setPrice(product.get().getPrice());
        orderLine.setQuantity(productForm.getQuantity());

        return orderLine;
    }
}
