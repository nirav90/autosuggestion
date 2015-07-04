
		
<%@page import="assys.com.dbDAO.EmpDetail"%>
<%@page import="assys.com.dbBean.EmpDetailBean"%>
<%@page import="assys.com.dbDAO.LeaveMaster"%>
<%@page import="assys.com.dbBean.LeaveMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.LeaveCounter"%>
<%@page import="assys.com.dbBean.LeaveCounterBean"%>

	
<!-- <script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script> -->

<!-- <div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div> -->




 <% 
 
 				String  jan="0",feb="0",mar="0",apr="0",may="0",jun="0",july="0",aug="0",sep="0",oct="0",nov="0",dec="0";
 
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
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(2);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs1 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs1.next())
 				{
 				feb = rs1.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(3);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs3 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs3.next())
 				{
 				mar = rs3.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(4);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs4 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs4.next())
 				{
 				apr = rs4.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(5);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs5 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs5.next())
 				{
 				may = rs5.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(6);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs6 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs6.next())
 				{
 				jun = rs6.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(7);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs7 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs7.next())
 				{
 				july = rs7.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(8);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs8 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs8.next())
 				{
 				aug = rs8.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(9);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs9 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs9.next())
 				{
 				sep = rs9.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(10);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs10 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs10.next())
 				{
 				oct = rs10.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(11);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs11 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs11.next())
 				{
 				nov = rs11.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				leaveCounterBean.setEmpUserId(sd);
 				leaveCounterBean.setLeaveMonth(12);
 				leaveCounterBean.setLeaveYear(2013);
 				ResultSet rs12 = leaveCounter.select(leaveCounterBean);
 				
 				while(rs12.next())
 				{
 				dec = rs12.getString("leave_count");
 				System.out.println(feb);
 				}
 				
 				LeaveMasterBean leaveMasterBean = new LeaveMasterBean();
 				LeaveMaster leaveMaster = new LeaveMaster();
 				
 				leaveMasterBean.setEmpUserId(sd);
 				leaveMasterBean.setLeaveSubject("Emergency Leave");
 				ResultSet rsl =  leaveMaster.select(leaveMasterBean);
 				
 				int i= 0 ;
 				 while(rsl.next())
 				 {
 					 ++i;
 					 
 				 } 
 				
 				
 				
 				
 				leaveMasterBean.setEmpUserId(sd);
 				leaveMasterBean.setLeaveSubject("Multiday Leave");
 				ResultSet rsm =  leaveMaster.select(leaveMasterBean);
 				
 				int j= 0 ;
				 while(rsm.next())
				 {
					 ++j;
					 
				 } 
				
				 
				 EmpDetailBean  empDetailBean = new EmpDetailBean();
				 EmpDetail empDetail = new EmpDetail();
				 
				 empDetailBean.setEmpUserId(sd);
				 
				 ResultSet rss = empDetail.select(empDetailBean);
				 
				 while(rss.next())
				 {
					 String name = rss.getString("first_name");
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
           
            </div>
            <div class="grid_10">
            <div class="box round first1">
                <h2>
                    Pie chart For leave</h2>
                <div class="block">
                    <div id="chart2">
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
                        color: '#89A54E'
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
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'chart2',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: 'leave report  in  2013'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
            	percentageDecimals: 1
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['Multi Day Leave', <%=i%>],
                    ['Emergency Leave', <%=j%>]
                    
                ]
            }]
        });
    });
    
});
		</script>

	