$(function () {

    var stompClient;

    /**
     * 建立连接
     */
    $("#setUpConnection").click(function () {
        var sockJS = new SockJS('http://127.0.0.1:8080/stompPoint');
        stompClient = Stomp.over(sockJS);
        stompClient.connect(
            /*{"login": null, "passcode": null // 其它回调},*/
            {"username": "jomchen", "password": "password"},
            function() {
                $("#receiveData").append("<p>已经建立连接</p>");
                // 订阅的第三个参数是在发订阅帧时指定的id，如果未指定会自动生成 {id: "xxx"}
                var subscribeIdOne = this.subscribe("/topic/greeting", function(data) {
                    console.log("topic接收到参数是：" + data);
                    var resultData = JSON.parse(data.body);
                    if (resultData.code == 0) {
                        $("#receiveData").append("<p>topic回调体=>" + resultData.data + "</p>");
                    } else {
                        $("#receiveData").append("<p>topic回调体=>" + resultData.message + "</p>");
                    }
                }, {"otherHeaders": "otherHeaders"});
                var subscribeIdTwo = this.subscribe("/queue/greeting", function(data) {
                    console.log("queue接收到参数是：" + data);
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>queue回调体=>" + resultData.data + "</p>");
                }, {"otherHeaders": "otherHeaders"});
                this.subscribe("/app/once_once", function(data) {
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>一次性subscribe回调体=>" + resultData.data + "</p>");
                }, {"otherHeaders": "otherHeaders"});
                this.subscribe("/user/greeting", function(data) {
                    var resultData = JSON.parse(data.body);
                    $("#receiveData").append("<p>指定用户回调体=>" + resultData.data + "</p>");
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
        var sendData = $("#sendData").val();
        var sendJson = {"requestId": "Linux", "data": sendData};
        var sendStomp = JSON.stringify(sendJson);
        stompClient.send("/app/greeting", {}, sendStomp);

    });

    /**
     * 关闭连接
     */
    $("#closeConnection").click(function () {
        stompClient.disconnect();
        $("#receiveData").append("<p>连接已关闭</p>");
    });
});