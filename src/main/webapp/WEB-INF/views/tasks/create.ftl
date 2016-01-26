<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>


<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Create task</@layout.put>
    <@layout.put block="topmenu.task.create.active">class="active"</@layout.put>
    <@layout.put block="contentTask" type="replace">


    <div class="span9">
        <div class="well">
            <div class="page-header">
                <h1>Create a new todo</h1>
            </div>

            <div class="row">
                <form role="form" class="form-horizontal" action="<@c.url value='/tasks/create' />" method="POST">

                    <!--Title-->
                    <div class="control-group">
                        <label class="control-label" for="title">Title:</label>

                        <div class="controls">
                            <input type="text" id="title" name="title" required="required"
                                   autofocus="autofocus"/>
                        </div>
                    </div>

                    <!--Due Date-->
                    <div class="control-group">
                        <label class="control-label" for="title">Due Date:</label>

                        <div class="controls">

                            <input type='text' class="form-control" id='dateInput' name="dueDate"/>
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
                                <option value="LOW" selected>Low</option>
                                <option value="MEDIUM" >Medium</option>
                                <option value="HIGH" >High</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><i class="icon-ok icon-white"></i> Create</button>
                        <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                    </div>

                </form>
            </div>


        </div>
    </div>

    </@layout.put>
</@layout.extends>