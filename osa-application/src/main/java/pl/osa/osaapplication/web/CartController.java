package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.model.OrderLineForm;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.ProductRepository;
import pl.osa.osaapplication.services.OrderLineService;
import pl.osa.osaapplication.services.OrderService;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final OrderLineService orderLineService;
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;

    private final OrderService orderService;

    @GetMapping
    public String showCartView(final ModelMap modelMap) {
        modelMap.addAttribute("orderLines", orderLineService.getAllOrderLines());
//        modelMap.addAttribute("orders",orderService.getAllOrders());
        return "cart";
    }

//    @GetMapping("/order")
//    public String createOrder() {
//
//    }


}
