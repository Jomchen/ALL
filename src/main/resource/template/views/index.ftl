<!DOCTYPE>
<html>
    <meta charset="UTF-8"/>
    <head>
        <title>主页</title>
        <link rel="stylesheet" type="text/css" href="/template/static/css/index.css">
        <script type="text/javascript" src="/template/static/js/index.js"></script>
    </head>

    <body>
        <a href="/form/test">表单测试</a>
        <a href="/websocket/websocket/page">websocket页面</a>
        <a href="/sockjs/page">sockjs页面</a>

        <p>变量和常量 --------------------------------------------- START</p>
        <div>username：${username}</div>
        <div>adminName：${adminName}</div>
        <div>adminAge：${adminAge}</div>
        <div>myTime：${myTime?string('yyyy-MM-dd HH:mm:ss')}</div>
        <#list list as i >
            <p>${i}</p>
        </#list>
        <p>变量和常量 --------------------------------------------- END</p>
        <div class="index">我的外部样式</div>

        <#import "/template/views/common/macro00.ftl" as p/>
        <@p.pp>独孤求败</@p.pp>
    </body>

</html>