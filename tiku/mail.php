<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/index_upload.css">
<link rel="stylesheet" href="css/lightbox.css" media="screen"/>
<script src="http://libs.useso.com/js/jquery/1.9.0/jquery.min.js"></script>
<script src="js/lightbox-2.6.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=no" />
<title>题库系统-邮件发送</title>
<script>
    function Check(){
        var myreg = /(\S)+[@]{1}(\S)+[.]{1}(\w)+/;
        if(form1.Mail.value!="")
        {
            if(!myreg.test(form1.Mail.value))
            {
                alert("请输入有效的Email!");
                return false;
            }
            return true;
        }
    }
</script>
</head>
<body>
    <DIV class="font_head">东华大学</DIV>
    <DIV class="font_subhead2">题库系统</DIV>
    <div class="div_none_decoration font_note_details_dark" style="text-align:center;">如果您进行过邮箱绑定我们将把密码发送至您的绑定邮箱</div><br/>
    <center><form action="sendmail.php" method="POST" class="form" name="form" id="form1">
        <div><lable class="font_note">&nbsp邮 箱&nbsp</lable><input type="text" id="input" class="input" name="Mail" /></div>
        <button class="div_button_middle" onclick="return Check()">发送邮件</button>
        </form>
        <div style="margin:-20 0;"><a href="loginout.php"><button  class="div_button_middle">&nbsp&nbsp返&nbsp&nbsp&nbsp回&nbsp&nbsp</button></a></div>
    </center>
</body>
</html>