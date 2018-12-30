<!DOCTYPE>
<html>
    <meta charset="UTF-8"/>
    <head>
        <title>主页</title>
        <link rel="stylesheet" type="text/css" href="/template/static/css/index.css">
        <script type="text/javascript" src="/template/static/js/index.js"></script>
    </head>

    <body>
        <ul class="left-munu">
            <li><a href="/form/test">表单测试</a></li>
            <li><a href="/websocket/simple/page">简单 页面</a></li>
            <li><a href="/websocket/sockjs/page">sockjs 页面</a></li>
            <li><a href="/websocket/stomp/page">stomp 页面</a></li>
        </ul>




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