<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Json Test</title>
  </head>
  <body>
  	<textarea id="jsonMsg" rows="10" cols="100" placeholder="请输入json格式信息"></textarea>
  	<br><button onclick="submitMsg()">发送</button>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript">
  	//请求格式为json，输出格式为json
  	function submitMsg(){
  		var message = $("#jsonMsg").val();
  		console.log(message);
  		$.ajax({
  			type:"post",
  			url:"${pageContext.request.contextPath }/json/JsonTest.action",
  			/* contentType:'application/json;charset=utf-8', */
  			/* contentType:'application/x-www-form-urlencoded', */
  			data:message,
  			success:function(data){
  				alert("username="+data["username"]+",password="+data["password"]);
  			}
  		});
  	}
  </script>
</html>
