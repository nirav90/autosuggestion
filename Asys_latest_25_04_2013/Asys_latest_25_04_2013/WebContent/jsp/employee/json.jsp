<%@page import="org.json.JSONArray"%>
<%@page import="assys.com.dbAction.employee.Json"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.LeaveMaster"%>
<%@page import="assys.com.dbBean.LeaveMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%


		LeaveMasterBean leaveMasterBean = new LeaveMasterBean();

		LeaveMaster leaveMaster = new LeaveMaster();
		
		
		ResultSet rs = leaveMaster.selectAll();
		
		
	  JSONArray j =	Json.convert(rs);


	  out.print(j);


%>



</body>
</html>