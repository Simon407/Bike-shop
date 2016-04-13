package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryMenu;
import com.springapp.mvc.entity.Address;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.form.AddressFormBean;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.services.AddressService;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    public static final String ATTR_ADDRESS_FORM = "addressForm";

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @IncludeCategoryMenu
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage(ModelMap model) {
        model.addAttribute("orders", orderService.getOrdersByUserId(userService.getAutUser().getId()));
        return "cabinet";
    }

    @IncludeCategoryMenu
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String renderOrdersPage(@PathVariable("id") Long id) {
        request.setAttribute("order", orderService.getOrderById(id));
        return "components/orderPage";
    }

    @IncludeCategoryMenu
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String renderOrdersPageAll(ModelMap model) {
        request.setAttribute("orders", orderService.getOrdersByUserId(userService.getAutUser().getId()));
        return "components/ordersAll";
    }

    @IncludeCategoryMenu
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String renderAddressPage(ModelMap model) {
        request.setAttribute("address", addressService.getAddressByUserId(userService.getAutUser().getId()));
        request.setAttribute(ATTR_ADDRESS_FORM, new AddressFormBean());
        return "address";
    }

//    @IncludeCategoryMenu
//    @RequestMapping(value = "/data", method = RequestMethod.GET)
//    public String renderUserDataPage(ModelMap model) {
//        request.setAttribute("user", userService.getAutUser());
//        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
//        return "registration";
//    }
//
//    /**
//     * Обработка формы Регистрации
//     */
//    @IncludeCategoryMenu
//    @RequestMapping(value = "/data",method = RequestMethod.POST)
//    public String registrationForm(
//            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean rfb,
//            BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        String login = rfb.getEmail();
//        if (userService.getUserByLogin(login) == null) {
//            User user = userService.getAutUser();
//            userService.update(new User(user.getId(),user.isEnable(), login, user.getHashPass(), rfb.getFio(), user.getRole(), rfb.getPhone()));
//            request.setAttribute("user", userService.getAutUser());
//            return "registration";
//        } else return "components/registrationFalse";
//    }

    /**
     * Обработка формы заказа
     */
    @IncludeCategoryMenu
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String addressForm(
            @Valid @ModelAttribute(ATTR_ADDRESS_FORM) AddressFormBean afb,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "address";
        }
        request.setAttribute("address", addressService.getAddressByUserId(userService.getAutUser().getId()));
        User user = userService.getAutUser();
        if (addressService.getAddressByUserId(user.getId()) != null) {
            addressService.delete(addressService.getAddressByUserId(user.getId()));
            addressService.add(new Address(user, afb.getCity(), afb.getStreet(), afb.getHouse(), afb.getFlat(), afb.getIndex()));
            request.setAttribute("address", addressService.getAddressByUserId(userService.getAutUser().getId()));
            return "address";
        } else {
            addressService.add(new Address(user, afb.getCity(), afb.getStreet(), afb.getHouse(), afb.getFlat(), afb.getIndex()));
            request.setAttribute("address", addressService.getAddressByUserId(userService.getAutUser().getId()));
            return "address";
        }
    }
}
