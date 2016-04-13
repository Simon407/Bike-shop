<#include "template.ftl">
<@mainTemplate title="Bike Shop | Login" />
<#macro m_body>

<div class="404-page">
    <div class="container">
        <div class="error-head">
            <div class="col-md-7 account-top">
                <#if error?has_content>
                    <div style="color: red;">Error! Please, check your email and password!</div>
                </#if>
                <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                    <div>
                        <span>Email*</span>
                        <input type="text" name="j_username"/>
                    </div>
                    <div>
                        <span class="pass">Password*</span>
                        <input type="password" name="j_password"/>
                    </div>
                    <div style="padding-top: 30px;margin-left: 33px;">
                        <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                        <label for="remember_me" class="inline">Remember me</label>
                    </div>
                    <input type="submit" value="Login" class="submit" style="margin-left: 32px;"/>
                    <a href="/reg" style="margin-left: 15px;">Create an account</a>
                </form>
            </div>
            <div class="col-md-5 left-account "></div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<#--<@form.form commandName="authForm" action="/login" acceptCharset="UTF-8" method="post">-->
<#--<div>-->
<#--<span>Email*</span>-->
<#--<@form.input path="email" />-->
<#--<@form.errors path="email" cssStyle="color: red;" />-->
<#--</div>-->
<#--<div>-->
<#--<span class="pass">Password*</span>-->
<#--<@form.password path="password" />-->
<#--<@form.errors path="password" cssStyle="color: red;" />-->
<#--</div>-->
<#--<div style="padding-top: 30px;margin-left: 33px;">-->
<#--<input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>-->
<#--<label for="remember_me" class="inline">Remember me</label>-->
<#--</div>-->
<#--<input type="submit" value="Login" class="submit" style="margin-left: 32px;"/>-->
<#--<a href="/reg" style="margin-left: 15px;">Create an account</a>-->
<#--</@form.form>-->

</#macro>