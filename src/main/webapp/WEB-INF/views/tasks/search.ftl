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
                <h1>Search results</h1>
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

                    <tr>
                        <td>${task.id}</td>
                        <td>${task.title}</td>
                        <td>${task.dueDate}</td>
                        <td>${task.priority}</td>
                        <td>${task.done?c}</td>
                        <td>
                            <a class="btn btn-mini btn-primary" <i class="icon-edit icon-white"></i> Edit</a>
                            <a class="btn btn-mini btn-danger"  <i class="icon-remove icon-white"></i> Delete</a>

                        </td>
                    </tr>


                </tbody>
            </table>
            <div class="form-actions">
                <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Back</button>
            </div>
        </div>
    </div>



</@layout.put>
</@layout.extends>