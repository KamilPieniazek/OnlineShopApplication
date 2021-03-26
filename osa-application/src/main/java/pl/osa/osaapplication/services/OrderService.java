package pl.osa.osaapplication.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.model.OrderStatus;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.OrderRepository;
import pl.osa.osaapplication.repositories.ProductRepository;
import pl.osa.osaapplication.repositories.UserRepository;
import pl.osa.osaapplication.services.users.UserInfoService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserInfoService userInfoService;
    private final OrderLineRepository orderLineRepository;
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public Order submitOrder() throws Exception {
        User currentUser = userInfoService.getCurrentUser().get();

        List<OrderLine> cartLines = orderLineRepository.findByUsernameAndOrderIsNull(currentUser.getEmail());
        Order order = new Order();
        order.setUsername(currentUser.getEmail());
        order.setStatus(OrderStatus.PLACED);
        order.setShipping_address(currentUser.getAddress() + " " + currentUser.getCity());
        order.setTotalPrice(CalculateTotalPrice(cartLines));
        orderRepository.save(order);

        for (OrderLine Line : cartLines) {
            Line.setOrder(order);
            productService.reduceAmount(Line.getProduct(), Line.getQuantity().intValue());
        }

        orderLineRepository.saveAll(cartLines);
        return order;
    }

    public double CalculateTotalPrice(final List<OrderLine> cartLines) {
        return cartLines.stream()
                .map(line -> line.getPrice() * line.getQuantity())
                .reduce(0.0, (acc, curr) -> acc + curr);
    }

    public void changeOrderStatus(final OrderForm orderForm, final Long id) {
        final Order order = orderRepository.getOne(id);
        order.setStatus(orderForm.getOrderStatus());

        orderRepository.save(order);
    }
}
