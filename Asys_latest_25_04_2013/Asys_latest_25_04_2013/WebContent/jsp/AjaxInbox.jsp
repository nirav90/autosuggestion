
<%@page import="assys.com.joinQuery.InboxFetchAjax" %>
<%@page import="assys.com.dbBean.GmailAuthenticationBean" %>
<%@page import="assys.com.dbBean.InboxMasterBean" %>
<%@page import="assys.com.dbDAO.GmailAuthentication" %>
<%@page import="assys.com.dbDAO.InboxMaster" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="assys.com.gmail.gmail" %>

<%
String sd = (String)session.getAttribute("employee_ID");
/* InboxFetchAjax inboxFetchAjax=new InboxFetchAjax();
inboxFetchAjax.InboxFetch(sd); */
GmailAuthentication gmailAuthentication = new GmailAuthentication();
GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();

InboxMasterBean inboxMasterBean = new InboxMasterBean();
InboxMaster inboxMaster = new InboxMaster();
gmailAuthenticationBean.setEmpUserId(sd);
ResultSet rs3 = gmailAuthentication.select(gmailAuthenticationBean);


try {
	while(rs3.next())
	 {
		 gmailAuthenticationBean.setGmailEmailId(rs3.getString(3));
		 gmailAuthenticationBean.setGmailPassword(rs3.getString(4));
		 
		 System.out.println(rs3.getString(3)+rs3.getString(4));
	 }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
 
 gmail gmail = new gmail();
 gmail.setAccountDetails(gmailAuthenticationBean.getGmailEmailId(), gmailAuthenticationBean.getGmailPassword());

 System.out.println(gmailAuthenticationBean.getGmailEmailId());
 
 inboxMasterBean.setEmpUserId(sd);
 
 
 /*check read unread mail and than call approprite method*/
 

 //session.setAttribute("employee_ID", sd);
 ResultSet rs4 =inboxMaster.select(inboxMasterBean);
 
 try {
	if(rs4.next())
	 {
		// gmail.unreadAllGmail(sd);
	 }	
	 else
	 {
		// gmail.readAllGmail();
		 
	 }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	 
	 







%>
