package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage(ModelMap model) {
        model.addAttribute("orders", orderService.getOrdersByUserId(userService.getAutUser().getId()));
        return "cabinet";
    }

    @IncludeMenuInfo
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String renderOrdersPage(@PathVariable("id") Long id) {
        request.setAttribute("order", orderService.getOrderById(id));
        return "components/orderPage";
    }

    @IncludeMenuInfo
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String renderOrdersPageAll( ModelMap model) {
        request.setAttribute("orders", orderService.getOrdersByUserId(userService.getAutUser().getId()));
        return "components/ordersAll";
    }

//    @IncludeMenuInfo
//    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
//    public String renderAddressPage(@PathVariable("id") Long id) {
//        request.setAttribute("order", orderService.getOrderById(id));
//        return "components/orderPage";
//    }

    @IncludeMenuInfo
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String renderAddressPageAll( ModelMap model) {
        return "components/ordersAll";
    }
}
