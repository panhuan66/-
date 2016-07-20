<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/default.css">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="/web_kf/js/bootstrap.js"></script>
<script src="/web_kf/js/jquery.min.js"></script> 
<!-- <script src="js/modal.js"></script>
<script src="js/popover.js"></script>
<script src="js/dropdown.js"></script> -->
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script src="js/moment-with-locales.js"></script>
		<script src="js/bootstrap-datetimepicker.js"></script>


<script src="js/bootstrap-select.js"></script> 
<!-- <link rel="stylesheet" href="css/bootstrap-select.css"> -->

	
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/default.css">
<title>Insert title here</title>
</head>
<body style="width:80%; margin:0 auto;">
<h3 class="page-header alert alert-info center">审计署机关辅助办公系统(机关领导)<small>领导决策区</small></h3>
<ul class="nav nav-pills">
  <li><a href="/web_kf/Project_show?flag=0">项目管理</a></li>
  <li><a href="/web_kf/Contract_show?flag=0">合同管理</a></li>
  <li ><a href="/web_kf/Finance_show?flag=0">财务管理</a></li>
  <li><a href="/web_kf/Asset_show?flag=0">资产管理</a></li>
  <li><a href="/web_kf/Document_show">档案管理</a></li>
  <li><a href="/web_kf/Budget_show">预算管理</a></li>
  <li class="active"><a href="/web_kf/Base_info">基础信息维护</a></li>
  <li><a href="/web_kf/Project_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>
  
</ul>
<br />

<div class="panel panel-primary">
<div class="panel-heading center">工程信息</div>
<div class="panel-body">
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	<td></td>
	<td>序号</td>
	<td>名称</td>
	</tr>
	<tr>
	<td><input type="radio" name="fc"></td>
	<td>1</td>
	<td>金审工程一期</td>
	</tr>

</table>
</div>
</div>
<br />

<div class="panel panel-primary">
<div class="panel-heading center">工程信息维护</div>
<div class="panel-body">
<table class="table table-hover table-responsive table-striped">
	<tr class="success">

	<td>序号</td>
	<td><input type="text" class="form-control" placeholder="序号" name="bi_num_cx"></td>
	</tr>
	<tr>

	<td>名称</td>
	<td><input type="text" class="form-control" placeholder="名称" name="bi_name_cx"></td>
	</tr>
</table>
	<div class="center-block">
		<button type="button" class="btn btn-primary">添加</button>
		<button type="button" class="btn btn-success">查询</button>
		<button type="button" class="btn btn-info">修改</button>
	</div>
</div>
</div>



</body>
</html>