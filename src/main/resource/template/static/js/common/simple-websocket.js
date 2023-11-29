/* -------------------------------------------------
    状态：
    0 - 未建立连接
    1 - 已建立连接
    2 - 连接正在进行关闭
    3 - 连接已经关闭或不能打开
------------------------------------------------- */

function WebSocketFunction() {
    this.simpleUrl;
    this.onopenEvent = function(state) {};
    this.oncloseEvent = function() {};
    this.onmessageEvent = function(message) {};
    this.onerrorEvent = function() {};
}

function lemonwindSimpleWebSocket(websocketFunction) {
    this.websocket;
    this.closeWebSocket = function() {
        this.websocket.close();
    };
    this.sendData = function(data) {
        if (null == this.websocket || this.websocket.readyState != 1) {
            alert('未连接到服务器');
            return;
        }
        this.websocket.send(data);
    };

    this.setUpConnection = function () {
        if (undefined == this.websocket) {
            this.websocket = new WebSocket(websocketFunction.simpleUrl); // 第二个参数是 协议
        }
        if (1 == this.readyState) {
            return;
        }
        this.websocket.onopen = function() {
            var stateNumber = this.readyState;
            websocketFunction.onopenEvent(stateNumber);
        };

        var _lemonwindWebSocket = this;
        window.onbeforeunload = function() {
            _lemonwindWebSocket.closeWebSocket();
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

function lemonwindStompWebSocket() {
    this.websocket;
    this.setUpConnection;
    this.sendData;
    this.closeWebSocket;
}

/*
function lemonwindWebSocket() {
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

        var _lemonwindWebSocket2 = this;
        window.onbeforeunload = function() {
            _lemonwindWebSocket2.closeWebSocket();
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
