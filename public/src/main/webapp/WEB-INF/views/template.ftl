<#macro mainTemplate title="Bike Shop | Home" styles=[] scripts=[] >
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/bucket.js"></script>
    <!-- Custom Theme files -->
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/resources/css/form.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
    <!--webfont-->
    <!-- dropdown -->
    <script src="/resources/js/jquery.easydropdown.js"></script>
    <link href="/resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
<#--<script src="/resources/js/scripts.js" type="text/javascript"></script>-->
    <!--js-->

</head>
<body>
<!--banner-->
<div class="banner-bg banner-sec">

    <#include "components/header.ftl" />

</div>
<!--/banner-->

    <@m_body />

    <#include "components/footer.ftl" />

</body>
</html>
</#macro>