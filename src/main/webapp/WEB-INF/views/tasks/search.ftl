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
                <h1>Search results for title: ${searchTitle}</h1>
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

                <tbody>

                    <#list tasks as currentTask>
                    <tr>
                        <td>${currentTask.title}</td>
                        <td>${currentTask.dueDate}</td>
                        <#if currentTask.priority??><td>${currentTask.priority}</td><#else><td>null</td></#if>

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
                                    <p>Are you sure to delete todo ${currentTask.id} '${currentTask.title}' ?</p>
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
            <div class="alert alert-info">No results!</div>
        </#if>
            <div class="form-actions">
                <a href="/task/show" class="btn btn-default" data-dismiss="modal">
                    <i class="icon-arrow-left"></i>
                    Back
                </a>
            </div>
        </div>
    </div>



</@layout.put>
</@layout.extends>