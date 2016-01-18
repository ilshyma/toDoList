<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"] />
<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><@layout.block name="title">Projects Home</@layout.block></title>

    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
        var $resourcesRoot = "<@c.url value="/resources/" />";
    </script>

<@layout.block name="css_head">
    <!-- Bootstrap Styles-->
    <link href="<@c.url value="/resources/css/lib/bootstrap.css" />" rel="stylesheet"/>
    <!-- FontAwesome Styles-->
    <link href="<@c.url value="/resources/css/lib/font-awesome.css" />" rel="stylesheet"/>
    <!-- Morris Chart Styles-->
    <link href="<@c.url value="/resources/css/lib/morris-0.4.3.min.css" />" rel="stylesheet"/>
    <!-- Custom Styles-->
    <link href="<@c.url value="/resources/css/lib/custom-styles.css" />" rel="stylesheet"/>
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" type="text/css"/>
</@layout.block>
<@layout.block name="js_head">

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/jquery-1.10.2.js" />"></script>
    <!-- Bootstrap Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/bootstrap.min.js" />"></script>
    <!-- Metis Menu Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/jquery.metisMenu.js" />"></script>
    <!-- Morris Chart Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/morris/raphael-2.1.0.min.js" />"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/morris/morris.js" />"></script>

    <script type="text/javascript" src="<@c.url value="/resources/js/lib/easypiechart.js" />"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/easypiechart-data.js" />"></script>


    <!-- Custom Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/custom-scripts.js" />"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/spin.js" />"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/app.js" />"></script>

</@layout.block>
</head>


<body>
<@layout.block name="body">
<div id="wrapper">
    <h1>
        Welcome our beloved leader!
    </h1>
</div>

<div class="row">
    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th data-field="name">Name</th>
                    <th data-field="instances">Instances</th>
                    <th data-field="services">Services</th>
                </tr>
                </thead>

            </table>
        </div>
    </div>
</div>
</@layout.block>
</body>
</html>