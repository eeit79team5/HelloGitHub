<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>JavaScript Homework</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="StyleSheet.css" rel="stylesheet" />         
   
    <script src="javascript/jquery-1.11.3.min.js"></script>
    <script src="pinterest_grid.js"></script>
    <script src="JavaScript.js"></script>
<!--     <script> -->
<!--     </script> -->

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="#">JavaScript<br />&nbsp;&nbsp;&nbsp;Homework</a></h1>
                <p><i>by EEIT7923 �L�T��</i></p>
            </div>
        </div>
        <!-- end #header -->
        <div id="menu">
            <ul>
                <li><a href="homepage.jsp">����</a></li>
                <li class="current_page_item"><a href="album.jsp">��ï</a></li>
                <li><a href="friend.jsp">�n��</a></li>
                <li><a href="like.jsp">Like</a></li>
                <li><a href="follow.jsp">Follow</a></li>
                <li><a href="group.jsp">����</a></li>
                <li><a href="profile.jsp">�ӤH�ɮ�</a></li>
            </ul>
        </div>
        <!-- end #menu -->
        <div id="page">
            <div id="content">
                <div id="banner">
                    <img src="images/img07.jpg" alt="" />
                </div>
                <div class="post">
                    <h2 class="title"><b>��ï</b></h2>
                    
                    <div class="entry">
    <script>
        document.write('<section id="demo">');
        for (var i = 1; i <= 20; i++) {
            document.write('<article class="white-panel">');
            document.write('<img src="sample-images/image_' + i + '.jpg" alt="ALT">');
            document.write('<h1><a href="#">Title ' + i + '</a></h1>');
            document.write('<p>Description ' + i + '</p>');
            document.write('</article>');
        }
        document.write('</section>');
    </script>              
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