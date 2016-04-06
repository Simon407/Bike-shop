<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.info.MenuInfo>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bike Shop | Home</title>
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
    <!---- start-smoth-scrolling---->
    <script type="text/javascript" src="/resources/js/move-top.js"></script>
    <script type="text/javascript" src="/resources/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 900);
            });
        });
    </script>
    <!---- start-smoth-scrolling---->

</head>
<body>
<!--banner-->
<div class="banner-bg banner-bg1">

<#include "components/header.ftl" />
<#include "components/m_slider.ftl" />

</div>
<!--/banner-->


<div id="cate" class="categories">
    <div class="container">
        <h3>CATEGORIES</h3>
        <div class="categorie-grids">

        <#list listMenu as menu>
            <#if menu.listCategory?has_content && menu.id == 1>
                <#list menu.listCategory as category>
                    <div class="col-md-4 cate-grid grid1" style="background:url(${category.picLink}) no-repeat;">
                        <a href="${menu.link}"><h4>${category.name}</h4></a>
                        <p>${category.description}</p>
                        <a class="store" href="${category.link}">GO TO STORE</a>
                    </div>
                </#list>
            </#if>
        </#list>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<!--bikes-->
<#include "components/m_bikes.ftl" />
<!--/bikes-->

<#include "components/m_contact.ftl" />
<#include "components/footer.ftl" />

</body>
</html>
<#--</#macro>-->