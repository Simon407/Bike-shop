package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.form.RegistrationFormBean;
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

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    /**
     * Отображение страницы регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration";
    }

    /**
     * Обработка формы Регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean rfb,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        String login = rfb.getEmail();
        if(userService.getUserByLogin(login) == null){
            userService.add(new User(true, rfb.getEmail(),  DigestUtils.md5Hex(rfb.getPassword()), rfb.getFio(), "ROLE_USER", rfb.getPhone(), null));
            System.out.println(DigestUtils.md5Hex(rfb.getPassword()));
            return "registrationTrue";
        }else return "registrationFalse";
    }
}
