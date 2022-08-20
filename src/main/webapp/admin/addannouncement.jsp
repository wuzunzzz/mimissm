<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
	</head>
    <script type="text/javascript">
        function fileChange(){
			$.ajaxFileUpload({
				url:"${pageContext.request.contextPath}/prod/ajaxImg.action",
				secureuri: false,
				fileElementId: 'pimage',
				dataType:"json",
				success:function (obj) {
					//清空div
					$("#imgDiv").empty();
					//创建一个图片的标签
					var imgObj = $("<img>");
					alert(obj.imgurl);
					imgObj.attr("src","/image_big/"+obj.imgurl);
					imgObj.attr("width","100px");
					imgObj.attr("height","100px");
					//将图片追加到imgDiv
					$("#imgDiv").append(imgObj);
				}
			});

        }
    </script>
	<body>
	<!--取出上一个页面上带来的page的值-->

		<div id="addAll">
			<div id="nav">
				<p>通知公告>新增公告</p>
			</div>

			<div id="table">
				<form  id="myform" action="${pageContext.request.contextPath}/announce/add.action">
					<table>
						<tr>
							<td class="one">公告</td>
							<td><input type="text" name="text" class="two"></td>
						</tr>

						<tr>
							<td>
								<input type="submit" value="提交" class="btn btn-success">
							</td>
							<td>
								<input type="reset" value="取消" class="btn btn-default" onclick="myclose(${param.page})">
								<script type="text/javascript">
									function myclose(ispage) {
										window.location="${pageContext.request.contextPath}/announce/split.action";
									}
								</script>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</body>

</html>