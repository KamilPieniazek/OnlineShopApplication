package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderLineRepository orderLineRepository;


    public Order toOrder(OrderForm orderForm) {
        final Order order = new Order();

        order.setProductName(orderLineRepository.findByProduct(orderForm.getProductsName()).getProduct());
//        Optional<OrderLine> orderLine = orderLineRepository.findById(id);


        return order;
    }

}
