package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.services.EmailService;
import pl.osa.osaapplication.services.OrderLineService;

import pl.osa.osaapplication.services.OrderService;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final OrderLineService orderLineService;
    private final OrderService orderService;
    private final EmailService emailService;

    @GetMapping
    public String showCartView(final ModelMap modelMap) {

        modelMap.addAttribute("orderLines", orderLineService.getAllOrdersByUsername());
       // modelMap.addAttribute("orderForm", new OrderForm());
        modelMap.addAttribute("orderSum", orderService.CalculateTotalPrice(orderLineService.getAllOrdersByUsername()));

        return "cart";
    }


    @PostMapping
    public String submitOrder() {
        Order order = null;

        try {
            order = orderService.submitOrder();
            emailService.sendOrderConfirmationEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        orderLineService.deleteallOrderLines();
        return "order_summary";
    }



}
