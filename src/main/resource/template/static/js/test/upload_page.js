$(function() {

    $("#uploadButton").click(function() {
        var uploadFile = $("#uploadFile")[0].files[0];
        console.log("--------fileName: " + uploadFile.name);
        console.log("--------size: " + uploadFile.size);
        var formData = new FormData();
        formData.append("uploadFile", uploadFile);
        formData.append("discrible", "Jomchen");
        $.ajax({
            url: "/test/upload/file",
            type: "POST",
            data: formData,
            async: true,
            processData: false, // 很重要，告诉jquery不要对form进行处理
            contentType: false, // 很重要，指定为false才能形成正确的Content-Type
            success: function(result) {
                console.log("请求成功");
                console.log(result);
            },
            error: function(result) {
                alert("请求错误");
            }
        });
    });

    $("#testButton").click(function() {
        console.log("我是测试的哦！！！");
    });

});