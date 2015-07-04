 <%@page import="assys.com.joinQuery.SelectQuery"%>
<%@page import="assys.com.dbDAO.WorkSubmitMaster"%>
<%@page import="assys.com.dbBean.WorkSubmitMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.SentMailMaster"%>
<%@page import="assys.com.dbBean.SentMailMasterBean"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="assys.com.dbDAO.AuthenticationDetail" session="true" %>
<%@page import="assys.com.dbBean.AuthenticationDetailBean" session="true"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


            
        <div class="grid_5">
            <div class="box round first1">
                <h2>Mail</h2>
                <div class="block">
                    <div class="message info">
                    <span><b>Total mail</b></span><h5>
                    <%=session.getAttribute("msgcount")%>
                    </h5>
					</div>
					<div class="message info">
                    <span><b>Unread mail</b></span><h5><%=session.getAttribute("unread") %></h5>
			</div>
			
			<%
			
			
			
			String sd = (String)session.getAttribute("employee_ID");
			SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
			SentMailMaster sentMailMaster = new SentMailMaster();
			
			int i=0;
			
			sentMailMasterBean.setEmpUserId(sd);
			
			ResultSet e = sentMailMaster.select(sentMailMasterBean);
			
			while(e.next())
			{
				i++;
			}	
					
			
			
			
			
			%>
			
			<div class="message info">
                    <span><b>Sent mail</b></span><h5><%= i %></h5>
			</div>
                </div>
            </div>
        </div>
        <div class="grid_5">
            <div class="box round first1">
                <h2> Work </h2>
                <div class="block">
                  
                  <% 
                  
                  
                  WorkSubmitMasterBean workSubmitMasterBean = new WorkSubmitMasterBean();
                  WorkSubmitMaster workSubmitMaster = new WorkSubmitMaster();
                  
                  
                  workSubmitMasterBean.setSeen(false);
                  workSubmitMasterBean.setEmpUserId(sd);
                  
                  ResultSet rs = workSubmitMaster.select(workSubmitMasterBean);
                  
                  int j= 0;
                  while(rs.next())
                  {
                	  j++;
                  }
                  
                  
                  workSubmitMasterBean.setWorkApprove(true);
                  workSubmitMasterBean.setEmpUserId(sd);
                  
                  ResultSet rs1 = workSubmitMaster.select(workSubmitMasterBean);
                  
                  int k= 0;
                  while(rs1.next())
                  {
                	  k++;
                  }
                  
                  
                  workSubmitMasterBean.setWorkApprove(false);
                  workSubmitMasterBean.setEmpUserId(sd);
                  
                  ResultSet rs2 = workSubmitMaster.select(workSubmitMasterBean);
                  
                  int l= 0;
                  while(rs2.next())
                  {
                	  l++;
                  }
                  
                  
                  %>
                  
                  
                  
                  <div class="message info">
                    <span><b>Pending Work</b></span><h5><%=j%></h5>
					</div>
					<div class="message success">
                    <span><b>Approved Work</b></span><h5><%=k%></h5>
			</div>
			<div class="message error">
                    <span><b>Disapproved Work</b></span><h5><%=l%></h5>
			</div>
                    
                </div>
            </div>
        </div>
        <div class="grid_10">
           
            <div class="box round">
                <h2>
                    Leave</h2>
                    <%
                    int free= 0;
                    int paid= 0;
                    String select = "select SUM(leave_count) from leave_counter where emp_user_id = '"+sd+"';";
                    
                   SelectQuery query = new SelectQuery();
                   ResultSet r = query.executeSelect(select);
                  
                   int q = 0;
                   while(r.next())
                   {
                	   q=Integer.parseInt(r.getString(1));
                	   System.out.print(q);
                   } 
                    
                    %>
                <div class="block">
                
                
                
                    <div class="stat-col">
                        <span>Total Leave</span>
                        <p class="darkblue">
                           <%= q %></p>
                    </div>
                    
                    
                    
                    <%
                                                if(q>12)
                                                {
                                                 free=12;
                                                 paid=(q-12);
                                                }
                                                else
                                                {
                                                	free=q;
                                                	paid=0;
                                                }	
                                                %>
                    <div class="stat-col">
                        <span>free Leave</span>
                        <p class="green">
                            <%=free %></p>
                    </div>
                    <div class="stat-col">
                        <span>Paid Leave</span>
                                                <p class="red">
                                                
                        
                            <%=paid %></p>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
        </div>
        
        <div class="clear">
        </div>
    
