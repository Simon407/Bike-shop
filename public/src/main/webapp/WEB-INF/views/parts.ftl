<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.entity.Goods>" -->
<#-- @ftlvariable name="listMenu" type="java.util.List<com.springapp.mvc.entity.Category>" -->
<#-- @ftlvariable name="limit" type="java.lang.Integer" -->
<#-- @ftlvariable name="id" type="java.lang.Long" -->
<#-- @ftlvariable name="mainId" type="java.lang.Long" -->
<#include "template.ftl">
<@mainTemplate title="Bike Shop | Parts" />
<#macro m_body>

<div class="parts">
    <div class="container">
        <div class="bike-parts-sec">
            <div class="bike-parts">
                <div class="bike-apparels">
                    <#list listMenu as menu>
                        <#--назначение айди главной категории-->
                        <#if menu.children?has_content && menu.id == mainId>
                            <#list menu.children as category>
                            <#--если id не передали то выводятся все категории если передали то одна-->
                                <#if !(id?has_content) && goods?has_content>
                                    <h2><a href="${category.link}">${category.name}</a></h2>
                                    <#list goods as good>
                                    <#--сортировка по категории-->
                                        <#if category.id == good.typeId.id>
                                            <a href="/goods/${good.id}">
                                                <div class="part-sec">
                                                    <img src="${good.picLink}" alt=""/>
                                                    <div class="part-info">
                                                        <a href="#"><h5>${good.name}<span>$${good.price}</span></h5></a>
                                                        <a class="add-cart" href="/goods/${good.id}">View now</a>
                                                        <a class="qck" href="/goods/${good.id}">BUY</a>
                                                    </div>
                                                </div>
                                            </a>

                                        </#if>
                                    </#list>
                                <#elseif category.id == (id)  && goods?has_content>
                                    <h2><a href="${category.link}">${category.name}</a></h2>
                                    <#list goods as good>
                                    <#--сортировка по категории-->
                                        <#if category.id == good.typeId.id>
                                            <a href="/goods/${good.id}">
                                                <div class="part-sec">
                                                    <img src="${good.picLink}" alt=""/>
                                                    <div class="part-info">
                                                        <a href="#"><h5>${good.name}<span>$${good.price}</span></h5></a>
                                                        <a class="add-cart" href="/goods/${good.id}">View now</a>
                                                        <a class="qck" href="/goods/${good.id}">BUY</a>
                                                    </div>
                                                </div>
                                            </a>

                                        </#if>
                                    </#list>
                                <#elseif !goods?has_content>
                                    <h2><a href="/">Товар не найден!</a></h2>
                                </#if>
                            </#list>
                        </#if>
                    </#list>
                </div>
            </div>
            <div class="rsidebar span_1_of_left">
                <section class="sky-form">
                    <div class="product_right">
                        <h3 class="m_2">Categories</h3>
                        <select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"metro"}'>
                            <option value="0">Frames</option>
                            <option value="1">Back Packs</option>
                            <option value="2">Frame Bags</option>
                            <option value="3">Panniers</option>
                            <option value="4">Saddle Bags</option>
                        </select>
                        <select class="dropdown" tabindex="50" data-settings='{"wrapperClass":"metro"}'>
                            <option value="1">Body Armour</option>
                            <option value="2">Sub Category1</option>
                            <option value="3">Sub Category2</option>
                            <option value="4">Sub Category3</option>
                        </select>
                        <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                            <option value="1">Tools</option>
                            <option value="2">Sub Category1</option>
                            <option value="3">Sub Category2</option>
                            <option value="4">Sub Category3</option>
                        </select>
                        <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                            <option value="1">Services</option>
                            <option value="2">Sub Category1</option>
                            <option value="3">Sub Category2</option>
                            <option value="4">Sub Category3</option>
                        </select>
                        <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                            <option value="1">Materials</option>
                            <option value="2">Sub Category1</option>
                            <option value="3">Sub Category2</option>
                            <option value="4">Sub Category3</option>
                        </select>
                    </div>

                    <h4>components</h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Frames(20)</label>
                        </div>
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Foks, Suspensions (48)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Breaks and Pedals (45)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Tires,Tubes,Wheels
                                (45)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Serevice
                                Parts(12)</label>
                        </div>
                    </div>
                    <h4>Apparels</h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Locks (20)</label>
                        </div>
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Speed Cassette
                                (5)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Bike Pedals
                                (7)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Handels (2)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other (50)</label>
                        </div>
                    </div>
                </section>
                <section class="sky-form">
                    <h4>Brand</h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"
                                                           checked=""><i></i>Lezyne</label>
                        </div>
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Marzocchi</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>EBC</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Oakley</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Jagwire</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Yeti Cycles</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Vee Rubber</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Zumba</label>
                        </div>
                    </div>
                </section>
                <section class="sky-form">
                    <h4>Price</h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>$50.00 and
                                Under (30)</label>
                        </div>
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$100.00 and Under (30)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$200.00 and Under (30)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$300.00 and Under (30)</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$400.00 and Under (30)</label>
                        </div>
                    </div>
                </section>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

</#macro>

