<#-- @ftlvariable name="Session.cart" type="com.springapp.mvc.info.CartInfo" -->
<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.entity.Goods>" -->
<#-- @ftlvariable name="carts" type="java.util.List<com.springapp.mvc.entity.Cart>" -->
<#-- @ftlvariable name="cartsSize" type="java.lang.Integer" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "template.ftl">
<@mainTemplate title="Bike Shop | Cart" />
<#macro m_body>

<div class="cart">
    <div class="container">
        <div class="col-md-9 cart-items">
            <#assign totalPrise=0>
            <#if (carts)?? && cartsSize??>
                <h2>My Shopping Bag (${cartsSize})</h2>
                <#list carts as cart>
                    <div class="cart-header${cart.goodId.id}">
                        <div class="close">
                            <button input type="submit" onclick="deleteProduct(${cart.goodId.id})"></button>
                        </div>
                        <div class="cart-sec">
                            <div class="cart-item cyc">
                                <img src="${cart.goodId.picLink}"/>
                            </div>
                            <div class="cart-item-info">
                                <a href="/goods/${cart.goodId.id}"><h3>${cart.goodId.name}</a>
                                <span>Model No: ${cart.goodId.modelNo}</span></h3>
                                <h4><span>Rs. $ </span>${cart.goodId.price}</h4>
                                <#assign totalPrise = totalPrise+(cart.goodId.price*cart.number)>
                                <p class="qty">Qty ::</p>

                                <input type="number" name="quantity" placeholder="Количество"
                                       class="form-control input-small" id="numberProduct${cart.goodId.id}"
                                       value="${cart.number}">
                                <button onclick="changeNumberProduct(${cart.goodId.id})">Изменить</button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </#list>

            <#elseif (Session.cart.goods)??>
                <h2>My Shopping Bag (${Session.cart.getAllCount()})</h2>
                <#list Session.cart.goods?keys as cartUI>
                    <#list goods as good>
                        <#if good.id == cartUI>
                            <div class="cart-header${cartUI}">
                                <div class="close">
                                    <button input type="submit" onclick="deleteProduct(${good.id})"></button>
                                </div>
                                <div class="cart-sec">
                                    <div class="cart-item cyc">
                                        <img src="${good.picLink}"/>
                                    </div>
                                    <div class="cart-item-info">
                                        <a href="/goods/${good.id}"><h3>${good.name}</a>
                                        <span>Model No: ${good.modelNo}</span></h3>
                                        <h4><span>Rs. $ </span>${good.price}</h4>
                                        <#assign totalPrise = totalPrise+(good.price*Session.cart.getCount(cartUI))>
                                        <p class="qty">Qty ::</p>
                                        <input type="number" name="quantity" placeholder="Количество"
                                               class="form-control input-small" id="numberProduct${good.id}"
                                               value="${Session.cart.getCount(cartUI)}">
                                        <button onclick="changeNumberProduct(${good.id})">Изменить</button>
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


        <div class="col-md-3 cart-total" style="height: 333px;">
            <a class="continue" href="/">Continue shopping</a>
            <#if (((Session.cart.goods)?? && Session.cart.allCount !=0) || ((carts)?? && cartsSize?? && cartsSize != 0))  >
                <div class="price-details">
                    <h3>Price Details</h3>
                    <span>Total</span>
                    <span class="total"> $ ${totalPrise}</span>
                    <span>Delivery Charges</span>
                    <span class="total"> $ 150</span>
                    <div class="clearfix"></div>
                </div>

                <h4 class="last-price">TOTAL</h4>
                <span class="total final"> $ ${totalPrise+150}</span>
                <#if ((Session.cart.goods)?? && Session.cart.allCount !=0)>
                    <div class="clearfix"></div>
                    <a class="order" href="/login">Login or Reg</a>
                <#else >
                    <div class="clearfix"></div>
                    <a class="order" href="/order">Place Order</a>
                </#if>

            <#else >
                <div class="price-details">
                    <h3>Price Details</h3>
                    <span>Total</span>
                    <span class="total"> $ 0</span>
                    <span>Delivery Charges</span>
                    <span class="total"> $ 0</span>
                    <div class="clearfix"></div>
                </div>

                <h4 class="last-price">TOTAL</h4>
                <span class="total final"> $ 0</span>
            </#if>
        </div>

    </div>
</div>

</#macro>