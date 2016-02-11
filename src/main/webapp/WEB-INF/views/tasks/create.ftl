<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>
<#assign aDateTime = .now>


<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Create task</@layout.put>
    <@layout.put block="contentTask" type="replace">


    <div class="span9">
        <div class="well">
            <div class="page-header">
                <h1>Create a new todo</h1>
            </div>

                <form role="form" class="form-horizontal" action="<@c.url value='/task/create' />" method="POST">


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
                        <label class="control-label" for="dueDate">Due Date:</label>

                        <div class="controls">

                            <input type='text' class="form-control" id='dueDate' name="dueDate"  value="${aDateTime?date?string["MM/dd/yyyy"]}" required="required"/>
                            <script type="text/javascript">
                                $(function () {
                                    $('#dueDate').datepicker(
                                            { format: 'mm/dd/yyyy', defaultDate: new Date()}).on('changeDate', function(e){
                                                $(this).datepicker('hide');
                                            });

                                });
                            </script>
                        </div>
                    </div>

                    <!--Hours-->
                    <div class="control-group">
                        <label class="control-label" for="countHours">Hours for task:</label>

                        <div class="controls">
                            <input type="text" id="countHours" name="countHours" value="1" required="required"/>
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

                            <a href="/task/show" class="btn btn-default" data-dismiss="modal">
                                <i class="icon-arrow-left"></i>
                                Back
                            </a>
                    </div>

                </form>


        </div>
    </div>

    </@layout.put>
</@layout.extends>