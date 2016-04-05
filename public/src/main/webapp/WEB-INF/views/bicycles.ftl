<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.info.GoodsInfo>" -->
<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.info.MenuInfo>" -->
<#-- @ftlvariable name="limit" type="java.lang.Integer" -->
<!DOCTYPE html>
<html>
<head>
    <title>Bike Shop | Bicycles</title>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="/resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
    <!--webfont-->
    <!-- dropdown -->
    <script src="/resources/js/jquery.easydropdown.js"></script>
    <link href="/resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
<#--<script src="/resources/js/scripts.js" type="text/javascript"></script>-->
    <!--js-->

</head>
<body>
<!--banner-->
<div class="banner-bg banner-sec">

<#include "components/header.ftl" />

</div>
<!--/banner-->

<#assign index=0>

<div class="bikes">
    <#list listMenu as menu>
        <#if menu.listCategory?has_content && menu.id == 1>
            <#list menu.listCategory as category>
            <#--если id не передали то выводятся все категории если передали то одна-->
                <#if !(id?has_content)>
                    <div class="mountain-sec${category.id}">
                        <a href="${category.link}"><h2>${category.name}</h2></a>
                        <#list goods as good>
                            <#if category.id == good.typeId>
                                <#--<#assign index= index +1>-->
                                <a href="/goods/${good.id}">
                                    <div class="bike">
                                        <img src="${good.picLink}" alt=""/>
                                        <div class="bike-cost">
                                            <div class="bike-mdl">
                                                <h4>${good.name}<span>Model: ${good.modelNo}</span></h4>
                                            </div>
                                            <div class="bike-cart">
                                                <a class="buy" href="/goods/${good.id}">BUY NOW</a>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="fast-viw">
                                            <a href="/goods/${good.id}">Quick View</a>
                                        </div>
                                    </div>
                                </a>
                            </#if>
                        </#list>
                        <div class="clearfix"></div>
                    </div>
                <#elseif category.id == id >
                    <div class="mountain-sec0">
                        <a href="${category.link}"><h2>${category.name}</h2></a>
                        <#list goods as good>
                            <#if category.id == good.typeId>
                                <a href="/goods/${good.id}">
                                    <div class="bike">
                                        <img src="${good.picLink}" alt=""/>
                                        <div class="bike-cost">
                                            <div class="bike-mdl">
                                                <h4>${good.name}<span>Model: ${good.modelNo}</span></h4>
                                            </div>
                                            <div class="bike-cart">
                                                <a class="buy" href="/goods/${good.id}">BUY NOW</a>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="fast-viw">
                                            <a href="/goods/${good.id}">Quick View</a>
                                        </div>
                                    </div>
                                </a>
                            </#if>
                        </#list>
                        <div class="clearfix"></div>
                    </div>
                </#if>

            </#list></#if></#list>
</div>

<#include "components/footer.ftl" />

</body>
</html>

