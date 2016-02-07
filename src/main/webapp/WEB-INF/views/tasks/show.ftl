<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Show ToDoList</@layout.put>
    <@layout.put block="topmenu.task.show.active">class="active"</@layout.put>
    <@layout.put block="contentTask" type="replace">


    <div class="span9" xmlns="http://www.w3.org/1999/html">
        <div class="well">
            <div class="page-header">
                <h1>My Todo list</h1>
            </div>

        <#if tasks?has_content>
            <table class="table table-bordered table-striped">

                <thead>
                <tr>
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
                        <td>${currentTask.title}</td>
                        <td>${currentTask.dueDate}</td>
                        <#if currentTask.priority??>
                            <td>${currentTask.priority}</td><#else>
                            <td>null</td></#if>

                        <td>
                            <#if currentTask.status =="DONE">
                            <span class="label label-success">
                            <#else>
                            <span class="label label label-default">
                            </#if>
                        ${currentTask.status}</span></td>
                        <td>
                            <a class="btn btn-mini btn-primary" href="/task/${currentTask.id}/edit"><i
                                    class="icon-pencil icon-white"></i></a>
                            <a class="btn btn-mini btn-danger" data-toggle="modal"
                               href="#confirm_delete_${currentTask.id}"><i class="icon-remove icon-white"></i></a>

                            <div class="modal hide" id="confirm_delete_${currentTask.id}">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">x</button>
                                    <h3>Confirmation</h3>
                                </div>
                                <div class="modal-body">
                                    <p>Are you sure to delete task "${currentTask.title}" ?</p>
                                </div>
                                <div class="modal-footer">
                                    <form action="/task/${currentTask.id}/delete" method="post">
                                        <button type="submit" class="btn btn-primary">Yes</button>
                                        <a href="#" class="btn" data-dismiss="modal">No</a>

                                    </form>
                                </div>
                            </div>

                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        <#else>

            <div class="alert alert-info">You have not any task. You can create it right now!</div>
        </#if>



            <a href="/task/create" class="btn btn-default" data-dismiss="modal">
                <i class="icon-plus"></i>
                Create task
            </a>
        </div>

    </div>



    </@layout.put>
</@layout.extends>