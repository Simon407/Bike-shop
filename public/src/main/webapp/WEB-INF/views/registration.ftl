<#-- @ftlvariable name="user" type="com.springapp.mvc.entity.User" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Bike Shop | Registration" />
<#macro m_body>
<div class="account-in">
<div class="container">

    <#--<#if user?has_content>-->
        <#--<@form.form commandName="regForm" action="/cabinet/data" acceptCharset="UTF-8" method="post">-->
            <#--<div class="register-top-grid">-->

                <#--<h2 style="padding: 2% 2%;">PERSONAL INFORMATION</h2>-->
            <#--&lt;#&ndash;<@form.errors path="*" cssStyle="color: red;" />&ndash;&gt;-->
                <#--<div style="padding: 2% 2%;">-->
                    <#--<span>FIO<label>*</label></span>-->
                    <#--<@form.input path="fio" value = "${user.fio}"/>-->
                    <#--<@form.errors path="fio" cssStyle="color: red;" />-->
                <#--</div>-->
                <#--<div style="padding: 2% 2%;">-->
                    <#--<span>Email Address<label>*</label></span>-->
                    <#--<@form.input path="email" value = "${user.login}"/>-->
                    <#--<@form.errors path="email" cssStyle="color: red;" />-->
                <#--</div>-->
                <#--<div style="padding: 2% 2%;">-->
                    <#--<span>Phone<label>*</label></span>-->
                    <#--<@form.input path="phone" value = "${user.phone}"/>-->
                    <#--<@form.errors path="phone" cssStyle="color: red;" />-->
                <#--</div>-->
            <#--</div>-->

            <#--<div class="clearfix"></div>-->
            <#--<div class="register-but" style="padding: 2% 2%;">-->
                <#--<input type="submit" value="Update" class="btn btn-default">-->
                <#--<div class="clearfix"></div>-->
            <#--</div>-->
        <#--</@form.form>-->
    <#--</div>-->
    <#--<#else >-->
        <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post">
        <div class="register-top-grid">

            <h2 style="padding: 2% 2%;">PERSONAL INFORMATION</h2>
        <#--<@form.errors path="*" cssStyle="color: red;" />-->
            <div style="padding: 2% 2%;">
                <span>FIO<label>*</label></span>
                <@form.input path="fio" />
                <@form.errors path="fio" cssStyle="color: red;" />
            </div>
            <div style="padding: 2% 2%;">
                <span>Email Address<label>*</label></span>
                <@form.input path="email" />
                <@form.errors path="email" cssStyle="color: red;" />
            </div>
            <div style="padding: 2% 2%;">
                <span>Phone<label>*</label></span>
                <@form.input path="phone" />
                <@form.errors path="phone" cssStyle="color: red;" />
            </div>


            <div class="register-bottom-grid">
                <h2 style="padding: 2% 2%;">LOGIN INFORMATION</h2>
                <div style="padding: 2% 2%;">
                    <span>Password<label>*</label></span>
                    <@form.password path="password" />
                    <@form.errors path="password" cssStyle="color: red;" />
                </div>
                <div style="padding: 2% 2%;">
                    <span>Confirm Password<label>*</label></span>
                    <@form.password path="confirmPassword" />
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
            <div class="register-but" style="padding: 2% 2%;">
                <input type="submit" value="Join" class="btn btn-default">
                <div class="clearfix"></div>
            </div>

        </@form.form>
    </div>
    <#--</#if>-->
</div>
</#macro>