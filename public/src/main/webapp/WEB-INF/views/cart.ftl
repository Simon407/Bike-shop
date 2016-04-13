<#-- @ftlvariable name="Session.cart" type="com.springapp.mvc.info.CartInfo" -->
<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.info.Goods>" -->

<#include "template.ftl">
<@mainTemplate title="Bike Shop | Cart" />
<#macro m_body>

<div class="cart">
    <div class="container">
        <div class="col-md-9 cart-items">

            <#if (Session.cart.goods)??>
                <h2>My Shopping Bag (${Session.cart.getAllCount()})</h2>
                <#list Session.cart.goods?keys as goodId>
                    <#list goods as good>
                        <#if good.id == goodId>
                            <div class="cart-header${goodId}">
                                <div class="close">
                                    <form action="/cart" method="post">
                                        <input name="move" style="display:none" value="delete"/>
                                        <input name="id" style="display:none" value="${good.id}"/>
                                        <input type="submit" value="">
                                    </form>
                                </div>
                                <div class="cart-sec">
                                    <div class="cart-item cyc">
                                        <img src="${good.picLink}"/>
                                    </div>
                                    <div class="cart-item-info">
                                        <h3>${good.name}<span>Model No: ${good.modelNo}</span></h3>
                                        <h4><span>Rs. $ </span>${good.price}</h4>
                                        <p class="qty">Qty :: </p>
                                        <input min="1" type="number" id="quantity" name="quantity" value="1"
                                               class="form-control input-small">
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </#if>
                    </#list>
                </#list>
            <#else>  <h2>My Shopping Bag (0)</h2>
            </#if>
        </div>

        <#if (Session.cart.goods)??>
            <div class="col-md-3 cart-total">
                <a class="continue" href="/">Continue shopping</a>
                <div class="price-details">
                    <h3>Price Details</h3>
                    <span>Total</span>
                    <span class="total">6200.00</span>
                    <span>Delivery Charges</span>
                    <span class="total">150.00</span>
                    <div class="clearfix"></div>
                </div>
                <h4 class="last-price">TOTAL</h4>
                <span class="total final">считать в сервисе</span>
                <div class="clearfix"></div>
                <a class="order" href="#">Place Order</a>
            </div>
        </#if>
    </div>
</div>

</#macro>