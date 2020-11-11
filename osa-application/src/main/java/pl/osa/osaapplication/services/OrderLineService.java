package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper orderLineMapper;

    public void createOrderLine(final ProductForm productForm){
        final OrderLine orderLine=orderLineMapper.toOrder(productForm);
        orderLineRepository.save(orderLine);
    }
}
