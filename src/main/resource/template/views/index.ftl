<!DOCTYPE>
<html>
<head>
    <title>Homepage</title>
    <script type="text/javascript" src="/template/static/libs/jquery-3.3.1/jquery-3.3.1.js"></script>
    <link rel="stylesheet" type="text/css" href="/template/static/css/index.css">
    <script type="text/javascript" src="/template/static/js/index.js"></script>
</head>

<body>
    <div id="Homepage-all-div">
        <!-- banner -->
        <div id="Homepage-banner-div"></div>
        <!-- 导航 -->
        <div id="Homepage-navigation-div">
            <ul class="navigation-content">
                <li>
                    <a class="navigation-title" href="#">测试页面</a>
                    <ul class="navigation-content">
                        <li><a href="/form/test">表单测试</a></li>
                        <li><a href="/websocket/simple/page">简单 页面</a></li>
                        <li><a href="/websocket/sockjs/page">sockjs 页面</a></li>
                        <li><a href="/websocket/stomp/page">stomp 页面</a></li>
                        <li><a href="/test/upload/page">上传文件页面</a></li>
                    </ul>
                </li>
                <li>
                    <a class="navigation-title" href="#">武功</a>
                    <ul class="navigation-content">
                        <li><a href="#">独孤九剑</a></li>
                        <li><a href="#">九阳真经</a></li>
                        <li><a href="#">九阴真经</a></li>
                        <li><a href="#">易筋经</a></li>
                    </ul>
                </li>
                <li>
                    <a class="navigation-title" href="#">人物</a>
                    <ul class="navigation-content">
                        <li><a href="#">独孤求败</a></li>
                        <li><a href="#">风清扬</a></li>
                        <li><a href="#">斗酒神僧</a></li>
                        <li><a href="#">黄裳</a></li>
                    </ul>
                </li>
                <li>
                    <a class="navigation-title" href="#">课程</a>
                    <ul class="navigation-content">
                        <li><a href="#">语文</a></li>
                        <li><a href="#">数学</a></li>
                        <li><a href="#">英语</a></li>
                        <li><a href="#">物理</a></li>
                        <li><a href="#">化学</a></li>
                        <li><a href="#">生物</a></li>
                    </ul>
                </li>
                <li>
                    <a class="navigation-title" href="#">语言</a>
                    <ul class="navigation-content">
                        <li><a href="#">汉语</a></li>
                        <li><a href="#">英语</a></li>
                        <li><a href="#">法语</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- 主要内容 -->
        <div id="Homepage-content-div">
            <p>变量和常量 --------------------------------------------- START</p>
            <div>username：${username}</div>
            <div>adminName：${adminName}</div>
            <div>adminAge：${adminAge}</div>
            <div>myTime：${myTime?string('yyyy-MM-dd HH:mm:ss')}</div>
            <#list list as i >
                <p>${i}</p>
            </#list>
            <p>变量和常量 --------------------------------------------- END</p>
            <div class="index">我的外部样式</div>
            <#import "/template/views/common/macro00.ftl" as p/>
            <@p.pp>独孤求败</@p.pp>
        </div>
    </div>

    </body>
</html>
