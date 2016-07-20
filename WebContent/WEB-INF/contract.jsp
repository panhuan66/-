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
		$("#ctt_cx1").attr("action","/web_kf/Query_any").submit();
	});
	$("#bt_pj").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_pj_cx']").val($('input:radio[name="pj"]:checked').val());
	});
	$("#bt_ah").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_ah_cx']").val($('input:radio[name="ah"]:checked').val());
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
<title>Insert title here</title>
</head>
<body style="width:80%; margin:0 auto;">
<h3 class="page-header alert alert-info center">审计署机关辅助办公系统(机关领导)<small>领导决策区</small></h3>
<ul class="nav nav-pills">
  <li><a href="/web_kf/Project_show?flag=0">项目管理</a></li>
  <li class="active"><a href="/web_kf/Contract_show?flag=0">合同管理</a></li>
  <li><a href="/web_kf/Finance_show?flag=0">财务管理</a></li>
  <li><a href="/web_kf/Asset_show?flag=0">资产管理</a></li>
  <li><a href="/web_kf/Document_show">档案管理</a></li>
  <li><a href="/web_kf/Budget_show">预算管理</a></li>
  <li><a href="/web_kf/Base_info">基础信息维护</a></li>
  <li><a href="/web_kf/Project_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>
  
</ul>
<br />

<div class="panel panel-primary">
<div class="panel-heading center">合同列表</div>
<div class="panel-body">
<form method="post" action="/web_kf/Delete_all" id="fr_show" >
<input type="hidden" name="del_i" value=2 />
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	<td></td>
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
	<td><input type="radio" name="ctt_id" value="${ctt.contract_id}"></td>
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
	<%-- <td>${ctt.architecture_id}</td>
	<td>${ctt.project_id}</td> --%>
	</tr>
	</c:forEach>
</table>
</form>
</div>
</div>
<div class="center-block">
<form method="post" action="/web_kf/Query_any" id="fr_excel" >
<button type="button" class="btn btn-primary">维护资料</button>
<button type="button" class="btn btn-danger" id="bt_del" >删除</button>
<input type="hidden" name="flag_1_0" value=0 />
<input type="hidden" name="flag_i" value=2 />
<input type="hidden" name="flag_excel" value=1 />
<button type="button" class="btn btn-info" id="bt_excel">生成Excel</button>
</form>
</div>

<br />

<!-- 合同信息维护  -->
	<div class="panel panel-primary">
	<div class="panel-heading center">合同信息维护</div>
	<div class="panel-body">
	<form method="post" action="/web_kf/Query_any" id="ctt_cx1">
	<input type="hidden" name="flag_i" value=2 />
	<input type="hidden" name="flag_1_0" value=0 />
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
		
		<tr>
		<td class="col-lg-2">所属项目</td>
		<td class="col-lg-4">
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_pj_cx" placeholder="所属项目" value="">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_pj">所属项目</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		<td class="col-lg-2">建设内容</td>
		<td class="col-lg-4">
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_ah_cx" placeholder="建设内容" value="">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_ah">建设内容</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
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
	</form >
	</div>
	</div>
	
	
	
	

<!--  2，所属项目-->
<!-- Modal -->
<div class="modal fade" id="myModal_pj" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_pj" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_pj">项目列表</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>项目名称</td>
				<td>备注</td>
				</tr>
				<c:forEach items="${requestScope.pj_list }" var="pj">
				<tr>
				<td><input type="radio" name="pj" value="${pj.project_name}" id="pj_abj2"></td>
				<td>${pj.project_name}</td>
				<td>${pj.remark}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_pj">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!--  1，建设-->
<!-- Modal -->
<div class="modal fade" id="myModal_ah" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_ah" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_ah">建设内容</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>编码</td>
				<td>名称</td>
				</tr>
				<c:forEach items="${requestScope.ah_list }" var="ah">
				<tr>
				<td><input type="radio" name="ah" value="${ah.architecture_name}" id="ip_ah1"></td>
				<td>${ah.architecture_number}</td>
				<td>${ah.architecture_name}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_ah">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

	
</body>
</html>