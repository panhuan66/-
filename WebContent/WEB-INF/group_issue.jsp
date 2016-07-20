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
<script src="js/collapse.js"></script>
		 <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<!-- <script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script src="js/moment-with-locales.js"></script>
		<script src="js/bootstrap-datetimepicker.js"></script> -->
		
<script src="js/bootstrap-select.js"></script> 
<link rel="stylesheet" href="css/bootstrap-select.css">

    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#show").click(function(){
		//alert(123);
		$("#fr_cx3").attr("action","/web_kf/Group_show?flag=1").submit();
		/* alert($('input:checkbox[name="ip_pro_num"]:checked').val()); */
		//$("input[name='fc_oneortwo_cx']").val($('input:checkbox[name="abj"]:checked').val());
		//$("input[name='fc_pj_cx']").val($('input:radio[name="pj"]:checked').val());
	});
	$("#bt_cx2").click(function(){
		//alert("ss");
		$("#fr_cx2").attr("action","/web_kf/UploadHandleServlet").submit();
	});
	

	
	$('#collapse_One').onclick(function(){
		$('#collapseOne').collapse('show');
		$('#collapseTwo').collapse('hide');
		$('#collapseThree').collapse('hide');
	});
	
	$('#collapse_Two').onclick(function(){
		 $('#collapseOne').collapse('hide');
		 $('#collapseTwo').collapse('show');
		 $('#collapseThree').collapse('hide');
	});
	
	$('#collapse_Three').onclick(function(){
		 $('#collapseOne').collapse('hide');
		 $('#collapseTwo').collapse('hide');
		 $('#collapseThree').collapse('show');
	});
	

	
})

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
  <li  class="active"><a href="/web_kf/Group_show?flag=1">数据发布</a></li>
  <li><a href="/web_kf/Project_time">工期配置</a></li>
  <li class="active"><a href="/web_kf/Login_out">退出</a></li>
</ul>
<ol class="breadcrumb">
  <li class="col-lg-2" ><a href="/web_kf/Project_show?flag=1">项目</a></li>
  <li class="col-lg-2"><a href="/web_kf/Contract_show?flag=1">合同</a></li>
  <li class="col-lg-2"><a href="/web_kf/Finance_show?flag=1">财务</a></li>
  <li class="col-lg-2" ><a href="/web_kf/Asset_show?flag=1">资产</a></li>
  <li class="col-lg-4" class="active" ><a href="/web_kf/Group_show?flag=1">组合呈现</a></li>
</ol>
<br />


<div class="row">
<!-- <div class="col-xs-9 col-xs-offset-3" class="clearfix visible-xs" class="pull-right"> -->
<div class="col-xs-9 "  class="pull-right">
<table class="table table-hover table-responsive table-striped" >	
	<c:forEach items="${requestScope.group_all_list }" var="all_list">
	<tr>
		<c:forEach items="${all_list }" var="g_all">
		<td>${g_all}</td>
		</c:forEach>
		
	</tr>
	</c:forEach>
</table>
</div>
<form method="post" action="/web_kf/Group_show?flag=1" id="fr_cx3">
<input type="hidden" name="flag_i" value=5 />
<div class="col-xs-3" class="clearfix visible-xs" >

<div class="panel-group" id="accordion">
   <div class="panel panel-default">
      <div class="panel-heading">
         
            <a data-toggle="collapse" data-parent="#accordion" 
               href="#collapseOne" >
               <h4 class="panel-title" >
               	项目信息
               	</h4>
            </a>
        
      </div>
      <div id="collapseOne" class="panel-collapse collapse in">
         <div class="panel-body">
           <ul style="list-style:none">
		      <li><label><input type="checkbox" name="group" value="项目编号">项目编号</label></li>
		      <li><label><input type="checkbox" name="group" value="项目名称">项目名称</label></li>
		      <li><label><input type="checkbox" name="group" value="项目承担部门">项目承担部门</label></li>
		      <li><label><input type="checkbox" name="group" value="责任人">责任人</label></li>
		      <li><label><input type="checkbox" name="group" value="项目预算">项目预算</label></li>
		      <li><label><input type="checkbox" name="group" value="开始日期">开始日期</label></li>
	    	</ul>
         </div>
      </div>
   </div>
   <div class="panel panel-success">
      <div class="panel-heading">
         
            <a data-toggle="collapse" data-parent="#accordion" 
               href="#collapseTwo">
               <h4 class="panel-title">
               	合同信息
               </h4>
            </a>
       
      </div>
      <div id="collapseTwo" class="panel-collapse collapse">
         <div class="panel-body">
           <ul style="list-style:none">
           	  <li><label><input type="checkbox" name="group" value="合同编号">合同编号</label></li>
           	  <li><label><input type="checkbox" name="group" value="合同名称">合同名称</label></li>
           	  <li><label><input type="checkbox" name="group" value="甲方">甲方</label></li>
           	  <li><label><input type="checkbox" name="group" value="乙方">乙方</label></li>
           	  <li><label><input type="checkbox" name="group" value="丙方">丙方  </label></li>
           	  <li><label><input type="checkbox" name="group" value="签订日期">签订日期</label></li>
           	  <li><label><input type="checkbox" name="group" value="合同价款">合同价款</label></li>
           	  <li><label><input type="checkbox" name="group" value="所属项目">所属项目</label></li>
    		</ul>
         </div>
      </div>
   </div>
   <div class="panel panel-info">
      <div class="panel-heading">
        
            <a data-toggle="collapse" data-parent="#accordion" 
               href="#collapseThree">
                <h4 class="panel-title">
               	财务信息
               	</h4>
            </a>
         
      </div>
      <div id="collapseThree" class="panel-collapse collapse">
         <div class="panel-body">
            <ul style="list-style:none">
              <li><label><input type="checkbox" name="group" value="日期" >日期</label></li>
           	  <li><label><input type="checkbox"  checked name="group" value="凭证号">凭证号</label></li>
           	  <li><label><input type="checkbox" name="group" value="摘要">摘要</label></li>
           	  <li><label><input type="checkbox" name="group" value="借方">借方</label></li>
           	  <li><label><input type="checkbox" name="group" value="贷方">贷方  </label></li>
           	  <li><label><input type="checkbox" name="group" value="金额">金额</label></li>
           	  <li><label><input type="checkbox" name="group" value="所属项目">所属项目</label></li>
           	  <li><label><input type="checkbox" name="group" value="所属合同">所属合同</label></li>
           	  <li><label><input type="checkbox" name="group" value="资金支付方式">资金支付方式  </label></li>
           	  <li><label><input type="checkbox" name="group" value="采购形式">采购形式</label></li>
           	  <li><label><input type="checkbox" name="group" value="项目分类">项目分类</label></li>
           	  
		    </ul>
         </div>
      </div>
   </div>
  
</div>
<button id="show"  class="btn btn-warning"  >综合生成列表</button>
</div>


</form>
</div>
<div class="clearfix">
</div>

<br />
<div class="panel panel-primary">
<div class="panel-heading center">项目报表发布（Excel格式）</div>
<div class="panel-body">
<form  enctype="multipart/form-data" action="/web_kf/UploadHandleServlet" enctype="multipart/form-data" method="post" id="fr_cx2">
<input type="hidden" name="flag_qubie" value=5 />
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