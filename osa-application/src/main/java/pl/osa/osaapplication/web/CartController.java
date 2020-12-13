package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.ProductRepository;
import pl.osa.osaapplication.services.OrderLineService;

import pl.osa.osaapplication.services.OrderService;
import pl.osa.osaapplication.services.users.UserInfoService;

import java.util.List;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final OrderLineService orderLineService;
    private final OrderService orderService;



    @GetMapping
    public String showCartView(final ModelMap modelMap) {
        modelMap.addAttribute("orderLines", orderLineService.getAllOrdersByUsername());
        modelMap.addAttribute("orderForm", new OrderForm());

        return "cart";
    }


    @PostMapping
    public String submitOrder() {
        Order order = null;

        try {
            order = orderService.submitOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        orderLineService.deleteallOrderLines();
        return "order_summary";
        // return "order/" + order.getId().toString();
    }




}
