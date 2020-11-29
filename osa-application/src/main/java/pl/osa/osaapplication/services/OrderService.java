package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderLineRepository orderLineRepository;

    private final OrderLine orderLine;

    private final OrderMapper orderMapper;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderLine getOrderLinebyId(final Long id) {
      return   orderLineRepository.findById(id).orElseThrow();
    }

    public String getOrderdedProductName(Long id){
      return   orderRepository.findById(id).get().getProductName();
    }


}
