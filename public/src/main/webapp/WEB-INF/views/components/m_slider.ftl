<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.info.MenuInfo>" -->
<script src="/resources/js/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: true,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: true,
        });
    });
</script>

<div class="caption">
    <div class="slider">
        <div class="callbacks_container">
            <ul class="rslides" id="slider">

            <#list listMenu as menu>
                <#if menu.listCategory?has_content && menu.id == 1>
                    <#list menu.listCategory as category>
                        <li><h1>${category.name}</h1></li>
                    </#list>
                </#if>
            </#list>

            </ul>
            <p>You <span>create</span> the <span>journey,</span> we supply the <span>parts</span></p>
            <a class="morebtn" href="/bicycles">SHOP BIKES</a>
        </div>
    </div>
</div>
<div class="dwn">
    <a class="scroll" href="#cate"><img src="/resources/images/scroll.png" alt=""/></a>
</div>