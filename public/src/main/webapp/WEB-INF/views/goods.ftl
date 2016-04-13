<#-- @ftlvariable name="good" type="com.springapp.mvc.entity.Goods" -->
<#include "template.ftl">
<#if good?has_content>
    <@mainTemplate title="Bike Shop | ${good.name}" />
<#else >
    <@mainTemplate title="Bike Shop" />
</#if>
<#macro m_body>

    <#if good?has_content>
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
                               <button input type="submit" onclick="addBucket(${good.id})">ADD TO CART</button>
                            </div>
                            <div class="bike-type">
                                <p>TYPE ::<a href="${good.typeId.link}">${good.typeId.name}</a></p>
                                <p>BRAND ::<a href="/">${good.brandId.name}</a></p>
                            </div>
                            <h5>Description ::</h5>
                            <p class="desc">${good.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#else >
    <div class="404-page">
        <div class="container">
            <div class="error-head">
                <h1>4<label>0</label>4</h1>
                <span>ERROR</span>
                <h2>Ooops....!This goods is not found.</h2>
                <a href="/">Go Back</a>
            </div>
        </div>
    </div>
    </#if>
</#macro>

