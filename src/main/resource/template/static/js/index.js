window.onload=function() {
    $(".navigation-content > li > a.navigation-title").click(function() {
        // 执行逻辑
        $(this).next(".navigation-content").slideToggle(450);
    });

    $("#Homepage-banner-div").click(function() {
        $(this).css("display","none");
    });
}
