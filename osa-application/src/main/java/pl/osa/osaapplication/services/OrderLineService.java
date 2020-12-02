package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.services.users.UserInfoService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper orderLineMapper;

    private final UserInfoService userInfoService;

    public void createOrderLine(final ProductForm productForm) {
        final OrderLine orderLine = orderLineMapper.toOrder(productForm);
        orderLineRepository.save(orderLine);
    }


    public List<OrderLine> getAllOrdersByUsername() {
        return orderLineRepository.findByUsername(userInfoService.getCurrentUser());
    }



}
