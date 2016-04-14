<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--/*请填写静态包含的文件路径 */-->

<title>Spark-下午3:53:21</title>
<style type="text/css">
/*页面CSS样式  */


</style>
<!--/*请填写引用的样式文件路径 */-->
<link rel="stylesheet" type="text/css" href="<%=path%>/xxx/common.css">
<!--/*请填写引用的脚本文件路径 */-->
<script type="text/javascript" src="<%=path%>/plugins/easyui/jquery.min.js"></script>
</head>
<body>
<form action="<%=path%>/doLogin">
<label>用户名：</label><input name="name"><br>
<label>密码：</label><input name="pwd"><br>
<button type="submit">登录</button>
</form>
<script type="text/javascript">
/*初始化脚本  */
$(function(){
	
	
	
});
</script>
</body>
</html>