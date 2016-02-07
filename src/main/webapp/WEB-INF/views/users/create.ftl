<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>


<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Create new User</@layout.put>
    <@layout.put block="contentTask" type="replace">


    <div class="span9">
        <div class="well">
            <div class="page-header">
                <h1>Create new User</h1>
            </div>

            <div class="row">
                <form role="form" class="form-horizontal" action="<@c.url value='/user/create' />" method="POST">


                    <!--Name-->
                    <div class="control-group">
                        <label class="control-label" for="userName">User name:</label>

                        <div class="controls">
                            <input type="text" id="userName" name="userName" required="required"
                                   autofocus="autofocus"/>
                        </div>
                    </div>

                    <!--Password-->
                    <div class="control-group">
                        <label class="control-label" for="password">Password:</label>

                        <div class="controls">
                            <input type="text" id="password" name="password" required="required"
                                   autofocus="autofocus"/>
                        </div>
                    </div>


                    <!--Priority-->
                    <div class="control-group">
                        <label class="control-label" for="role">Role:</label>

                        <div class="controls">
                            <select id="role" path="role" name="role">
                                <option value="ROLE_USER" selected>User</option>
                                <option value="ROLE_ADMIN" >Admin</option>
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