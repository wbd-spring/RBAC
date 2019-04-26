<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="index.html" style="font-size: 32px;">万贝贷-互联网金融平台</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
    <h1 style="color:red"></h1>
		<form class="form-signin" id="loginForm" action="doLogin"
			method="post" role="form">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-user"></i> 用户登录
			</h2>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" name="account"  id="account"
					placeholder="请输入登录账号" autofocus> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="pwd" name="pwd"
					placeholder="请输入登录密码" style="margin-top: 10px;"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<select class="form-control">
					<option value="member">会员</option>
					<option value="user">管理</option>
				</select>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					记住我
				</label> <br> <label> 忘记密码 </label> <label style="float: right">
					<a href="reg.html">我要注册</a>
				</label>
			</div>
			<a class="btn btn-lg btn-success btn-block" onclick="dologin()">
				登录</a>
		</form>
	</div>
	<script src="jquery/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="layer/layer.js"></script>
	<script>
		function dologin() {
			var type = $(":selected").val();
			var account = $("#account").val();

			if (account == "") {
				  layer.msg("账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
		            	
		            });
				return;
			}

			var pwd = $("#pwd").val();
			
			if (pwd == "") {

				  layer.msg("密码不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
		            	
		            });
				return;
			}
			
			//提交表单
			
			//$("#loginForm").submit();

			//采用jquery Ajax 异步请求的方式提交表单，目的，体验更好，不用刷新页面，
			
			$.ajax({
				url:"doAjaxLogin", //请求的url
				type:"post", //请求的方式
				data:{  //传递到后台的参数，多个用json格式/{}, 如果是一个参数，则可以去掉{}
					"account":account,
					"pwd":pwd
				},
				
				beforeSend: function(){   //beforeSend函数  异步发送之前需要做的事情，我们可以load一个进度条，为了提高用户体验
					loadingIndex = layer.msg('处理中', {icon: 16});
				},
				
				success: function(result){  //异步请求，服务器返回的响应（服务器返回的内容在变量result中），不管返回什么内容， 都进入到success进行处理， 我们拿到服务器返回的内容做进一步处理
					
					//服务器返回内容，我们应该把进度条隐藏起来
					layer.close(loadingIndex);
				
				if(result.success){ //如果返回字段中success=true，跳转到主页
					
					
				}else{  //提示信息
					
					 layer.msg("用户登录账号或密码不正确，请重新输入", {time:2000, icon:5, shift:6}, function(){
	                    	
	                    });
				}
					
				}
				
			});
			
		}
	</script>
</body>
</html>