package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public void createOrder(final OrderForm orderForm, final ProductForm productForm, final UserForm userForm) {
        final Order order = orderMapper.toOrder(orderForm,productForm,userForm);
        orderRepository.save(order);
    }


}
