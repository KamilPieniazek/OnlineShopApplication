package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.model.OrderStatus;
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
    private final UserInfoService userInfoService;


    public Order toOrder(final OrderForm orderForm) {
        final User currentUser = userInfoService.getCurrentUser().get();;


        return Order.builder()
                .username(currentUser.getEmail())
                .address(currentUser.getAddress())
                .shipping_address(orderForm.getShippingAddress())
                .status(OrderStatus.PLACED)
                .build();

    }

}
