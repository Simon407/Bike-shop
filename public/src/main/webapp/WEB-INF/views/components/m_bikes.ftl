<#-- @ftlvariable name="bikes" type="java.util.List<com.springapp.mvc.info.GoodsInfo>" -->
<div class="bikes">
    <h3>POPULAR BIKES</h3>
    <div class="bikes-grids">
        <ul id="flexiselDemo1">
        <#list bikes as bike>
            <li>
                <img src="${bike.picLink}" alt=""/>
                <div class="bike-info">
                    <div class="model">
                        <h4>${bike.name}<span>$${bike.price}</span></h4>
                    </div>
                    <div class="model-info">
                        <a href="/goods/${bike.id}">BUY</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="viw">
                    <a href="/goods/${bike.id}">View</a>
                </div>
            </li>
        </#list>
        </ul>
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo1").flexisel({
                    visibleItems: 3,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });
            });
        </script>
        <script type="text/javascript" src="/resources/js/jquery.flexisel.js"></script>
    </div>
</div>