package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.model.OrderLineForm;
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

    public void createOrderLine(final OrderLineForm orderLineForm) {
        OrderLine orderLine = orderLineMapper.toOrder(orderLineForm);
        orderLineRepository.save(orderLine);
    }


    public List<OrderLine> getAllOrdersByUsername() {
        return orderLineRepository.findByUsername(userInfoService.getCurrentUser());
    }

    public void  deleteallOrderLines(){
        orderLineRepository.deleteAll();
    }


}
