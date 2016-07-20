<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/default.css">
<script src="/web_kf/js/bootstrap.js"></script>
<script src="/web_kf/js/jquery.min.js"></script> 
<script src="js/dropdown.js"></script>
<title>项目管理</title>
</head>
<body style="width:80%; margin:0 auto;">
<h3 class="page-header alert alert-info center">审计署机关辅助办公系统(机关领导)<small>领导决策区</small></h3>

<ul class="nav nav-pills">
  <li><a href="/web_kf/Project_show?flag=0">项目管理</a></li>
  <li><a href="/web_kf/Contract_show?flag=0">合同管理</a></li>
  <li><a href="/web_kf/Finance_show?flag=0">财务管理</a></li>
  <li><a href="/web_kf/Asset_show?flag=0">资产管理</a></li>
  <li class="active"><a href="/web_kf/Document_show">档案管理</a></li>
  <li><a href="/web_kf/Budget_show">预算管理</a></li>
  <li><a href="/web_kf/Base_info">基础信息维护</a></li>
  <li><a href="/web_kf/Project_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>
  
</ul>
<br />

 <div class="input-group">
	      <input type="text" class="form-control" placeholder="项目名称" >
	      <span class="input-group-btn">
	        <button class="btn btn-default" type="button">查询</button>
	      </span>
</div><!-- /input-group -->
<br />

<div class="panel panel-primary">
<div class="panel-heading center">项目列表</div>
<div class="panel-body">
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	<td>项目编号</td>
	<td>项目名称</td>
	<td></td>
	</tr>
	<c:forEach items="${requestScope.dt_list }" var="dt">
	<tr>
	<td>${dt.project_id}</td>
	<td>${dt.project_id}项目名称</td>
	<td><button type="button" class="btn btn-default">档案管理</button></td>
	</tr>
	</c:forEach>
</table>
</div>
</div>


</body>
</html>