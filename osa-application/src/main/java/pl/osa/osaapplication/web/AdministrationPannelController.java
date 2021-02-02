package pl.osa.osaapplication.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.osa.osaapplication.domain.Order;
import pl.osa.osaapplication.model.OrderForm;
import pl.osa.osaapplication.repositories.OrderRepository;
import pl.osa.osaapplication.services.OrderService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/administration_panel")
@RequiredArgsConstructor
public class AdministrationPannelController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping
    public String showOrdersView(final Long id, final ModelMap modelMap) {


        //TODO: usunac zaleznosc od orderRepository
        Order order = orderRepository.getOne(id);
        modelMap.addAttribute("order_details", order);
        modelMap.addAttribute("orders", orderRepository.findAll());
//        modelMap.addAttribute("orderForm", new OrderForm());

        return "administration_panel";

    }

//    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
//    public String getOrder(@PathVariable final Long id, ModelMap modelMap) {
//
//        return "administration_panel";
//    }

    @RequestMapping(value = "/{id}/update", method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})
    public String changeOrderStatus(@PathVariable final Long id, @Valid @ModelAttribute(name = "orderForm") final OrderForm orderForm, Errors errors) {

        if (errors.hasErrors()) {
            return "administration_panel";
        }
        orderService.changeOrderStatus(orderForm, id);

        return "redirect:/administration_panel";
    }


}
