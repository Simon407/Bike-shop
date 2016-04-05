<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.info.MenuInfo>" -->
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

                    <#list listMenu as menu>
                    <li class="dropdown1"><a href="${menu.link}">${menu.name}</a>
                        <#if menu.listCategory?has_content>
                        <ul class="dropdown2">
                            <#list menu.listCategory as category>
                            <li><a href="${category.link}">${category.name}</a></li>
                            </#list>
                        </ul>
                        </#if>
                    </li>
                    </#list>

                    <a class="shop" href="/cart"><img src="/resources/images/cart.png" alt=""/></a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
