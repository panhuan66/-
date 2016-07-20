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
<!-- <script src="js/dropdown.js"></script> -->
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script src="js/moment-with-locales.js"></script>
		<script src="js/bootstrap-datetimepicker.js"></script>
		
<script src="js/bootstrap-select.js"></script> 
<link rel="stylesheet" href="css/bootstrap-select.css">

    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/fileinput_locale_zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#bt_cx1").click(function(){
		//alert("ss");
		$("#as_cx1").attr("action","/web_kf/Query_any").submit();
	});
	$("#bt_excel").click(function(){
		//alert("ss");
		$("#fr_excel").attr("action","/web_kf/Query_any").submit();
	});
	$("#bt_del").click(function(){
		//alert("ss");
		$("#fr_show").attr("action","/web_kf/Delete_all").submit();
	});

});
</script>
<title>资产管理</title>
</head>
<body style="width:80%; margin:0 auto;">
<h3 class="page-header alert alert-info center">审计署机关辅助办公系统(机关领导)<small>领导决策区</small></h3>
<ul class="nav nav-pills">
  <li><a href="/web_kf/Project_show?flag=0">项目管理</a></li>
  <li><a href="/web_kf/Contract_show?flag=0">合同管理</a></li>
  <li><a href="/web_kf/Finance_show?flag=0">财务管理</a></li>
  <li class="active"><a href="/web_kf/Asset_show?flag=0">资产管理</a></li>
  <li><a href="/web_kf/Document_show">档案管理</a></li>
  <li><a href="/web_kf/Budget_show">预算管理</a></li>
  <li><a href="/web_kf/Base_info">基础信息维护</a></li>
  <li><a href="/web_kf/Project_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>

  
</ul>
<br />

<div class="panel panel-primary">
<div class="panel-heading center">资产列表</div>
<div class="panel-body">
<form method="post" action="/web_kf/Delete_all" id="fr_show" >
<input type="hidden" name="del_i" value=4 />
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	<td></td>
	<td>编号</td>
	<td>资产名称</td>
	<td>规格</td>
	<td>型号</td>
	<td>数量</td>
	<td>单价</td>
	<td>金额</td>
	<td>购置日期</td>
	<td>经手人</td>
	<td>使用部门</td>
	<td>备注</td>
	</tr>
	<c:forEach items="${requestScope.as_list }" var="as">
	<tr>
<%-- 	<td>${as.asset_id}</td> --%>
	<td><input type="radio" name="as_id" value="${as.asset_id}" ></td>
	<td>${as.asset_number}</td>
	<td>${as.asset_name}</td>
	<td>${as.asset_spect}</td>
	<td>${as.asset_type}</td>
	<td>${as.asset_price}</td>
	<td>${as.asset_count}</td>
	<td>${as.money}</td>
	<td>${as.buy_date}</td>
	<td>${as.buyer}</td>
	<td>${as.department_name}</td>
	<td>${as.remark}</td>
	</tr>
	</c:forEach>
</table>
</form>
</div>
</div>
<div class="center-block">
<form method="post" action="/web_kf/Query_any" id="fr_excel" >
<button type="button" class="btn btn-danger" id="bt_del" >删除</button>
<input type="hidden" name="flag_1_0" value=0 />
<input type="hidden" name="flag_i" value=4 />
<input type="hidden" name="flag_excel" value=1 />
<button type="button" class="btn btn-info" id="bt_excel">生成Excel</button>
</form>
</div>

<br />

	<div class="panel panel-primary">
	<div class="panel-heading center">资产信息查询</div>
	<div class="panel-body">
	<form method="post" action="/web_kf/Query_any" id="as_cx1">
	<input type="hidden" name="flag_i" value=4 />
	<input type="hidden" name="flag_1_0" value=0 />
	<table class="table table-hover table-responsive table-striped">
		<tr>
		<td class="col-lg-2">资产名称</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="资产名称" name="as_name_cx"></td>
		<td class="col-lg-2">规格</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="规格" name="as_spect_cx"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">型号</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="型号" name="as_type_cx"></td>
		<td class="col-lg-2">数量 </td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="数量 " name="as_count_cx"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">单价</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="单价" name="as_price_cx"></td>
		<td class="col-lg-2">金额 </td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="金额 " name="as_money_cx"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">购置日期</td>
		<td class="col-lg-4">
			<div class="form-group">
	           <div class='input-group date' id='datetimepicker1' class='col-lg-4' name="pj_date_cx">
	               <input type='text' class="form-control" />
	               <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
	               </span>
	           </div>
	       </div>
	       <script type="text/javascript">
	           $(function () {
	               $('#datetimepicker1').datetimepicker();
	           });
	       </script>
			<!-- <div class="input-group">
		      <input type="text" class="form-control" name="as_date_cx" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button">选择日期</button>
		      </span>
		    </div>/input-group -->
		</td>
		<td class="col-lg-2">经手人 </td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="经手人 " name="as_buyer_cx"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">使用部门</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="使用部门" name="as_dept_cx"></td>
		<td class="col-lg-2">编号 </td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="编号 " name="as_num_cx"></td>
		</tr>
		
		<tr>
		<td>备注</td>
		<td colspan=3 class="col-lg-10"><input type="text" class="form-control" placeholder="备注"></td>
		</tr>
		
	</table>
	<div class="center-block">
	<button type="button" class="btn btn-primary">添加</button>
	<button type="button" class="btn btn-success" id="bt_cx1">查询</button>
	<button type="button" class="btn btn-info">修改</button>
	</div>
	</div>
	</div>


</body>
</html>