$(function () {

    var stompClient;

    /**
     * 建立连接
     */
    $("#setUpConnection").click(function () {
        var loginName = prompt("请办理入您的登录名字，默认为 lemonwind", "lemonwind");
        var sockJS = new SockJS('http://127.0.0.1:8080/stompPoint');
        stompClient = Stomp.over(sockJS);
        stompClient.connect(
            /*{"login": null, "passcode": null // 其它回调},*/
            {"username": loginName, "password": loginName},
            function() {
                $("#receiveData").append("<p>已经建立连接</p>");
                // 订阅的第三个参数是在发订阅帧时指定的id，如果未指定会自动生成 {id: "xxx"}
                var broadId = this.subscribe("/topic/greeting", function(data) {
                    console.log("topic接收到参数是：" + data);
                    var resultData = JSON.parse(data.body);
                    if (resultData.code == 0) {
                        $("#receiveData").append("<p>topic回调体=>" + resultData.data + "</p>");
                    } else {
                        $("#receiveData").append("<p>topic回调体=>" + resultData.message + "</p>");
                    }
                }, {"otherHeaders": "otherHeaders"});
                var queueId = this.subscribe("/queue/greeting", function(data) {
                    console.log("广播接收到参数是：" + data);
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>queue回调体=>" + resultData.data + "</p>");
                }, {"otherHeaders": "otherHeaders"});
                var sendToMySelfId = this.subscribe("/user/queue/sendToMySelf", function(data) {
                    console.log("发给自己的接收到参数是：" + data);
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>发给自己的回调体=>" + resultData.data + "</p>");
                }, {"otherHeaders": "otherHeaders"});
                var sendToUserId = this.subscribe("/user/queue/sendToUser", function(data) {
                    console.log("指定发送接收到参数是：" + data);
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>指定发送的回调体=>" + resultData.data + "</p>");
                }, {"otherHeaders": "otherHeaders"});
                this.subscribe("/app/once_once", function(data) {
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>一次性subscribe回调体=>" + resultData.data + "</p>");
                }, {"otherHeaders": "otherHeaders"});
            },
            function(error) {
                $("#receiveData").append("<p>连接已断开=>" + error + "</p>");
            }
        );
    });

    /**
     * 发送信息
     */
    $("#sendButton").click(function() {
        var data = $("#sendData").val();
        var sendObj = {"requestId": "Linux", "data": data};
        var sendStomp = JSON.stringify(sendObj);

        var hasBroad = confirm("是否广播发送？");
        if (hasBroad) {
            stompClient.send("/app/greeting", {}, sendStomp);
            return;
        }
        var hasPersonal = confirm("是否发给自己？");
        if (hasPersonal) {
            stompClient.send("/app/sendToMySelf", {}, sendStomp);
            return;
        }

        var sendUser = prompt("指定您要发送的用户，默认为 lemonwind", "lemonwind");
        var dataObj = {"sendUser": sendUser, "sendData": data};
        sendObj['data'] = dataObj;
        stompClient.send("/app/sendToUser", {}, JSON.stringify(sendObj));
    });

    /**
     * 关闭连接
     */
    $("#closeConnection").click(function () {
        stompClient.disconnect();
        $("#receiveData").append("<p>连接已关闭</p>");
    });
});