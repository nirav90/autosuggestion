<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
<title><tiles:getAsString name="pageTitle"/></title>
<!-- <style type="text/css">@import url(../css/main.css);@import url(../css/grid.css);@import url(../css/layout.css)</style> -->
</head>
<body>
    <tiles:insertAttribute name="header"/> 
    <tiles:insertAttribute name="sidebar"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>
</body>
</html>
