<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<title></title>
		<script type="text/javascript">
			if ("${msg}" != "") {
				alert("${msg}");
			}
		</script>
	</head>

	<body>
		<div id="login">
			<div id="top">
				<img src="${pageContext.request.contextPath}/images/cloud.jpg" /><span>LOGIN</span>
			</div>
			<div id="bottom">

				<p align="center"  style="font-size:30px"><a href="${pageContext.request.contextPath}/admin/login2.jsp"><button>用户登入</button></a></p><br><br><br>

				<p align="center" style="font-size:30px"><a href="${pageContext.request.contextPath}/admin/login3.jsp"><button>管理员登入</button></a></p>
			</div>

		</div>
	</body>

</html>