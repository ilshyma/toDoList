<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"] />
<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
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


<!-----------top Menu--------------->

<@layout.block name="topMenu">

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/">Todolist</a>

            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <@security.authorize access="isAuthenticated()">
                        <i class="icon-user"></i> Hi, <@security.authentication property="principal.username" />!
                    </@security.authorize>

                    <@security.authorize access="! isAuthenticated()">
                        <i class="icon-user"></i> Hi, Guest!
                    </@security.authorize>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">

                    <li><a href="/user/create">Create users (only for admin)</a></li>
                    <li class="divider"></li>
                    <li><a href="/login?logout">Sign out</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</@layout.block>

<!-----------Work page content------>

<div class="container">
    <div class="row">

        <!-----------sideMenu--------------->

    <@layout.block name="sideMenu">

        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="divider"></li>
                    <li class="nav-header">Search task</li>
                    <li>
                        <form role="form" id="searchForm" class="form-search" action="<@c.url value='/task/search' />"
                              method="POST">
                            <div class="input-append">
                                <input type="text" name="title" class="input-small search-query"
                                       placeholder="search by title" required="required">
                                <button type="submit" class="btn">Go!</button>
                            </div>
                        </form>
                    </li>
                    <li class="divider"></li>


                <#if usdRateActual?has_content && usdRate?has_content>

                    <li class="nav-header">
                        USD Rate: <span class="label label-${usdRateActual?then('success','danger')}"> ${usdRate}  </span> UAH/USD
                    </li>
                    <li class="divider"></li>
                    <li class="nav-header"> Rewards for done task: <span class="label label-default"> ${salary} </span>
                        UAH
                    </li>
                    <li class="divider"></li>
                    <li class="nav-header"> Your salary -  </br> 10 USD/hour </li>
                    <li class="divider"></li>

                </#if>

                </ul>
            </div>
        </div>

    </@layout.block>

        <!-----------Content---------------->

    <@layout.block name="contentTask">

        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>Welcome to Todolist</h1>
                </div>


                <a href="/task/show" class="btn btn-default" data-dismiss="modal">
                    <i class="icon-list-alt"></i>
                    Open ToDo List
                </a>
            </div>
        </div>



    </@layout.block>
</body>


</html>