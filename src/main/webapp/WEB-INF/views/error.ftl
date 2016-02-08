<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"] />
<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><@layout.block name="title">ToDoList</@layout.block></title>

    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
        var $resourcesRoot = "<@c.url value="/resources/" />";
    </script>

<@layout.block name="css_head">
    <!-- Bootstrap Styles-->
    <link href="<@c.url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<@c.url value="/resources/css/bootstrap-datepicker.css" />" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

    <style type="text/css">
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</@layout.block>
<@layout.block name="js_head">

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/jquery-1.10.2.js" />"></script>
    <!-- Bootstrap Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/bootstrap.min.js" />"></script>
    <!-- Bootstrap datepicker Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/bootstrap-datepicker.js" />"></script>
</@layout.block>
</head>


<body>
<@layout.block name="body">



<div class="well container" style="width: 250px;">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Please sign in</h3>
        </div>
        <div class="panel-body">

            <form action="<@c.url value='/login' />" method="POST">
                <input type="text"  class="form-control"    name="username" placeholder="User Name" required autofocus>
                <input type="password" class="form-control" name="password" placeholder="Password" required>
            </form>
            <button class="btn btn-success btn" type="submit">Login</button>
        </div>
    </div>
</div>

</@layout.block>
</body>
</html>