<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.info.MenuInfo>" -->
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/"><img src="/resources/images/logo2.png" alt=""/></a>
        </div>
        <div class="ftr-menu">
            <ul>
            <#list listMenu as menu>
                <li><a href="${menu.link}">${menu.name}</a></li>
            </#list>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
