package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.entity.Address;
import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.form.OrderFormBean;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.services.AddressService;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    public static final String ATTR_ORDER_FORM = "orderForm";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * Отображение страницы заказа
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_ORDER_FORM, new OrderFormBean());
        return "order";
    }

    /**
     * Обработка формы заказа
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_ORDER_FORM) OrderFormBean ofb,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "order";
        }
        User user = userService.getAutUser();
        if(addressService.getAddressByUserId(user.getId()) == null){
            addressService.add(new Address(user,ofb.getCity(),ofb.getStreet(),ofb.getHouse(),ofb.getFlat(),ofb.getIndex()));
            Address address = addressService.getAddressByUserId(user.getId());
            Date d = new Date(System.currentTimeMillis());
            BigDecimal tp = new BigDecimal(0);
            for (Cart c:user.getCart()) {
               tp = tp.add(c.getGoodId().getPrice().multiply(new BigDecimal(c.getNumber())));
            }
            Order order = new Order(user,address,d,tp,"open",null);
            order.setCart(user.getCart());
            user.setCart(null);
            userService.add(user);
            orderService.add(order);
            return "cabinet";
        }else return "order";
    }
}
