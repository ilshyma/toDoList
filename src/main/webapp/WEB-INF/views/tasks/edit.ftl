<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>


<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Edit task</@layout.put>
    <@layout.put block="topmenu.task.create.active">class="active"</@layout.put>
    <@layout.put block="contentTask" type="replace">


    <div class="span9">
        <div class="well">
            <div class="page-header">
                <h1>Edit task</h1>
            </div>

            <div class="row">
                <form role="form" class="form-horizontal" action="<@c.url value='/task/${task.id}/edit' />"
                      method="POST">

                    <!--Title-->
                    <div class="control-group">
                        <label class="control-label" for="title">Title:</label>

                        <div class="controls">
                            <input type="text" id="title" name="title" value="${task.title}" required="required"
                                   autofocus="autofocus"/>
                        </div>
                    </div>

                    <!--Due Date-->
                    <div class="control-group">
                        <label class="control-label" for="title">Due Date:</label>

                        <div class="controls">

                            <input type='text' class="form-control" id='dateInput' name="dueDate"
                                   value="${task.dueDate}"/>
                            <script type="text/javascript">
                                $(function () {
                                    $('#dateInput').datepicker();
                                    format: 'dd.mm.yyyy'
                                });
                            </script>
                        </div>
                    </div>

                    <!--Priority-->
                    <div class="control-group">
                        <label class="control-label" for="priority">Priority:</label>

                        <div class="controls">
                            <select id="priority" path="priority" name="priority">
                                <option value="LOW" <#if task.priority == "LOW">selected</#if>>Low</option>
                                <option value="MEDIUM" <#if task.priority == "MEDIUM">selected</#if>>Medium</option>
                                <option value="HIGH" <#if task.priority == "HIGH">selected</#if>>High</option>
                            </select>
                        </div>
                    </div>

                    <!--Status-->
                    <div class="control-group">
                        <label class="control-label" for="priority">Status:</label>
                        <div class="controls">
                            <select id="status" path="status" name="status">
                                <option value="DONE" <#if task.status == "DONE">selected</#if>>Done</option>
                                <option value="IN_PROGRESS" <#if task.status == "IN_PROGRESS">selected</#if>>In progress</option>
                            </select>
                        </div>
                    </div>



                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><i class="icon-ok icon-white"></i> Save
                        </button>
                        <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i>
                            Cancel
                        </button>
                    </div>

                </form>
            </div>


        </div>
    </div>

    </@layout.put>
</@layout.extends>