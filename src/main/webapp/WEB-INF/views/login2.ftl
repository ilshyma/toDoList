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
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
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



<div class="container">

    <form class="form-signin" action="<@c.url value='/login' />" method="POST">

        <h2 class="form-signin-heading">Please sign in</h2>

        <#if error??>
            <div class="alert alert-danger">${error}</div>
        </#if>
        <#if msg??>
            <div class="alert alert-success">${msg}</div>
        </#if>


        <input type="text" name="username" class="input-block-level" placeholder="User Name" required autofocus>
        <input type="password" name="password"  class="input-block-level" placeholder="Password" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
    </form>


</div>

</@layout.block>
</body>
</html>