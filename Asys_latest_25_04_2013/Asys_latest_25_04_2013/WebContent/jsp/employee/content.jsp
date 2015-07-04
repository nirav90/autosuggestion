
<%@page import="javax.mail.BodyPart"%>
<%@page import="javax.mail.Multipart"%>

<%@page import="javax.activation.DataHandler"%>
<%@page import="java.io.InputStream"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@page import="assys.com.gmail.gmail"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.InboxMaster"%>
<%@page import="javax.mail.Flags"%>
<%@page import="javax.mail.Message"%>
<%@page import="java.util.*"%>
<%@page import="assys.com.dbBean.InboxMasterBean"%>
<%@ page language="java" import="demo.MessageInfo" %>
<%-- <%@ page errorPage="errorpage.jsp" %> --%>

<%@ taglib uri="/WEB-INF/lib/taglib.jar"
    prefix="javamail" %>
<jsp:useBean id="mailuser" scope="session" class="assys.com.gmail.MailUserBean" />

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Content </h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    
                    	<%		            		String sd = (String)session.getAttribute("employee_ID");
		            		
		                    GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
		                   	gmailAuthenticationBean.setEmpUserId(sd);
		                   	
		                   	
		                   	GmailAuthentication gmailAuthentication = new GmailAuthentication();
		                   	
		                   	ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		            
		                	gmail gmail = new gmail();
		     			 
		     				while(rs.next())
		     				{
		     					
		     					String userName = rs.getString(3);
		     					String password = rs.getString(4);
		     					
		     					gmail.setAccountDetails(userName, password);
		     					
		     				}	
		     			
		     			
		     			String s = request.getParameter("mailNo");
						 int mailNo = Integer.parseInt(s);
		                
						Message m = gmail.readContent(mailNo);
						
					  List<String>ss = gmail.dumpPart(m);
					  
					  
					  for(int i =1;i<ss.size();i++){

					       String obj=ss.get(i);
					       
					       if(obj==null)
					       {
					    	   
					    	   System.out.print("in if");
					       }
					       else
					       {	   
					       %>
							<%=obj %>
							<% 
					       }
					    }
						   
						     
		              %>
						
					
						
						
                    
                    
                </s:div>
                </s:div>
                </s:div>
                </s:div>
                