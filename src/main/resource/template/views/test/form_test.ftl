<!DOCTYPE>
<html>
    <meta charset="UTF-8"/>
    <head>
        <title>表单测试</title>
        <#include "/template/views/common/component.ftl"/>
        <link rel="stylesheet" href="/template/static/css/test/form_test.css"/>
        <script type="text/javascript" src="/template/static/js/test/form_test.js"></script>
    </head>

    <body>
        <div class="form_test">
            <form action="#" id="form-test-data">
                <div class="input-content">
                    <lable>用户名*</lable>
                    <input type="text" name="username"/>
                    <span class="input-error">错误</span>
                </div>
                <div class="input-content">
                    <lable>密码*</lable>
                    <input type="password" name="password"/>
                    <span class="input-error">错误</span>
                </div>
                <div class="input-content">
                    <lable>年龄*</lable>
                    <input type="text" name="age"/>
                    <span class="input-error">错误</span>
                </div>
                <div class="input-content">
                    <lable>性别*</lable>
                    <label class="sex-choice" for="sex-man">男</label>
                    <input type="radio" name="sex" value="0" id="sex-man"/>
                    <label class="sex-choice" for="sex-woman">女</label>
                    <input type="radio" name="sex" value="1" id="sex-woman"/>
                </div>

                <input type="button" class="test-submit" value="提交"/>
            </form>
        </div>
    </body>
</html>