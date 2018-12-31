$(function () {

    var stompClient;

    /**
     * 建立连接
     */
    $("#setUpConnection").click(function () {
        var sockJS = new SockJS('http://127.0.0.1:8080/stompPoint');
        stompClient = Stomp.over(sockJS);
        stompClient.connect({}, function() {
            $("#receiveData").append("<p>已经建立连接</p>");
        });

        /*stompClient.connect("username","password", 正确回调,错误回调);*/
        stompClient.connect("login","passcode", function() {},function() {});
        // 第三个参数是在发订阅帧时指定的id，如果未指定会自动生成 {id: "xxx"}
        stompClient.subscribe("/topic", function(data) {
            $("#receiveData").append("<p>" + data.body + "</p>");
        });
    });

    /**
     * 发送信息
     */
    $("#sendButton").click(function() {
        var sendData = $("#sendData").val();
        var sendJson = {"name": "Linux", "data": sendData};
        var sendStomp = JSON.stringify(sendJson);
        // 目标，头，体
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