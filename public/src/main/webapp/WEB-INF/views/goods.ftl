<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.info.GoodsInfo>" -->
<#-- @ftlvariable name="Session.cart" type="com.springapp.mvc.info.CartInfo" -->
<#include "template.ftl">
<@mainTemplate title="Bike Shop | 404 Error" />
<#macro m_body>

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
                            <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                                <a href="/cart">Go in cart</a>
                            <#else>
                                 <form action="/cart" method="post">
                                     <input name="move" style="display:none" value="add"/>
                                    <input name="id" style="display:none" value="${good.id}"/>
                                    <input type="submit" value="ADD TO CART">
                                </form>
                            <#--<a href="/cart/${good.id}" data-id="${good.id}">ADD TO CART</a>-->
                            </#if>
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

</#macro>

