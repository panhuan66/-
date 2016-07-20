<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/default.css">
<script src="/web_kf/js/bootstrap.js"></script>
<script src="/web_kf/js/jquery.min.js"></script> 
<script src="js/modal.js"></script>
<script src="js/popover.js"></script>

<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <script src="/web_kf/js/bootstrap.js"></script> -->
<!-- <script src="/web_kf/js/jquery.min.js"></script>  -->
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- 		<script src="js/moment-with-locales.js"></script> -->
<!-- 		<script src="js/bootstrap-datetimepicker.js"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/fileinput_locale_zh.js" type="text/javascript"></script> -->
<script type="text/javascript">
$(document).ready(function(){
	$("#Register_ps_agin").blur(function(){
		    var pass = $("#Register_ps").val();
		    var qrpass = $("#Register_ps_agin").val();
		    if(pass == qrpass&& (pass!=null||pass==Undefined)){
		        
		        //$("#bt_register").popover('toggle')
		        $("#password_tip").text("");
		        return true;
		    }else{
		        
		        $("#password_tip").text("两次输入密码不一致");
		        return false;
		    }
	})
	
	
	$("#Register_email").blur(function(){
		var email = $("#Register_email").val(); 
		$.ajax({ 
		type : "post",//发送方式 
		url : "/web_kf/Email_ajax_check",// 路径 
		data : "Register_email="+email, 
		success: function(text){
			if(text=="ok")
				{$("#email_tip").text("");}
			else if(text=="none"){
				$("#email_tip").text("邮箱不能为空");
			}
			else
				{$("#email_tip").text("此邮箱已被注册");}
			}
		}); 
		
	})
	
	
	
})



</script>
<title>Insert title here</title>
</head>
<body style="width:80%; margin:0 auto;">
<h3 class="page-header alert alert-info center">审计署机关辅助办公系统(机关领导)<small>领导决策区</small></h3>
<ul class="nav nav-pills">
  <li><a href="/web_kf/Project_show?flag=0">项目管理</a></li>
  <li><a href="/web_kf/Contract_show?flag=0">合同管理</a></li>
  <li><a href="/web_kf/Finance_show?flag=0">财务管理</a></li>
  <li><a href="/web_kf/Asset_show?flag=0">资产管理</a></li>
  <li><a href="/web_kf/Document_show">档案管理</a></li>
  <li><a href="/web_kf/Budget_show">预算管理</a></li>
  <li><a href="/web_kf/Base_info">基础信息维护</a></li>
  <li><a href="/web_kf/Project_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li>
   <!-- Button trigger modal -->
<button class="btn btn-primary " data-toggle="modal" data-target="#login">
	登陆
</button>

<!-- Modal -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">欢迎使用审计署机关辅助办公系统</h4>
      </div>
      <div class="modal-body">
      
 <form role="form" action="Login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email"  name="Login_email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"  name="Login_ps">
  </div>
  <button type="submit" class="btn btn-default">登陆</button>
</form>
<!-- 		      姓名：<input type="text" name="name" ><br>
		     密码：<input type="password" name="ps"><br> -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <!-- <button type="button" class="btn btn-primary">登陆</button> -->
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  </li>
  
  
  
  <li>
  <!-- Button trigger modal -->
<button class="btn btn-primary " data-toggle="modal" data-target="#register">
	注册
</button>

<!-- Modal -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">欢迎加入审计署机关辅助办公系统</h4>
      </div>
      <div class="modal-body">
      
 <form role="form" action="Register" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="Register_email" placeholder="Enter email" name="Register_email">
    <label id="email_tip">  </label>
    <br/>
  </div>
  <div class="form-group">   
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="Register_ps" placeholder="Password"  name="Register_ps">
  </div>

  <div class="form-group">
    <label for="exampleInputPassword2">Password agin</label>
    <input type="password" class="form-control" id="Register_ps_agin" placeholder="Passwordagin"  name="Register_ps_agin">
    <label id="password_tip"></label>
    <br/>
  </div>
  <button type="submit" class="btn btn-default" id="bt_register" onclick="return verifyPass()" >注册</button>
</form>
</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <!-- <button type="button" class="btn btn-primary">登陆</button> -->
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  
  </li>
</ul>
<br/>



<div class="jumbotron">


  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="carousel slide" id="carousel-384545">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-384545">
					</li>
					<li data-slide-to="1" data-target="#carousel-384545">
					</li>
					<li data-slide-to="2" data-target="#carousel-384545">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/1.jpg" />
						<div class="carousel-caption">
							<h4>
								今天
							</h4>
							<p>
								审计署机关辅助办公系统(机关领导)领导决策区
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/2.jpg" />
						<div class="carousel-caption">
							<h4>
								明天
							</h4>
							<p>
								审计署机关辅助办公系统(机关领导)领导决策区
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/3.jpg" />
						<div class="carousel-caption">
							<h4>
								后天
							</h4>
							<p>
								审计署机关辅助办公系统(机关领导)领导决策区
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-384545" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-384545" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
</div>
<br/>
  <p class="center"><a class="btn btn-primary btn-lg " data-toggle="modal" data-target="#register" role="button">加入我们</a></p>
</div>


</body>
</html>