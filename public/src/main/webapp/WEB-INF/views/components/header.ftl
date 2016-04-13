<#-- @ftlvariable name="mainMenu" type="java.util.List<com.springapp.mvc.entity.Category>" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="container">
    <div class="header">
        <div class="logo">
            <a href="/"><img src="/resources/images/logo.png" alt=""/></a>
        </div>
        <div class="top-nav">
            <label class="mobile_menu" for="mobile_menu">
                <span>Menu</span>
            </label>
            <input id="mobile_menu" type="checkbox">
            <ul class="nav">

            <#list mainMenu as menu>
                <li class="dropdown1"><a href="${menu.link}">${menu.name}</a>
                    <#if menu.children?has_content>
                        <ul class="dropdown2">
                            <#list menu.children as category>
                                <li><a href="${category.link}">${category.name}</a></li>
                            </#list>
                        </ul>
                    </#if>
                </li>
            </#list>


            <#-- Если пользователь еще не авторизован, предлагаем ему авторизоваться, либо зарегистрироваться на сайте -->
            <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                <li class="dropdown1">
                    <a class="login" href="/login">Login</a>
                </li>
                <li class="dropdown1">
                    <a class="login" href="/reg">Registration</a>
                </li>
            </@sec.authorize>
            <#-- Если уже авторизован, то ссылки в личный кабинет и на выход -->
            <@sec.authorize access="isAuthenticated()">
                <li class="dropdown1">
                <a class="login" href="/cabinet" style="text-transform: lowercase; color: yellow;">
            <@sec.authentication property="principal.username" />
                </a></li>
                <li class="dropdown1">
                    <a class="login" href="/logout" style="color: yellow;">Logout</a>
                </li>
            </@sec.authorize>

                <a class="shop" href="/cart"><img src="/resources/images/cart.png" alt=""/></a>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
