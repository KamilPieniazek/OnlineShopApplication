package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.OrderLine;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.repositories.OrderLineRepository;
import pl.osa.osaapplication.repositories.ProductRepository;
import pl.osa.osaapplication.services.OrderLineService;

import pl.osa.osaapplication.services.users.UserInfoService;

import java.util.List;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final OrderLineService orderLineService;
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
//    private final OrderService orderService;
    private final UserInfoService userInfoService;


    @GetMapping
    public String showCartView(final ModelMap modelMap) {
        modelMap.addAttribute("orderLines", orderLineService.getAllOrdersByUsername());
        modelMap.addAttribute("orderForm", new OrderForm());

//        modelMap.addAttribute("orders",orderService.getAllOrders());
        return "cart";
    }

    @GetMapping("/cart")
    public List<OrderLine> getAllOrderLinesByUsername() {
        return orderLineService.getAllOrdersByUsername();

    }



//    @RequestMapping(value = "/cart/order", method = {RequestMethod.GET, RequestMethod.POST})
//    public String createOrder(@ModelAttribute(value = "orderForm") final OrderForm orderForm, final ModelMap modelMap) {
//
//        orderService.createOrder(orderForm);
//        return "redirect:/cart";
//
//    }


//    @GetMapping
//    public String createOrder(){
//
//    }


}
