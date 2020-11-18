package pl.osa.osaapplication.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.model.ProductForm;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.services.OrderLineService;
import pl.osa.osaapplication.services.OrderService;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final OrderLineService orderLineService;
    private final OrderService orderService;

    @GetMapping
    public String showCartView(final ModelMap modelMap) {
        modelMap.addAttribute("orderLine", orderLineService.getAllOrderLines());
        modelMap.addAttribute("OrderForm", new OrderForm());

        return "cart";
    }

    @RequestMapping(value = "/order", method = {RequestMethod.GET, RequestMethod.POST})
    public String createOrder(@ModelAttribute(name = "OrderForm") final OrderForm orderForm,  final ProductForm productForm, final UserForm userForm, final Errors errors) {
        if(errors.hasErrors()){
            return "/cart";
        }
        orderService.createOrder(orderForm,productForm,userForm);
        return "redirect:/cart";
    }


}
