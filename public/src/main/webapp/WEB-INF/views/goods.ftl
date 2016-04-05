<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.info.GoodsInfo>" -->
<!DOCTYPE html>
<html>
<head>
    <title>Bike Shop | Single</title>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="/resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/resources/css/form.css" rel="stylesheet" type="text/css" media="all"/>
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
    <!--<script src="js/scripts.js" type="text/javascript"></script>-->
    <!--js-->

</head>
<body>
<!--banner-->
<div class="banner-bg banner-sec">

<#include "components/header.ftl" />

</div>
<!--/banner-->

<div class="product">
    <div class="container">
        <div class="ctnt-bar cntnt">
            <div class="content-bar">
                <div class="single-page">
                    <!--Include the Etalage files-->
                    <link rel="stylesheet" href="/resources/css/etalage.css">
                    <script src="/resources/js/jquery.etalage.min.js"></script>
                    <script>
                        jQuery(document).ready(function ($) {

                            $('#etalage').etalage({
                                thumb_image_width: 400,
                                thumb_image_height: 229,
                                source_image_width: 700,
                                source_image_height: 400,
                                show_hint: true,
                                click_callback: function (image_anchor, instance_id) {
                                    alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                                }
                            });

                        });
                    </script>
                    <!--//details-product-slider-->
                <#--<#if goods.size()==1>-->
                    <#list goods as good>
                        <div class="details-left-slider">
                            <div class="grid images_3_of_2">
                                <ul id="etalage">
                                    <li>
                                        <img class="etalage_thumb_image" src="${good.picLink}"
                                             class="img-responsive"/>
                                        <img class="etalage_source_image" src="${good.picLink}"
                                             class="img-responsive"
                                             title=""/>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="details-left-info">
                            <h3>${good.name}</h3>
                            <h4>Model No: ${good.modelNo}</h4>
                            <h4></h4>
                            <p><label>$</label>${good.price}</p>
                            <div class="btn_form">
                                <a href="/cart">ADD TO CART</a>
                            </div>
                            <div class="bike-type">
                                <p>TYPE ::<a href="/">${good.typeId}</a></p>
                                <p>BRAND ::<a href="/">${good.brandId}</a></p>
                            </div>
                            <h5>Description ::</h5>
                            <p class="desc">${good.description}</p>
                        </div>
                    </#list>
                <#--<#else><h3>Товар не найден!</h3>-->
                <#--</#if>-->
                </div>
            </div>
        </div>
    </div>
</div>
<!---->
<#include "components/footer.ftl" />
<!---->

</body>
</html>

