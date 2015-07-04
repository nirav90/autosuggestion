<%@page import="assys.com.joinQuery.AssignWorkAjax" %>
<script>
//alert("in ajax assign jsp hi");
</script>

<%
String sd = (String)session.getAttribute("employee_ID");
AssignWorkAjax assignWorkAjax=new AssignWorkAjax();
assignWorkAjax.selectMail(sd);
%>