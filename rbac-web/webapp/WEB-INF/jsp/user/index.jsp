<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/main.css">
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" style="font-size: 32px;" href="#">众筹平台
						- 用户维护</a>
				</div>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li style="padding-top: 8px;">
						<div class="btn-group">
							<button type="button"
								class="btn btn-default btn-success dropdown-toggle"
								data-toggle="dropdown">
								<i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
										个人设置</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
										消息</a></li>
								<li class="divider"></li>
								<li><a href="index.html"><i
										class="glyphicon glyphicon-off"></i> 退出系统</a></li>
							</ul>
						</div>
					</li>
					<li style="margin-left: 10px; padding-top: 8px;">
						<button type="button" class="btn btn-default btn-danger">
							<span class="glyphicon glyphicon-question-sign"></span> 帮助
						</button>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<div class="tree">
					<ul style="padding-left: 0px;" class="list-group">
						<li class="list-group-item tree-closed"><a href="main.html"><i
								class="glyphicon glyphicon-dashboard"></i> 控制面板</a></li>
						<li class="list-group-item"><span><i
								class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span
								class="badge" style="float: right">3</span></span>
							<ul style="margin-top: 10px;">
								<li style="height: 30px;"><a href="index"
									style="color: red;"><i class="glyphicon glyphicon-user"></i>
										用户维护</a></li>
								<li style="height: 30px;"><a href="role.html"><i
										class="glyphicon glyphicon-king"></i> 角色维护</a></li>
								<li style="height: 30px;"><a href="permission.html"><i
										class="glyphicon glyphicon-lock"></i> 许可维护</a></li>
							</ul></li>
						<li class="list-group-item tree-closed"><span><i
								class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge"
								style="float: right">3</span></span>
							<ul style="margin-top: 10px; display: none;">
								<li style="height: 30px;"><a href="auth_cert.html"><i
										class="glyphicon glyphicon-check"></i> 实名认证审核</a></li>
								<li style="height: 30px;"><a href="auth_adv.html"><i
										class="glyphicon glyphicon-check"></i> 广告审核</a></li>
								<li style="height: 30px;"><a href="auth_project.html"><i
										class="glyphicon glyphicon-check"></i> 项目审核</a></li>
							</ul></li>
						<li class="list-group-item tree-closed"><span><i
								class="glyphicon glyphicon-th-large"></i> 业务管理 <span
								class="badge" style="float: right">7</span></span>
							<ul style="margin-top: 10px; display: none;">
								<li style="height: 30px;"><a href="cert.html"><i
										class="glyphicon glyphicon-picture"></i> 资质维护</a></li>
								<li style="height: 30px;"><a href="type.html"><i
										class="glyphicon glyphicon-equalizer"></i> 分类管理</a></li>
								<li style="height: 30px;"><a href="process.html"><i
										class="glyphicon glyphicon-random"></i> 流程管理</a></li>
								<li style="height: 30px;"><a href="advertisement.html"><i
										class="glyphicon glyphicon-hdd"></i> 广告管理</a></li>
								<li style="height: 30px;"><a href="message.html"><i
										class="glyphicon glyphicon-comment"></i> 消息模板</a></li>
								<li style="height: 30px;"><a href="project_type.html"><i
										class="glyphicon glyphicon-list"></i> 项目分类</a></li>
								<li style="height: 30px;"><a href="tag.html"><i
										class="glyphicon glyphicon-tags"></i> 项目标签</a></li>
							</ul></li>
						<li class="list-group-item tree-closed"><a href="param.html"><i
								class="glyphicon glyphicon-list-alt"></i> 参数管理</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input id="queryText" class="form-control has-success" type="text"
										placeholder="请输入查询条件">
								</div>
							</div>
							<button id="queryBtn" type="button" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<button type="button" class="btn btn-primary"
							style="float: right;" onclick="window.location.href='add.html'">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</button>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input type="checkbox"></th>
										<th>账号</th>
										<th>名称</th>
										<th>邮箱地址</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody id="userData">
									
								</tbody>
								<tfoot>
									<tr>
										<td colspan="6" align="center">
											<ul class="pagination">

											

											</ul>
										</td>
									</tr>

								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
	<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
	<script type="text/javascript">
	 //模糊查询标志，默认查询所有，不带条件
	  var likeflg = false;
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });
            
            //页面加载完成时，异步去请求 分页数据
            pageQuery(1); //默认加载第一页数据
            
            //给查询button添加查询事件
            $("#queryBtn").click(function(){
            	
            	var queryText = $("#queryText").val();
            	
            	if(queryText==''){
            		
            		likeflg = false;
            	}else{
            		
            		likeflg = true;
            	}
            	  pageQuery(1);
            	
            });
            
            $("tbody .btn-success").click(function(){
                window.location.href = "assignRole.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "edit.html";
            });
            
          //采用 AJax异步加载的方式，实现分页，先通过控制器跳转到列表页面， 此时页面没有数据
          //当页面加载完成，然后执行ajax 异步发送 分页请求，得到数据， 再渲染分页数据，提高性能与用户体验
          
            //Ajax 分页查询
          function pageQuery(pageNum){
        	  
        		  var loadingIndex =null;
        		  var jsonData = {"pageNum":pageNum,"pageSize":2};
        		  if(likeflg==true){
        			  
        			  jsonData.queryText = $("#queryText").val();
        		  }
        	  $.ajax({
        		  type:"post",
        		  url:"${APP_PATH}/user/queryPage",
        		  data:jsonData,
        		  beforeSend:function(){
        			  
        			  loadingIndex = layer.msg('处理中', {icon: 16});
        		  },
        		  success:function(result){
        			  layer.close(loadingIndex);
        			  
        			  if(result.success){
        				 
        				  //局部刷新分页数据
        				  var tableContext = "";
        				  var pageContext = "";
        				  
        				  //拿到服务器端的数据，  Page对象,服务器端AJAXResult 有 data与success，data存放的就是相关分页数据
        				  
        				  var userPage = result.data;
        				  
        				  //通过page对象获取 用户列表数据，Page对象中有一个datas属性，用来存放所有用户列表信息
        				  var users = userPage.datas;
        				  
        				
        				  
        				  
        				  //-------------------表格数据----------------
        				  
        				  //对users进行循环遍历，通过ajax each 循环 
        				  //  alt+shift +a 列编辑
        				  $.each(users,function(i,user){  //users表示对哪个集合进行循环， i为每次遍历的索引，user表示每次循环的临时对象
        					 //每次循环其实就是一行数据， 即为每次是一个user对象，对行进行拼接，最后把内容赋给tableContext变量
        					 
        					tableContext += '<tr>';
							tableContext += '	<td>'+(i+1)+'</td>'; //当前索引为0，所以要加1
							tableContext += '	<td><input type="checkbox"></td>';
							tableContext += '	<td>'+user.account+'</td>';
							tableContext += '	<td>'+user.username+'</td>';
							tableContext += '	<td>'+user.email+'</td>';
							tableContext += '	<td>';
							tableContext += '		<button type="button" class="btn btn-success btn-xs">';
							tableContext += '			<i class=" glyphicon glyphicon-check"></i>';
							tableContext += '		</button>';
							tableContext += '		<button type="button" class="btn btn-primary btn-xs">';
							tableContext += '			<i class=" glyphicon glyphicon-pencil"></i>';
							tableContext += '		</button>';
							tableContext += '		<button type="button" class="btn btn-danger btn-xs">';
							tableContext += '			<i class=" glyphicon glyphicon-remove"></i>';
							tableContext += '		</button>';
							tableContext += '	</td>';
							tableContext += '/tr>';
        					            
        					  
        				  });
        				  
        				  
        				  
        				  //-------------------页码数据----------------
        				  
        				  
        				  //对上一页的判断
        				  
        				  if(pageNum>1){
        					  pageContext += '<li><a href="#" onclick="pageQuery('+(pageNum-1)+')">上一页</a></li>';  
        					  
        				  }
        				  
        				  //对总页码进行循环
        				  
        				  for(var i=1;i<=userPage.totalPage;i++){
        					  
        					  if(pageNum==i){
        						  
        						  pageContext += '<li class="active"><a href="#">'+i+'</a></li>';
        						  
        					  }else{
        					  
        					  pageContext += '<li><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
        					  
        					  }
        				  }
        				  
        				  //对下一页进行判断， 总页码已经在page对象中返回了
        				  if(pageNum<userPage.totalPage){
        					  
        					  pageContext += '<li><a href="#" onclick="pageQuery('+(pageNum+1)+')">下一页</a></li>'; 
        				  }
        				  
        				  
        				  
        				  
        				  //最后把 拼接的变量tableContext,pageContext内容通过ajax渲染到 分页table组件中去
        				   
        				  $("#userData").html(tableContext);  //#为id选择器
        				  
        				  $(".pagination").html(pageContext); //.为class选择器
        				  
        				  
        			  }else{
        				  
        				  layer.msg("分页数据失败，请重试......", {time:2000, icon:5, shift:6}, function(){
  	                    	
  	                    });
        			  }
        			  
        		  }
        		  
        	  });
        	  
          }
          
        </script>
</body>
</html>
