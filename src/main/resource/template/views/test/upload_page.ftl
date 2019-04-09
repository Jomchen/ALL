<!DOCTYPE>
<html>
    <meta charset="UTF-8"/>
    <head>
        <title>上传页面</title>
        <#include "/template/views/common/component.ftl"/>
        <script type="text/javascript" src="/template/static/js/test/upload_page.js"></script>
    </head>

    <body>
        <div>
            <input type="file" id="uploadFile" name="uploadFile"/>
            <input type="button" value="上传" id="uploadButton" name="uploadButton"/>
            <input type="button" value="测试按钮" id="testButton" name="testButton"/>
        </div>
    </body>
</html>