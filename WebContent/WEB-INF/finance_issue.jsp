<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"  
    src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">  
</script> 
<script src="/web_kf/js/bootstrap.js"></script>
<script src="/web_kf/js/jquery.min.js"></script> 
<!-- <script src="js/modal.js"></script> -->
<script src="js/popover.js"></script>
<!-- <script src="js/dropdown.js"></script> -->
<script src="js/transition.js"></script>
<script src="js/collapse.js"></script>

       <!--  <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css" /> -->
       <!--  <link href="css/font-awesome.min.css" rel="stylesheet"> -->
        <!-- <link href="css/prettify-1.0.css" rel="stylesheet"> -->
       <!--  <link href="css/base.css" rel="stylesheet"> -->
        <link href="css/bootstrap-datetimepicker.css" rel="stylesheet">
     <!--    <link rel="stylesheet" type="text/css" href="css/default.css"> -->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
        <![endif]-->
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
	$("#bt_cx2").click(function(){
		//alert("ss");
		$("#fr_cx2").attr("action","/web_kf/UploadHandleServlet").submit();
	});
	$("#bt_cx1").click(function(){
		//alert("ss");
		$("#fc_cx1").attr("action","/web_kf/Query_any").submit();
	});
	$("#bt_abj").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_pj_cx']").val($('input:radio[name="pj"]:checked').val());
	});
	$("#bt_pj").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_pj_cx']").val($('input:radio[name="pj"]:checked').val());
	});
	$("#bt_ctt").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_ctt_cx']").val($('input:radio[name="ctt"]:checked').val());
	});
	$("#bt_pay").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_pay_cx']").val($('input:radio[name="pay"]:checked').val());
	});
	$("#bt_pt").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_type_cx']").val($('input:radio[name="type"]:checked').val());
	});
	$("#bt_pf").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_form_cx']").val($('input:radio[name="form"]:checked').val());
	});
	$("#bt_pc").click(function(){
		//alert($('input:radio[name="abj"]:checked').val());
		//$("input[name='fc_oneortwo_cx']").val($('input:radio[name="abj"]:checked').val());
		$("input[name='fc_cate_cx']").val($('input:radio[name="pc"]:checked').val());
	});
	$("#bt_excel").click(function(){
		//alert("ss");
		//$("#fc_cx1").attr("action","/web_kf/Query_any").submit();
		$("#fr_excel").attr("action","/web_kf/Finance_show?flag=0").submit();
		
	});
});
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
  <li  class="active"><a href="/web_kf/Finance_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>  
</ul>
<ol class="breadcrumb">
  <li class="col-lg-2" ><a href="/web_kf/Project_show?flag=1">项目</a></li>
  <li class="col-lg-2"><a href="/web_kf/Contract_show?flag=1">合同</a></li>
  <li class="col-lg-2"  class="active"><a href="/web_kf/Finance_show?flag=1">财务</a></li>
  <li class="col-lg-2" ><a href="/web_kf/Asset_show?flag=1">资产</a></li>
  <li class="col-lg-4"><a href="/web_kf/Group_show?flag=1">组合呈现</a></li>
</ol>
<br/>
<div class="panel panel-primary">
<div class="panel-heading center">财务信息列表</div>
<div class="panel-body">
<table class="table table-hover table-responsive table-striped">
	<tr class="success">
	<td>日期</td>
	<td>凭证号</td>
	<td>摘要</td>
	<td>借方</td>
	<td>贷方</td>
	<td>金额</td>
	<td>所属项目</td>
	<td>所属合同</td>
	<td>资金支付方式</td>
	<td>采购形式</td>
	<td>项目分类</td>
	</tr>
	<c:forEach items="${requestScope.fc_list }" var="fc">
	<tr>
		<c:forEach items="${fc }" var="fc_all">
		<td>${fc_all}</td>
		</c:forEach>
	</tr>
<%-- 	<tr>
	<td>${fc.finance_id}</td>
	<td>${fc.finance_number}</td>
	<td>${fc.finance_date}</td>
	<td>${fc.finance_abstract}</td>
	<td>${fc.money}</td>
	<td>${fc.borrow_subject_id}</td>
	<td>${fc.loan_subject_id}</td>
	<td>${fc.contract_id}</td>
	<td>${fc.payment_id}</td>
	<td>${fc.procurement_type_id}</td>
	<td>${fc.procurement_from_id}</td>
	<td>${fc.procurement_category_id}</td>
	</tr> --%>
	</c:forEach>
</table>
</div>
</div>
<br />

	<div class="panel panel-primary">
	<div class="panel-heading center">财务信息查询（此处有误，应为查询，不能写维护）</div>
	<div class="panel-body">
	<form method="post" action="/web_kf/Query_any" id="fc_cx1">
	<input type="hidden" name="flag_i" value=3 />
	<input type="hidden" name="flag_1_0" value=1 />
	<table class="table table-hover table-responsive table-striped">
		<tr>
		<td class="col-lg-2">日期</td>
		
		<td class="col-lg-4">
           <div class="form-group">
               <div class='input-group date' id='datetimepicker1' class='col-lg-4' name="fc_date_cx">
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
		
		</td>
		
		<!-- <td class="col-lg-4">
			<div class="input-group">
		      <input type="text" class="form-control">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" name="fc_date_cx">选择日期</button>
		      </span>
		    </div>/input-group
	    </td> -->
	    <td class="col-lg-2">凭证号</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="凭证号" name="fc_num_cx"></td>
		</tr>
		
		
		<tr>
		<td class="col-lg-2">摘要</td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="摘要" name="fc_abst_cx"></td>
		<td class="col-lg-2">金额 </td>
		<td class="col-lg-4"><input type="text" class="form-control" placeholder="金额 " name="fc_money_cx"></td>
		</tr>
		
		
		<tr>
		<td class="col-lg-2">会计科目</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_oneortwo_cx" id="ip_abj" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_abj">会计科目</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		<td class="col-lg-2" colspan=2>
		<input type="radio" name="fc_is">借方
		<input type="radio" name="fc_is">贷方
		<input type="radio" name="fc_is">借方或贷方
		<input type="radio" name="fc_is">借方且贷方
		</td>
		<td class="col-lg-4">			
			
		</td>
		</tr>
		
		<tr>
		<td class="col-lg-2">所属项目</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_pj_cx"  value="">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_pj">所属项目</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		<td class="col-lg-2">所属合同</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_ctt_cx" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_ctt">所属合同</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		</tr>
		
		<tr>
		<td class="col-lg-2">资金支付方式</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_pay_cx" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_pay">资金支付方式</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		<td class="col-lg-2">政府采购方式</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_type_cx" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_pt">政府采购方式</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		</tr>
		
		<tr>
		<td class="col-lg-2">政府采购组织形式</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_form_cx" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_pf">政府采购组织形式</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		<td class="col-lg-2">政府采购项目分类</td>
		<td class="col-lg-4">			
			<div class="input-group">
		      <input type="text" class="form-control" name="fc_cate_cx" >
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal_pc">政府采购项目分类</button>
		      </span>
		    </div><!-- /input-group -->
		</td>
		</tr>
	
	</table>
<!-- 	<div class="center-block">
	<button type="button" class="btn btn-success"  id="bt_cx1">查询</button>
	<button type="button" class="btn btn-warning"><a href="/web_kf//DownLoadServlet">形成拨款通知单</a></button>
	<button type="button" class="btn btn-info">生成Excel</button>
	</div> -->
	</form>
	<form method="post" action="/web_kf/Finance_show?flag=0" id="fr_excel" >
<button type="button" class="btn btn-danger">删除</button>
<input type="hidden" name="flag_1_0" value=0 />
<input type="hidden" name="flag_i" value=3 />
<input type="hidden" name="flag_excel" value=1 />
<button type="button" class="btn btn-warning"><a href="/web_kf//DownLoadServlet">形成拨款通知单</a></button>
<button type="button" class="btn btn-info" id="bt_excel">生成Excel</button>
</form>
	</div>
	</div>
<br />
<div class="panel panel-primary">
<div class="panel-heading center">项目报表发布（Excel格式）</div>
<div class="panel-body">
<form  enctype="multipart/form-data" action="/web_kf/UploadHandleServlet" enctype="multipart/form-data" method="post" id="fr_cx2">
<input type="hidden" name="flag_qubie" value=3 />
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





<!-- 弹框内容 -->
<!-- 
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal_pc">
  Launch demo modal
</button> -->
<!--  7，政府采购项目分类-->
<!-- Modal -->
<div class="modal fade" id="myModal_pc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_pc" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_pc">采购项目</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>编码</td>
				<td>名称</td>
				</tr>
				<c:forEach items="${requestScope.pc_list }" var="pc">
				<tr>
				<td><input type="radio" name="pc" value="${pc.procurement_category_name}" id="ip_pc"></td>
				<td>${pc.procurement_category_number}</td>
				<td>${pc.procurement_category_name}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_pc">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<!--  6，政府采购组织形式-->
<!-- Modal -->
<div class="modal fade" id="myModal_pf" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_pf" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_pf">采购方式</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>编码</td>
				<td>名称</td>
				</tr>
				<c:forEach items="${requestScope.pf_list }" var="pf">
				<tr>
				<td><input type="radio" name="form" value="${pf.procurement_form_name}" id="ip_pf"></td>
				<td>${pf.procurement_form_number}</td>
				<td>${pf.procurement_form_name}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_pf">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!--  5，政府采购方式-->
<!-- Modal -->
<div class="modal fade" id="myModal_pt" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_pt" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_pt">采购方式</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>编码</td>
				<td>名称</td>
				</tr>
				<c:forEach items="${requestScope.pt_list }" var="pt">
				<tr>
				<td><input type="radio" name="type" value="${pt.procurement_type_name}" id="ip_pt"></td>
				<td>${pt.procurement_type_number}</td>
				<td>${pt.procurement_type_name}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_pt">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<!--  4，资金支付方式-->
<!-- Modal -->
<div class="modal fade" id="myModal_pay" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_pay" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_pay">资金支付方式</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>编码</td>
				<td>名称</td>
				</tr>
				<c:forEach items="${requestScope.pay_list }" var="pay">
				<tr>
				<td><input type="radio" name="pay" value="${pay.payment_name}" id="ip_pay"></td>
				<td>${pay.payment_number}</td>
				<td>${pay.payment_name}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_pay">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->






<!--  3，所属合同-->
<!-- Modal -->
<div class="modal fade" id="myModal_ctt" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_ctt" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_ctt">合同列表</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>合同名称</td>
				<td>备注</td>
				</tr>
				<c:forEach items="${requestScope.ctt_list }" var="ctt">
				<tr>
				<td><input type="radio" name="ctt" value="${ctt.contract_name}" id="ip_ctt"></td>
				<td>${ctt.contract_name}</td>
				<td>${ctt.remark}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_ctt">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




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



<!--  1，会计科目-->
<!-- Modal -->
<div class="modal fade" id="myModal_abj" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_abj" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel_abj">会计科目</h4>
      </div>
      <div class="modal-body">
		       <table class="table table-hover table-responsive table-striped">
				<tr class="success">
				<td></td>
				<td>编码</td>
				<td>名称</td>
				</tr>
				<c:forEach items="${requestScope.abj_list }" var="abj">
				<tr>
				<td><input type="radio" name="abj" value="${abj.accountant_subject_name}" id="ip_abj1"></td>
				<td>${abj. accountant_subject_number}</td>
				<td>${abj.accountant_subject_name}</td>
				</tr>
				</c:forEach>
				</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" id="bt_abj">选择</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




</body>
</html>