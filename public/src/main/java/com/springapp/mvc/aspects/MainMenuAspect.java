package com.springapp.mvc.aspects;

import com.springapp.mvc.entity.Category;
import com.springapp.mvc.services.MenuService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Аспект для добавления списка категорий в меню шапки сайта
 */
@Aspect
@Component
public class MainMenuAspect {

    private static final String MAIN_MENU_LIST = "listMenu";
    private static final String MAIN_MENU = "mainMenu";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private MenuService menuService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeMenuInfo)")
    public void includeMenuInfoMethod() {
    }

    @Before("includeMenuInfoMethod()")
    public void includeMenuInfo() {
        List<Category> listMenu = menuService.getAllCategory();
        List<Category> mainMenu = menuService.getMainMenu();
        request.setAttribute(MAIN_MENU_LIST, listMenu);
        request.setAttribute(MAIN_MENU, mainMenu);
    }
}
