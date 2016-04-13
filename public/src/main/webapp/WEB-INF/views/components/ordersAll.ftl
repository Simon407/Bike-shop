<#-- @ftlvariable name="orders" type="java.util.List<com.springapp.mvc.entity.Order>" -->

<#include "../template.ftl">
<@mainTemplate title="Bike Shop | Order" />
<#macro m_body>

    <#if orders?has_content>
    <div class="bikes" style="padding: 0.5em 0;">
        <div class="mountain-sec0">
            <a class="continue" href="/cabinet" style="width: 300px; margin: 2em auto 2em auto;">Go to cabinet</a>
            <h2 style="margin-bottom: 1em;">All Orders :</h2>

            <#list orders as order>
                <a href="/cabinet/orders/${order.id}">

                    <div class="bike">
                    <#--<img src="${good.picLink}" alt="" style="height: 183px; width: 310px;"/>-->
                        <div class="bike-cost">
                            <div class="bike-mdl">
                                <h4 style="height: 63px; width: 140px;">ORDER NUMBER : ${order.id}
                                    <span style="padding-top: 10px;">TOTAL PRICE : $ ${order.totalSum}</span></h4>
                            </div>
                            <div class="bike-cart">
                                <a class="buy" href="/">PAY NOW</a>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="fast-viw">
                            <a href="/cabinet/orders/${order.id}">Quick View</a>
                        </div>
                    </div>

                </a>
            </#list>
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