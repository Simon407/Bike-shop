<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.entity.Goods>" -->
<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.entity.Category>" -->
<#-- @ftlvariable name="limit" type="java.lang.Integer" -->
<#-- @ftlvariable name="id" type="java.lang.Long" -->
<#-- @ftlvariable name="mainId" type="java.lang.Long" -->
<#include "template.ftl">
<@mainTemplate title="Bike Shop | Bicycles" />
<#macro m_body>

<div class="bikes">
    <#list listMenu as menu>
    <#--назначение айди главной категории-->
        <#if menu.children?has_content && menu.id == mainId>
            <#list menu.children as category>
            <#--если id не передали то выводятся все категории если передали то одна-->
                <#if !(id?has_content) && goods?has_content>
                    <div class="mountain-sec${category.id}">
                        <a href="${category.link}"><h2>${category.name}</h2></a>
                        <#list goods as good>
                        <#--сортировка по категории-->
                            <#if category.id == good.typeId.id>
                                <a href="/goods/${good.id}">
                                    <div class="bike">
                                        <img src="${good.picLink}" alt="" style="height: 183px; width: 310px;"/>
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
                <#elseif category.id == (id) && goods?has_content >
                    <div class="mountain-sec0">
                        <a href="${category}"><h2>${category.name}</h2></a>
                        <#list goods as good>
                        <#--дополнительная проверка категории-->
                            <#if category.id == good.typeId.id>
                                <a href="/goods/${good.id}">
                                    <div class="bike">
                                        <img src="${good.picLink}" alt="" style="height: 183px; width: 310px;"/>
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
                <#elseif !goods?has_content>
                    <a href="/"><h2>Товар не найден!</h2></a>
                </#if>

            </#list></#if></#list>
</div>

</#macro>

