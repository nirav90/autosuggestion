




<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.joinQuery.SelectQuery"%>
<%



		String  jan="0",feb="0",mar="0",apr="0",may="0",jun="0",july="0",aug="0",sep="0",oct="0",nov="0",dec="0";		

		SelectQuery selectQuery = new SelectQuery();

		String sd = (String)session.getAttribute("employee_ID");
		
		String select="SELECT COUNT(work_id) reject_count,MONTH(work_msg_sending_date_time),YEAR(work_msg_sending_date_time) FROM work_submit_master WHERE emp_user_id='"+sd+"' AND work_approve=0 AND isSeen=1 GROUP BY MONTH(work_msg_sending_date_time),YEAR(work_msg_sending_date_time);";
	
		ResultSet rs = selectQuery.executeSelect(select);
		
		while(rs.next())
		{
			
			if(rs.getString(2)== "1")
			{
				jan = rs.getString(1);
				System.out.println(jan);
			}
			if(rs.getString(2)=="2")
			{ 
				feb = rs.getString(1);
			}
			if(rs.getString(2)=="3")
			{
				mar = rs.getString(1);
			}
			if(rs.getString(2)=="4")
			{
				apr = rs.getString(1);
			}
			if(rs.getString(2)=="5")
			{
				may = rs.getString(1);
			}
			if(rs.getString(2)=="6")
			{
				jun = rs.getString(1);
			}
			if(rs.getString(2)=="7")
			{
				july = rs.getString(1);
			}
			if(rs.getString(2)=="8")
			{
				aug = rs.getString(1);
			}
			if(rs.getString(2)=="9")
			{
				sep = rs.getString(1);
			}
			if(rs.getString(2)=="10")
			{
				oct = rs.getString(1);
			}
			if(rs.getString(2)=="11")
			{
				nov = rs.getString(1);
			}
			if(rs.getString(2)=="12")
			{
				dec = rs.getString(1);
			}
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
        
