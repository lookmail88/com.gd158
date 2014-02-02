<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Date dd=new Date();
String d1=dd.toString();

%>


<html>
<head>
<title>Develop Example</title>

<link
	href="<%=request.getContextPath()%>/css/cupertino/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/ui.jqgrid.css"
		rel="stylesheet" type="text/css">

		<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"
			type="text/javascript"></script>
		<script
			src="<%=request.getContextPath()%>/js/jquery-ui-1.9.2.custom.js"
			type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.jqGrid.min.js"
			type="text/javascript"></script>
		<script language="javascript">
	
	//DBRead-GenericDAO'
	$(function(){
		$("#Ajax1").load('<%=basePath %>test/Ajax-String.action?'+Math.random());
		$("#DBRead-jdbctest").load('<%=basePath %>test/DBRead-jdbctest.action?'+Math.random());
		$("#DBRead-Hibernate").load('<%=basePath %>test/DBReadHibernate.action?'+Math.random());
		$("#DBRead-Spring-Hibernate").load('<%=basePath %>test/DBReadSpringHibernate.action?'+Math.random());
		$("#DBRead-GenericDAO").load('<%=basePath %>test/DBReadGenericDAO.action?'+Math.random());

		
		
		$("#dialog").hide();//secure
		$("#secure").hide();
		$("#Login").click(function(){
			$("#dialog").dialog({
				resizable: false,
			//	height:140,
				width:400,
				modal: true,
				title: "Spring Security Login",
				buttons: {
				"Submit": function() {
				$("#securitysubmit").submit();
				},
				Cancel: function() {
				$( this ).dialog( "close" );
				}
				}
				});
		});
		
		$("#showjqgrid").click(function(){
			alert("ok");
			//loadJqGrid();
			$("#jqgriddialog").dialog({
				resizable: false,
			//	height:140,
				width:400,
				modal: true,
				title: "JqGrid Demo",
				buttons: {
				Cancel: function() {
				$( this ).dialog( "close" );
				}
				}
				});
		});
		
	});
	
	function loadJqGrid(){
		$( "#jqgriddialog" ).closest(".ui-jqgrid-bdiv").css({ 'overflow-x' : 'hidden' });
		$("#jqgrid").empty();
		jQuery("#jsonTable").jqGrid({
			url:'<%=basePath%>/trouble/getTroubleList?tt='+Math.random(),
			editurl:'<%=basePath%>/trouble/getTroubleList?tt='+Math.random(),
			datatype : "json",
			colNames : [ 'ID','KeyWords', 'Stauts','Time' ],
			colModel : [ {
				name : 'id',
				index : 'id',
				width : 30
			}, {
				name : 'KEYWORDS',
				index : 'KEYWORDS',
				width : 90,
				editable : true
			}, {
	 			name : 'status',
				index : 'status', 
				width : 30
			}, {
				name : 'Stauts',
				index : 'Stauts',
				width : 150,
				editable : true
			}, {
				name : 'reportdate',
				index : 'reportdate',
				width : 120,
				formatter : "date",
				formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}
			},{
				name : 'picid',
				index : 'picid',
				hidden:true,
				width : -1
			},{
				name : 'picpath',
				index : 'picpath',
				hidden:true,
				width : -1
			}],
			jsonReader: {    //jsonReader来跟服务器端返回的数据做对应  
				total: "total",  	// json中代表页码总数的数据
				page: "page",		// json中代表当前页码的数据  
				records:"records",  // json中代表数据行总数的数据
				root: "rows",    	// json中代表实际模型数据的入口 
				repeatitems : false      
			},  
						//pager: '#toolbar',
			viewrecords: true,
			// loadonce:true,
			multiselect: true,
			autoScroll: true,
		//	forceFit :true,

			width:750,
			height: "auto",
		//	rowNum:3,
			autowidth: false, 
			sortorder: "desc",
			gridComplete:function(){
				$("#jsonTable").click(function(){
				var checksign=jQuery("#jsonTable").jqGrid('getGridParam','selarrrow');
				
				if(checksign.length>1){
					jQuery("#jsonTable").jqGrid('setSelection',checksign[0]);
				}
				if(checksign.length>=1){
								$("#op").show();
							}else{
								$("#op").hide();
							}
				    	});
			}
			});//.trigger("reloadGrid");//init jqgrid end
	}
	
	
	</script>
</head>
<body>
	<h1>Develop Example</h1>

	<dl>
		<dt>Base Info</dt>
		<dd>
			Time=<%=d1 %></dd>
		<dd>
			Servlet Path=<%=path %></dd>
		<dd>
			BasePath=<%=basePath %></dd>
	</dl>

	<dl>
		<dt>Ajax-String</dt>
		<dd id="Ajax1">123</dd>
	</dl>

	<dl>
		<dt>DBRead-jdbc</dt>
		<dd id="DBRead-jdbctest">123</dd>
	</dl>
	<dl>
		<dt>DBRead-Hibernate</dt>
		<dd id="DBRead-Hibernate">123</dd>
	</dl>
	<dl>
		<dt>DBRead-Spring-Hibernate</dt>
		<dd id="DBRead-Spring-Hibernate">123</dd>
	</dl>
	<dl>
		<dt>DBRead-Spring-Hibernate-GenericDAO</dt>
		<dd id="DBRead-GenericDAO">123</dd>
	</dl>

	<!--  
 		<dl>
			<dt>DB-JqGrid </dt>
			<dd id="showjqgrid"><a href="javascript:avoid(0)">Open JqGrid</a></dd>
		</dl>
		
		
		<dl>
			<dt>Spring Security</dt>
			<dd><a id="Login" href="javascript:avoid(0)">Open Login Dialog</a></dd>
		</dl>

-->

	<div id="secure"></div>

	<div id="jqgriddialog">
		<table id="jsonTable"></table>
		<div id="nav"></div>
	</div>
</body>
</html>