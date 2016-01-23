<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Show ToDoList</@layout.put>
    <@layout.put block="topmenu.task.show.active">class="active"</@layout.put>
    <@layout.put block="contentTask" type="replace">


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
                <#list tasks as currentTask>
                    <tr>
                        <td>${currentTask.id}</td>
                        <td>${currentTask.title}</td>
                        <td>${currentTask.dueDate}</td>
                        <td>${currentTask.priority}</td>
                        <td>${currentTask.done?c}</td>
                        <td>
                            <a class="btn btn-mini btn-primary" href="/task/${currentTask.id}/edit"><i class="icon-edit icon-white"></i> Edit</a>
                            <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_${currentTask.id}"><i class="icon-remove icon-white"></i> Delete</a>


                        </td>
                    </tr>
                    </#list>

                </tbody>
            </table>
        </div>
    </div>



</@layout.put>
</@layout.extends>