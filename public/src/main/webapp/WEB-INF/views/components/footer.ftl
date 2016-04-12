<#-- @ftlvariable name="mainMenu" type="java.util.List<com.springapp.mvc.entity.Category>" -->
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/"><img src="/resources/images/logo2.png" alt=""/></a>
        </div>
        <div class="ftr-menu">
            <ul>
            <#list mainMenu as menu>
                <li><a href="${menu.link}">${menu.name}</a></li>
            </#list>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
