<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String addUrl = basePath+"/EmpServlet/add";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=addUrl%>" method="post"> 
		雇员编号：<input type="text" name="empno" id="empno" value="7369"><br> 
		雇员姓名：<input type="text" name="ename" id="ename" value="SMITH"><br> 
		基本工资：<input type="text" name="sal" id="sal" value="800.0"><br> 
		雇佣日期：<input type="text" name="hiredate" id="hiredate" value="1981-10-10"><br> 
		<input type="submit" value="增加"> 
		</form>
</body>
</html>