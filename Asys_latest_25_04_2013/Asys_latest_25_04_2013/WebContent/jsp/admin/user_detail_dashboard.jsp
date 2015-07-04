<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbBean.EmpUserIdGeneratorBean"%>
<%@page import="assys.com.dbDAO.EmpUserIdGenerator"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>User Detail</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">

						<% 

						
						EmpUserIdGeneratorBean empUserIdGeneratorBean = new EmpUserIdGeneratorBean();
						EmpUserIdGenerator empUserIdGenerator = new EmpUserIdGenerator();
						
						
						empUserIdGeneratorBean.setEmpCategory("Employee");
						empUserIdGeneratorBean.setEmpIdUsed(true);
						  ResultSet rs = empUserIdGenerator.select(empUserIdGeneratorBean);
							int emp = rs.getRow();
							int i=0;
							while(rs.next())
							{
								i++;
							}	
							System.out.print(emp);
						  
						
						
						%>


						<s:div cssClass="message info">
                                <h5>Employee</h5>
                                <p>
                                    <b>number of Employee : <%= i %></b>
                                </p>
                            </s:div>	
                            
                            
                            <%
                            
                            empUserIdGeneratorBean.setEmpCategory("Project Manager");
    						empUserIdGeneratorBean.setEmpIdUsed(true);
    						  ResultSet rs1 = empUserIdGenerator.select(empUserIdGeneratorBean);
    							
    							int j=0;
    							while(rs1.next())
    							{
    								j++;
    							}	
    							
    						          
					                            
                            
                            
                            
                            %>			
							
						<s:div cssClass="message info">
                                <h5>Manager</h5>
                                <p>
                                     <b>number of Manager : <%= j %></b>
                                </p>
                            </s:div>				
							
					


                    
					<script>
					function load_content()
            			{
                			$("#div_content").css('background-color', 'black');
                		}	
					</script>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

