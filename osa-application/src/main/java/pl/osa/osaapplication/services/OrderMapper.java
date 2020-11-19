package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.Product;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.OrderRepository;
import pl.osa.osaapplication.repositories.ProductRepository;
import pl.osa.osaapplication.repositories.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class OrderMapper {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Order toOrder(final OrderForm orderForm, final ProductForm productForm, final UserForm userForm) {
        final Order order = new Order();
        Optional<Product> product = productRepository.findById(productForm.getTitle());
        Optional<User> user = userRepository.findById(userForm.getEmail());


        order.setUsername(user.get().getEmail());
        order.setTotalPrice(product.get().getPrice());
        order.setClientAdrress(user.get().getAddress());


        return order;
    }
}
