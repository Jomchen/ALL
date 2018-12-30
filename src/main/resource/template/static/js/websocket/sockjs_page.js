$(function() {

    var sock;

    $("#sendButton").click(function() {
        var sendData = $("#sendData").val();
        sock.send(sendData);
    });
    $("#setUpConnection").click(function() {
        sock = new SockJS('http://127.0.0.1:8080/simpleWebSocket');
        sock.onopen = function() {
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
        sock.onmessage = function(e) {
            $("#receiveData").append("<p>" + e.data + "</p>");
        };
        sock.onclose = function() {
            $("#receiveData").append("<p>连接已经关闭或不能打开</p>");
        };
    });
    $("#closeConnection").click(function() {
        sock.close();
    });
});