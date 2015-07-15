<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>JavaScript Homework</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        body {
        }

        #container {
            width: 1000px;
            height: 409px;
            position: relative;
            margin: 20px auto;
            overflow: hidden;
            float: left;
            right: 215px;
        }

        #list {
            width: 5000px;
            height: 409px;
            position: absolute;
            z-index: 1;
        }

            #list img {
                float: left;
                display: block;
            }

        #pre {
            background-image: url(images/LA.png);
            width: 45px;
            height: 45px;
            float: left;
            position: absolute;
            top: 190px;
            left: 10px;
            cursor: pointer;
            display: none;
            z-index: 2;
        }

        #next {
            background-image: url(images/RA.png);
            width: 45px;
            height: 45px;
            float: left;
            position: absolute;
            top: 190px;
            right: 10px;
            cursor: pointer;
            display: none;
            z-index: 2;
        }

        #container:hover #pre, #container:hover #next {
            display: block;
        }

        #pre:hover, #next:hover {
            background-color: rgba(0,0,0,0.7);
        }

        #dot {
            width: 1000px;
            height: 10px;
            position: absolute;
            bottom: 15px;
            left: 420px;
            z-index: 10;
        }

            #dot span {
                width: 10px;
                height: 10px;
                display: block;
                border-radius: 10px;
                background-color: #fff;
                margin: 0 5px;
                float: left;
                cursor: pointer;
            }

            #dot .on {
                background-color: #69aaec;
            }

        button {
            position: relative;
            right: 50%;
            float: right;
        }
    </style>

    <script type="text/javascript">

    </script>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="#">JavaScript<br />&nbsp;&nbsp;&nbsp;Homework</a></h1>
                <p><i>by EEIT7923 林俊佑</i></p>
            </div>
        </div>
        <!-- end #header -->
        <div id="menu">
            <ul>
                <li><a href="homepage.jsp">首頁</a></li>
                <li><a href="album.jsp">相簿</a></li>
                <li><a href="friend.jsp">好友</a></li>
                <li><a href="like.jsp">Like</a></li>
                <li class="current_page_item"><a href="follow.jsp">Follow</a></li>
                <li><a href="group.jsp">社團</a></li>
                <li><a href="profile.jsp">個人檔案</a></li>
            </ul>
        </div>
        <!-- end #menu -->
        <div id="page">
            <div id="content">
                <div id="banner">
                    <img src="images/img07.jpg" alt="" />
                </div>
                <div class="post">
                    <h2 class="title"><b>Follow</b></h2>
                    
                    <div class="entry">

                    </div>
                </div>
                <div style="clear: both;">&nbsp;</div>
            </div>
            <!-- end #content -->
            <div style="clear: both;">&nbsp;</div>
        </div>
        <!-- end #page -->
    </div>
    <div id="footer">
        <p>(c) 2009 Sitename.com. Design by <a href="http://www.nodethirtythree.com">nodethirtythree</a> and <a href="http://www.freecsstemplates.org">Free CSS Templates</a>.</p>
        <p class="foot">
            <!-- please do not remove to support us-->
            Downloaded from <a href="http://www.libdesigner.com/category/icons/" title="Web Design Icons">Web Design Icons</a>
        </p>
    </div>
    <!-- end #footer -->
</body>
</html>