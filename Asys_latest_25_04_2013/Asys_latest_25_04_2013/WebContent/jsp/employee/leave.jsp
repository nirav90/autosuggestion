
		
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.joinQuery.SelectQuery"%>
<%@page import="assys.com.dbDAO.LeaveCounter"%>
<%@page import="assys.com.dbBean.LeaveCounterBean"%>

	
<!-- <script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script> -->

<!-- <div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div> -->




 <% 
 
 				String jan="0",feb="0",mar="0",apr="0",may="0",jun="0",july="0",aug="0",sep="0",oct="0",nov="0",dec="0";
 				int total=0;	
 				String sd = (String)session.getAttribute("employee_ID");
 
 				LeaveCounterBean  leaveCounterBean = new LeaveCounterBean();
 				LeaveCounter leaveCounter = new LeaveCounter();
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(1);
 				leaveCounterBean.setLeaveYear(2013);
 				
 				ResultSet rs = leaveCounter.select(leaveCounterBean);
 				
 				while(rs.next())
 				{
 				jan = rs.getString("leave_count");
 				System.out.println(jan);
 				total+=Integer.parseInt(jan);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(2);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs1 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs1.next())
 				{
 				feb = rs1.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(3);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs3 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs3.next())
 				{
 				mar = rs3.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(mar);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(4);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs4 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs4.next())
 				{
 				apr = rs4.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(apr);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(5);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs5 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs5.next())
 				{
 				may = rs5.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(may);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(6);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs6 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs6.next())
 				{
 				jun = rs6.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(jun);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(7);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs7 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs7.next())
 				{
 				july = rs7.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(july);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(8);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs8 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs8.next())
 				{
 				aug = rs8.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(aug);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(9);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs9 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs9.next())
 				{
 				sep = rs9.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(sep);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(10);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs10 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs10.next())
 				{
 				oct = rs10.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(oct);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(11);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs11 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs11.next())
 				{
 				nov = rs11.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(nov);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(12);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs12 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs12.next())
 				{
 				dec = rs12.getString("leave_count");
 				System.out.println(feb);
 				total+=Integer.parseInt(dec);
 				}
 				
 				
 				
 				
 				
 %>
 
 
 

<div class="grid_10">
            <div class="box round first1">
                	 
                	 
                
                
                <h2>
                    Total Leave</h2>
                <div class="block1">
                    <div id="chart1">
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
        </div>
        

<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'chart1',
                zoomType: 'xy'
            },
            title: {
                text: 'Average Monthly Leave Report'
            },
            xAxis: [{
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    formatter: function() {
                        return this.value ;
                    },
                    style: {
                        color: '#89A54E'
                    }
                },
                title: {
                    text: 'Leave',
                    style: {
                    	<%
                    	
                    	
                    	 if(total<=12)
                    	 {	 
                    	%>
                    	
                        color: '#89A54E'
                        <%
                    	 }
                    	 else
                    	 { 
                        %>
                        color: '#FFFFF'
                        <%
                    	 }
                        %>
                    }
                }
            }, { // Secondary yAxis
                title: {
                    text: 'Leave',
                    style: {
                        color: '#4572A7'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value;
                    },
                    style: {
                        color: '#4572A7'
                    }
                },
                opposite: true
            }],
            tooltip: {
                formatter: function() {
                    return ''+
                        this.x +': '+ this.y +
                        (this.series.name == 'Leave' ? ' day' : '');
                }
            },
            legend: {
                layout: 'vertical',
                align: 'left',
                x: 120,
                verticalAlign: 'top',
                y: 100,
                floating: true,
                backgroundColor: '#FFFFFF'
            },
            series: [{
                name: 'Leave',
                color: '#4572A7',
                type: 'column',
                yAxis: 1,
                data: [<%=jan%>,<%=feb%>,<%=mar%>,<%=apr%>,<%=may%>,<%=jun%>,<%=july%>,<%=aug%>,<%=sep%>,<%=oct%>,<%=nov%>,<%=dec%>]
    
            }, /* {
                name: 'Leave',
                color: '#89A54E',
                type: 'spline',
                data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            } */]
        });
    });
    
});
		</script>


	