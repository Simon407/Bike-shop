<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.info.GoodsInfo>" -->
<#-- @ftlvariable name="good" type="java.util.List<com.springapp.mvc.entity2.Goods>" -->
<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.info.MenuInfo>" -->
<#-- @ftlvariable name="limit" type="java.lang.Integer" -->
<#include "template.ftl">
<@mainTemplate title="Bike Shop | 404 Error" />
<#macro m_body>

<#--<#assign index=0>-->

<div class="bikes">
    <#list good as good1>
        <h4>${good1.name}<span>Model: ${good1.modelNo}</span></h4>
    </#list>
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

</#macro>

