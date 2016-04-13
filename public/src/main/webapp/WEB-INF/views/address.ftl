<#-- @ftlvariable name="address" type="com.springapp.mvc.entity.Address" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Bike Shop |  Address" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        <a class="continue" href="/cabinet" style="width: 300px; margin: 2em auto 2em auto;">Go to cabinet</a>

        <@form.form commandName="addressForm" action="/cabinet/address" acceptCharset="UTF-8" method="post">
            <div class="register-bottom-grid">

                <#if address?has_content>

                    <h2 style="padding: 2% 2%;">ADDRESS INFORMATION</h2>
                    <div style="padding: 2% 2%;">
                        <span>city<label>*</label></span>
                        <@form.input  path="city" value="${address.city}"/>
                        <@form.errors path="city" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>street<label>*</label></span>
                        <@form.input  path="street" value="${address.street}" />
                        <@form.errors path="street" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>house<label>*</label></span>
                        <@form.input  path="house" value="${address.house}"/>
                        <@form.errors path="house" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>flat<label>*</label></span>
                        <@form.input path="flat" value="${address.flat}"/>
                        <@form.errors path="flat" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>index<label>*</label></span>
                        <@form.input  path="index" value="${address.index}"/>
                        <@form.errors path="index" cssStyle="color: red;" />
                    </div>
                    <div class="clearfix"></div>

                <#else >
                    <h2 style="padding: 2% 2%;">ADDRESS INFORMATION</h2>
                    <div style="padding: 2% 2%;">
                        <span>city<label>*</label></span>
                        <@form.input  path="city" />
                        <@form.errors path="city" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>street<label>*</label></span>
                        <@form.input  path="street" />
                        <@form.errors path="street" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>house<label>*</label></span>
                        <@form.input  path="house" />
                        <@form.errors path="house" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>flat<label>*</label></span>
                        <@form.input path="flat" />
                        <@form.errors path="flat" cssStyle="color: red;" />
                    </div>
                    <div style="padding: 2% 2%;">
                        <span>index<label>*</label></span>
                        <@form.input  path="index" />
                        <@form.errors path="index" cssStyle="color: red;" />
                    </div>
                    <div class="clearfix"></div>

                </#if>

            </div>
            <div class="clearfix"></div>
            <div class="register-but" style="padding: 2% 2%;">
                <input type="submit" value="Save changes" class="btn btn-default">
                <div class="clearfix"></div>
            </div>
        </@form.form>
    </div>
</div>
</#macro>