<?php
	if(isset($_COOKIE["id"]))
        ;
	else{
        echo "<script language='javascript'>window.location.replace('login.php');</script>";
        return;
	}
	$id=$_COOKIE["id"];
	$mysql_host = SAE_MYSQL_HOST_M;
    $mysql_host_s = SAE_MYSQL_HOST_S;
    $mysql_port = SAE_MYSQL_PORT;
    $mysql_user = SAE_MYSQL_USER;
    $mysql_password = SAE_MYSQL_PASS;
    $mysql_database = SAE_MYSQL_DB;

	$mysql_table = "user";
	//$mysql_table = "user_manager";
    $con = mysql_connect($mysql_host.':'.$mysql_port, $mysql_user, $mysql_password, true);
    
    if (!$con){
        die('Could not connect: ' . mysql_error());
    }
	mysql_query("SET NAMES 'UTF8'");
    mysql_select_db($mysql_database, $con);
	$Result = mysql_query("SELECT * FROM ".$mysql_table." WHERE id='".$id."'");
    $row = mysql_fetch_array($Result);
	$msg="欢迎".$row[username];
	/*$first_letter=mb_substr($row[NickName],2,1,"utf8");
	$nickname=$row[NickName];*/
?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/index_upload.css">
<link rel="stylesheet" href="css/lightbox.css" media="screen"/>
<script src="http://libs.useso.com/js/jquery/1.9.0/jquery.min.js"></script>
<script src="js/lightbox-2.6.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=no" />
<title>题库系统-账户管理</title>
</head>
<body>

    <DIV class="font_head">东华大学</DIV>
    <DIV class="font_subhead2">题库系统</DIV>
    <div class="div_none_decoration font_note_details_dark" style="text-align:center;margin:-10 0 0;"><?php echo $msg;?></div>
    <center><div><a href="addmail.php"><button class="div_button_middle">绑定邮箱</button></a></div>
        <div><a href="change.php"><button class="div_button_middle">修改密码</button></a></div>
        <div><a href="index.php"><button class="div_button_middle">&nbsp&nbsp返&nbsp&nbsp&nbsp回&nbsp&nbsp</button></a></div>
    </center>
</body>
</html>