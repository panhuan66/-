<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="/web_kf/js/bootstrap.js"></script>
<script src="/web_kf/js/jquery.min.js"></script> 
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
		$("#ctt_cx1").attr("action","/web_kf/Query_any").submit();
	});
 	$("#bt_cx2").click(function(){
		alert("ss");
		$("#fr_cx2").attr("action","/web_kf/UploadHandleServlet").submit();
	});
	$("#bt_excel").click(function(){
		//alert("ss");
		$("#fr_excel").attr("action","/web_kf/Query_any").submit();
	});
});
</script>
<title>项目管理</title>
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
  <li class="active"><a href="/web_kf/Contract_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>
</ul>
<ol class="breadcrumb">
  <li class="col-lg-2"><a href="/web_kf/Project_show?flag=1">项目</a></li>
  <li class="col-lg-2" class="active"><a href="/web_kf/Contract_show?flag=1">合同</a></li>
  <li class="col-lg-2"><a href="/web_kf/Finance_show?flag=1">财务</a></li>
  <li class="col-lg-2" ><a href="/web_kf/Asset_show?flag=1">资产</a></li>
  <li class="col-lg-4"><a href="/web_kf/Group_show?flag=1">组合呈现</a></li>
</ol>
<br />

<div class="panel panel-primary">
<div class="panel-heading center">合同列表</div>
<div class="panel-body">
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	<td>序号</td>
	<td>编号</td>
	<td>合同名称</td>
	<td>甲方</td>
	<td>乙方</td>
	<td>丙方</td>
	<td>签订日期</td>
	<td>合同价款</td>
	<td>所属项目</td>
	<td>备注</td>
	</tr>
	<c:forEach items="${requestScope.ctt_list }" var="ctt">
	<tr>
	<td>${ctt.contract_id}</td>
	<td>${ctt.contract_number}</td>
	<td>${ctt.contract_name}</td>
	<td>${ctt.a_name}</td>
	<td>${ctt.b_name}</td>
	<td>${ctt.c_name}</td>
	<td>${ctt.sign_date}</td>
	<td>${ctt.contract_price}</td>
	<td>${ctt.contract_content}</td>
	<td>${ctt.remark}</td>
	<td>${ctt.architecture_id}</td>
	<td>${ctt.project_id}</td>
	</tr>
	</c:forEach>
</table>
</div>
</div>
<br />

<!-- 合同信息维护  -->
	<div class="panel panel-primary">
	<div class="panel-heading center">合同查询</div>
	<div class="panel-body">
	<form method="post" action="/web_kf/Query_any" id="ctt_cx1">
	<input type="hidden" name="flag_i" value=2 />
	<input type="hidden" name="flag_1_0" value=1 />
	<table class="table table-hover table-responsive table-striped">
		<tr>
		<td class="col-lg-2">信息类别</td>
		<td class="col-lg-10" colspan=3 >合同		<input type="radio" name="ctt2">专项		<input type="radio" name="ctt2"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">合同名称</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="合同名称" name="ctt_name_cx"></td>
		<td class="col-lg-2">合同价款</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="合同价款" name="ctt_price_cx"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">合同甲方</td>
		<td class="col-lg-4">
		<div class="col-lg-10">
		        <select id="basic" class="selectpicker show-tick form-control" data-live-search="true" name="ctt_aname_cx">
		          <option selected value="">请选择</option>
		          <option value="张三">张三</option>
		          <option value="李四">李四</option>
		          <option value="王五">王五</option>
		          <option  class="get-class" disabled>其他。。</option>
		        </select>
		 </div>
		<!-- <div class="btn-group">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			    请选择 <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			  	<input type="hidden" name="ctt_aname_cx" />
			    <li><a href="#">请选择</a></li>
			    <li><a href="#">张三</a></li>
			    <li><a href="#">李四</a></li>
			    <li><a href="#">王五</a></li>
			    <li class="divider"></li>
			    <li><a href="#">其他。。</a></li>
			  </ul>
		</div> -->
		</td>
		<td class="col-lg-2">合同编号</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="合同编号" name="ctt_num_cx"></td>
		</tr>
		
		<tr>
		<td class="col-lg-2">合同乙方</td>
		<td class="col-lg-4">
		<div class="col-lg-10">
		        <select id="basic" class="selectpicker show-tick form-control" data-live-search="true" name="ctt_bname_cx">
		          <option selected value="">请选择</option>
		          <option value="张三">张三</option>
		          <option value="李四">李四</option>
		          <option value="王五">王五</option>
		          <option  class="get-class" disabled>其他。。</option>
		        </select>
		 </div>
		<!-- <div class="btn-group">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			    请选择 <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			  <input type="hidden" name="ctt_bname_cx" />
			    <li><a href="#">请选择</a></li>
			    <li><a href="#">张三</a></li>
			    <li><a href="#">李四</a></li>
			    <li><a href="#">王五</a></li>
			    <li class="divider"></li>
			    <li><a href="#">其他。。</a></li>
			  </ul>
		</div> -->
		</td>
		<td class="col-lg-2">签订日期</td>
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
		      <input type="text" class="form-control" name="ctt_date_cx">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button">签订日期</button>
		      </span>
		    </div>/input-group -->
		</td>
		</tr>
		
		<tr>
		<td class="col-lg-2">合同丙方</td>
		<td class="col-lg-4">
		<div class="col-lg-10">
		        <select id="basic" class="selectpicker show-tick form-control" data-live-search="true" name="ctt_cname_cx">
		          <option selected value="">请选择</option>
		          <option value="张三">张三</option>
		          <option value="李四">李四</option>
		          <option value="王五">王五</option>
		          <option  class="get-class" disabled>其他。。</option>
		        </select>
		 </div>
		<!-- <div class="btn-group">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			    请选择 <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			  <input type="hidden" name="ctt_cname_cx" />
			    <li><a href="#">请选择</a></li>
			    <li><a href="#">张三</a></li>
			    <li><a href="#">李四</a></li>
			    <li><a href="#">王五</a></li>
			    <li class="divider"></li>
			    <li><a href="#">其他。。</a></li>
			  </ul>
		</div> -->
		</td>
		<td class="col-lg-2">合同内容</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="合同内容" name="ctt_cont_cx">
	
		</td>
		</tr>
		
	</table>

	</form >
<div class="center-block">
<form method="post" action="/web_kf/Query_any" id="fr_excel" >
<button type="button" class="btn btn-success" id="bt_cx1">查询</button>
<input type="hidden" name="flag_1_0" value=1 />
<input type="hidden" name="flag_i" value=2 />
<input type="hidden" name="flag_excel" value=1 />
<button type="button" class="btn btn-info" id="bt_excel">生成Excel</button>
</form>
	</div>
	</div>
	</div>
	
<br />
<div class="panel panel-primary">
<div class="panel-heading center">合同报表发布（Excel格式）</div>
<div class="panel-body">
<form  enctype="multipart/form-data" action="/web_kf/UploadHandleServlet" enctype="multipart/form-data" method="post" id="fr_cx2">
<input type="hidden" name="flag_qubie" value=2 />
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	  <div class="form-group">
       <input id="file-5" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="#" data-preview-file-icon="">
      </div>
	 <!-- <div class="input-group">
	      <input type="file" class="form-control" name="file1">
	    </div>/input-group
	 </td> -->
	</tr>
	
</table>
</form>
</div>
</div>
<button   class="btn btn-warning"  id="bt_cx2" class="glyphicon glyphicon-upload" class="btn btn-default kv-fileinput-upload fileinput-upload-button">刷新</button>


</body>
</html>