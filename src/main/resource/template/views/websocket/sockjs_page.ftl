<!DOCTYPE>
<html>
    <head>
        <title>
            sockjs测试
        </title>
        <#include "/template/views/common/component.ftl"/>
        <script type="text/javascript" src="/template/static/js/websocket/sockjs_page.js"></script>
    </head>

    <body>
        <div class="simpleWebSocket">
            <input type="text" id="sendData" name="sendData"/>
            <button id="sendButton" class="sendButton">发送</button>
            <button id="setUpConnection" class="setUpConnection">连接</button>
            <button id="closeConnection" class="closeConnection">关闭连接</button>
            <div id="receiveData" class="receiveData" style="color: #FF0000;">
                接收到的参数：
            </div>
        </div>
    </body>
</html>