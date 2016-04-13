<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Bike Shop |  Order" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        <@form.form commandName="orderForm" action="/order" acceptCharset="UTF-8" method="post">
            <div class="register-top-grid">
                <h2 style="padding: 2% 2%;">PERSONAL INFORMATION</h2>
            <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div style="padding: 2% 2%;">
                    <span>FIO<label>*</label></span>
                    <@form.input path="fio" />
                    <@form.errors path="fio" cssStyle="color: red;" />
                </div>
            </div>
            <div class="register-bottom-grid">
                <h2 style="padding: 2% 2%;">ORDER INFORMATION</h2>
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
            </div>
            <div class="clearfix"></div>
            <div class="register-but" style="padding: 2% 2%;">
                <input type="submit" value="submit" class="btn btn-default">
                <div class="clearfix"></div>
            </div>
        </@form.form>
    </div>
</div>
</#macro>