<%--
    Document   : fileupload
    Created on : May 26, 2012, 3:57:46 PM
    Author     : LENOVO
--%>

   <%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ page import="java.util.List" %>
   <%@ page import="java.util.Iterator" %>
   <%@ page import="java.io.File" %>
   <%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
   <%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
   <%@ page import="org.apache.commons.fileupload.*"%>
   <%@page  import="org.apache.commons.io.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
     out.print(new java.util.Date().getTime());


        boolean result = false;
        boolean multipart = ServletFileUpload.isMultipartContent(request);
     if(!multipart)
         {}
        else
            {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
       items = upload.parseRequest(request);
      try {
               items = upload.parseRequest(request);
           }
       catch (FileUploadException e) {
               e.printStackTrace();
           }
            Iterator itr = items.iterator();
            while (itr.hasNext())
                {
                FileItem item = (FileItem) itr.next();
                    if(item.isFormField())
                        {}
                else
                    {
                        try {
                       String itemName = item.getName();
            String p =  config.getServletContext().getRealPath("/")
            +"images\\"+itemName;
            out.print("<img src='images/"+itemName.toString()+"'/>");
            out.print(p);
                        File savedFile = new File(p);
               item.write(savedFile);
                        }catch(Exception e)
                        {e.printStackTrace(); }

                }
                }


        }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="" method="post" enctype="multipart/form-data">
            <input type="file" id="photo1" name="photo1">
            <input type="submit" id="submit" name="submit" value="upload"/>
        </form>
    </body>
</html>
