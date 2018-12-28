$(function() {

    var sock;

    $("#sendButton").click(function() {
        var sendData = $("#sendData").val();
        sock.send(sendData);
    });
    $("#setUpConnection").click(function() {
        sock = new SockJS('http://127.0.0.1:8080/simpleWebSocket');
        sock.onopen = function() {
            $("#receiveData").append("<p>连接已建立</p>");
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