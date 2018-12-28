$(function() {

    /*var jomchenWebSocket = new JomchenWebSocket();
    jomchenWebSocket.setUpConnection();*/


    var simpleWebSocket = new SimpleWebSocket({
        jomchenWebSocketUrl: "ws://127.0.0.1:8080/simpleWebSocket",
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


function WebSocketFunction() {
    this.jomchenWebSocketUrl;
    this.onopenEvent = function(state) {};
    this.oncloseEvent = function() {};
    this.onmessageEvent = function(message) {};
    this.onerrorEvent = function() {};
}

function SimpleWebSocket(websocketFunction) {
    this.websocket;
    this.closeWebSocket = function() {
        this.websocket.close();
    };
    this.sendData = function(data) {
        if (null == this.websocket || this.websocket.readyState != 1) {
            alert('未连接到服务器')
            return;
        }
        this.websocket.send(data);
    };

    this.setUpConnection = function () {
        if (undefined == this.websocket) {
            this.websocket = new WebSocket(websocketFunction.jomchenWebSocketUrl); // 第二个参数是 协议
        }
        if (1 == this.readyState) {
            return;
        }
        this.websocket.onopen = function() {
            var stateNumber = this.readyState;
            websocketFunction.onopenEvent(stateNumber);
        };

        var _jomchenWebSocket = this;
        window.onbeforeunload = function() {
            _jomchenWebSocket.closeWebSocket();
        };
        this.websocket.onmessage = function(ev) {
            websocketFunction.onmessageEvent(ev.data);
        };
        this.websocket.onerror = function() {
            websocketFunction.onerrorEvent();
        };
        this.websocket.onclose = function() {
            websocketFunction.oncloseEvent();
        };
    };
}


/*
function JomchenWebSocket() {
    this.websocket;
    this.closeWebSocket = function() {
        this.websocket.close();
    };
    this.sendData = function(data) {
        this.websocket.send(data);
    };
    this.setUpConnection = function () {
        this.websocket = new WebSocket("ws://127.0.0.1:8080/simpleWebSocket"); // 第二个参数是 协议
        this.websocket.onopen = function() {
            var stateNumber = this.readyState;
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
        };

        var _jomchenWebSocket2 = this;
        window.onbeforeunload = function() {
            _jomchenWebSocket2.closeWebSocket();
        };
        this.websocket.onmessage = function(ev) {
            var receiveData = ev.data;
            $("#receiveData").append("<p>" + receiveData + "</p>");
        };
        this.websocket.onerror = function() {
            $("#receiveData").append("<p>错误：" + new Date() + "</p>");
        };
        this.websocket.onclose = function() {
            $("#receiveData").append("<p>连接已经关闭</p>");
        };
    };
}*/
