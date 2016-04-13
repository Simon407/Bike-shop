<#-- @ftlvariable name="orders" type="java.util.List<com.springapp.mvc.entity.Order>" -->
<#include "template.ftl">
<@mainTemplate title="Bike Shop | Cabinet" />
<#macro m_body>

<div class="bikes" style="padding: 0.5em 0;">
    <div class="mountain-sec">
        <a class="continue" href="/" style="width: 300px; margin: 2em auto 2em auto;">Go to main page</a>

        <a href="/cabinet/address"><h2>Address detail(Click to see or change)</h2></a>

        <a href="/cabinet/orders"><h2>Orders(Click to see all)</h2></a>

    <#if orders??>
        <#list orders as order>
        <a href="/cabinet/orders/${order.id}">
            <div class="bike">
                <#--<img src="${good.picLink}" alt="" style="height: 183px; width: 310px;"/>-->
                <div class="bike-cost">
                    <div class="bike-mdl">
                        <h4 style="height: 60px;">${order.creationTime}
                            <span style="padding-top: 10px;">TOTAL PRICE : $ ${order.totalSum}</span></h4>
                    </div>
                    <div class="bike-cart">
                        <a class="buy" href="/">PAY NOW</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </a>
        </#list>
    </#if>

  </div>
</div>



<#--<pre>-->
    <#--Личный кабинет пользователя. С такими функциями как:-->
      <#--* изменение данных в учетной записи;-->
      <#--* управление заказами;-->
      <#--* управление рассылками оповещений;-->
      <#--* настройки параметров сайта.-->
    <#--<a href="/">На главную</a>-->
<#--</pre>-->


</#macro>