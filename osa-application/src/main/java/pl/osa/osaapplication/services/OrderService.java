package pl.osa.osaapplication.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.OrderStatus;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.OrderRepository;
import pl.osa.osaapplication.repositories.ProductRepository;
import pl.osa.osaapplication.repositories.UserRepository;
import pl.osa.osaapplication.services.users.UserInfoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserInfoService userInfoService;
    private final OrderLineRepository orderLineRepository;
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public Order submitOrder() throws Exception{
        String currentUser = userInfoService.getCurrentUser();
        List<OrderLine> cartLines = orderLineRepository.findByUsernameAndOrderIsNull(currentUser);
        User userInfo=userRepository.findByEmail(userInfoService.getCurrentUser());

        Order order = new Order();
        order.setUsername(currentUser);
        order.setStatus(OrderStatus.PLACED);
        order.setShipping_address(userInfo.getAddress()+" "+userInfo.getCity());
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


}
