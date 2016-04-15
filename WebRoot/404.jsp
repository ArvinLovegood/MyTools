<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html >
<html>
<head>
<title>Spark-下午2:30:29</title>
<jsp:include page="view/head.jsp"></jsp:include>
</head>
<body>
<p style="font-size: 20px;text-align: center;color: red;">
404
</p>

<script type="text/javascript">
/*初始化脚本  */
$(function(){
	alert("找不到此页面,将跳转到首页");
	window.location.href="<%=path%>/f"
});
</script>
</body>
</html>