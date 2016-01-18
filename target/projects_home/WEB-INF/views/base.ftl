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
    <link href="<@c.url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>

    <!-- FontAwesome Styles-->
    <link href="<@c.url value="/resources/css/lib/font-awesome.css" />" rel="stylesheet"/>
    <!-- Morris Chart Styles-->
    <link href="<@c.url value="/resources/css/lib/morris-0.4.3.min.css" />" rel="stylesheet"/>
    <!-- Custom Styles-->
    <link href="<@c.url value="/resources/css/lib/custom-styles.css" />" rel="stylesheet"/>
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" type="text/css"/>

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

<!--top menu-->
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/index">Todolist MVC</a>
            <ul class="nav">
                <li class="active"><a href="/todos">Home</a></li>
                <li class=""><a href="/about">About</a></li>
            </ul>
            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i> Hi! <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/user/account">My account</a></li>
                    <li class="divider"></li>
                    <li><a href="/user/logout">Sign out</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--page content-->
<div class="container">
<div class="row">
    <div class="span3">

        <!--side menu-->

        <div class="well sidebar-nav">
            <ul class="nav nav-list">
                <li class="nav-header">Hi user !</li>
                <li><a href="/todos"><i class="icon-home"></i> Home</a></li>
                <li><a href="/user/account"><i class="icon-user"></i> My account</a></li>
                <li><a href="/todos/new"><i class="icon-file"></i> Create a todo</a></li>
                <li class="divider"></li>
                <li class="nav-header">Search todo</li>
                <li>
                    <form class="form-search" action="/todos/search" id="searchForm" method="get">
                        <div class="input-append">
                            <input type="text" name="title" class="input-small search-query"
                                   placeholder="search by title" required="required">
                            <button type="submit" class="btn">Go!</button>
                        </div>
                    </form>
                </li>
            </ul>
        </div>

        <!-- end side menu-->

    </div>
    <div class="span9">
        <div class="well">
            <div class="page-header">
                <h1>My Todo list</h1>
            </div>

            <table class="table table-bordered table-striped">

                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Due Date</th>
                    <th>Priority</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>

                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    </div>
    </div>



</@layout.block>
</body>


</html>