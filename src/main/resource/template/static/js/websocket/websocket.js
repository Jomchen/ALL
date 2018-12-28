$(function() {

    /*var jomchenWebSocket = new JomchenWebSocket();
    jomchenWebSocket.setUpConnection();*/


    var simpleWebSocket = new SimpleWebSocket({
        simpleUrl: "ws://127.0.0.1:8080/simpleWebSocket",
        onopenEvent: function(stateNumber) {
            switch(stateNumber) {
                case 0:
                    $("#receiveData").append("<p>连接未建立</p>");
                    break;
                case 1:
                    $("#receiveData").append("<p>已经建立连接</p>");
                    break;
                case 2:
                    $("#receiveData").append("<p>连接正在进行关闭</p>");
                    break;
                case 3:
                    $("#receiveData").append("<p>连接已经关闭或不能打开</p>");
                    break;
                default:
                    $("#receiveData").append("<p>连接异常</p>");
                    break;
            }
        },
        oncloseEvent: function() {
            $("#receiveData").append("<p>连接已经关闭</p>");
        },
        onmessageEvent: function(data) {
            $("#receiveData").append("<p>" + data + "</p>");
        },
        onerrorEvent: function() {
            $("#receiveData").append("<p>错误：" + new Date() + "</p>");
        }
    });

    $("#sendButton").click(function() {
        var sendData = $("#sendData").val();
        simpleWebSocket.sendData(sendData);
    });
    $("#setUpConnection").click(function() {
        simpleWebSocket.setUpConnection();
    });
    $("#closeConnection").click(function() {
        simpleWebSocket.closeWebSocket();
    });

});

