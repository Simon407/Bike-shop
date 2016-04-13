<#-- @ftlvariable name="order" type="com.springapp.mvc.entity.Order" -->

<#include "../template.ftl">
<#if order?has_content>
    <@mainTemplate title="Bike Shop | ${order.creationTime}" />
<#else >
    <@mainTemplate title="Bike Shop | Order" />
</#if>
<#macro m_body>

    <#if order?has_content>
    <div class="bikes" style="padding: 0.5em 0;">
        <div class="mountain-sec0">

           <h2 style=" margin-bottom: 0.7em;">Order number : ${order.id}</h2>
            <h3>Creation date : ${order.creationTime}</h3>
            <h3>Total price(with delivery charges = $ 150) : $ ${order.totalSum}</h3>
           <h3>Delivery address : ${order.address}</h3>
            <a class="continue" href="/cabinet" style="width: 300px; margin: 2em auto 2em auto;">Go to cabinet</a>
            <h3 style=" margin-bottom: 1em;">Goods list : </h3>

            <#if order.cart??>
                <#list order.cart as cart>
                    <a href="/goods/${cart.goodId.id}">

                        <div class="bike">
                            <img src="${cart.goodId.picLink}" alt="" style="height: 183px; width: 310px;"/>
                            <div class="bike-cost">
                                <div class="bike-mdl">
                                    <h4>${cart.goodId.name}<span>Model: ${cart.goodId.modelNo}</span></h4>
                                </div>
                                <div class="bike-cart">
                                    <a class="buy" href="/goods/${cart.goodId.id}">${cart.goodId.price} * ${cart.number}</a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="fast-viw">
                                <a href="/goods/${cart.goodId.id}">Quick View</a>
                            </div>
                        </div>

                    </a>
                </#list>
            </#if>
            <div class="clearfix"></div>
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