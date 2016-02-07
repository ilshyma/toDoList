<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"] />
<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Hello!</@layout.put>

    <@layout.put block="sideMenu" type="replace"></@layout.put>
    <@layout.put block="contentTask" type="replace">


    <div class="span6">
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


    </@layout.put>



</@layout.extends>

