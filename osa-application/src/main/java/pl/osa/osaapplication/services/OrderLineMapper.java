package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;

@Component
@RequiredArgsConstructor
public class OrderLineMapper {
    private final OrderLineRepository orderLineRepository;

    public OrderLine toOrder(final ProductForm productForm){
        final OrderLine orderLine=new OrderLine();

        orderLine.setProduct(productForm.getTitle());
        orderLine.setPrice(productForm.getPrice());
        orderLine.setQuantity(productForm.getQuantity());

        return orderLine;
    }
}
