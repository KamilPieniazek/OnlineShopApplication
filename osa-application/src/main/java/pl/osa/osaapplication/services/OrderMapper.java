package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.UserRepository;
import pl.osa.osaapplication.services.users.UserInfoService;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderLineRepository orderLineRepository;
    private UserInfoService userInfoService;
    private UserRepository userRepository;


    public Order toOrder(final OrderForm orderForm) {
        final String currentUser = userInfoService.getCurrentUser();
        User byEmail = userRepository.findByEmail(currentUser);
        List<OrderLine> byUsername = orderLineRepository.findByUsername(currentUser);

        return Order.builder()
                .username(currentUser)
                .address(byEmail.getAddress())
                .shipping_address(orderForm.getShippingAddress())
                .build();
//        final Order order = new Order();
//
//        order.setUsername(userInfoService.getCurrentUser());
//        order.setProductName(orderLineRepository.findByProduct(orderForm.getProductsName()).getProduct());
////        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
//
//
//        return order;
    }

}
