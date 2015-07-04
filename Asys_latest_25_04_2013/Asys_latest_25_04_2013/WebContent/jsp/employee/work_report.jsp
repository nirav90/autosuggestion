




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
			
			if(rs.getString(2).equals("1"))
			{
				jan = rs.getString(1);
				System.out.println(jan);
			}
			if(rs.getString(2).equals("2"))
			{ 
				feb = rs.getString(1);
			}
			if(rs.getString(2).equals("3"))
			{
				mar = rs.getString(1);
			}
			if(rs.getString(2).equals("4"))
			{
				apr = rs.getString(1);
			}
			if(rs.getString(2).equals("5"))
			{
				may = rs.getString(1);
			}
			if(rs.getString(2).equals("6"))
			{
				jun = rs.getString(1);
			}
			if(rs.getString(2).equals("7"))
			{
				july = rs.getString(1);
			}
			if(rs.getString(2).equals("8"))
			{
				aug = rs.getString(1);
			}
			if(rs.getString(2).equals("9"))
			{
				sep = rs.getString(1);
			}
			if(rs.getString(2).equals("10"))
			{
				oct = rs.getString(1);
			}
			if(rs.getString(2).equals("11"))
			{
				nov = rs.getString(1);
			}
			if(rs.getString(2).equals("12"))
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
                text: 'Monthly Performance in Work'
            },
            subtitle: {
                text: ''
            },
            xAxis: [{
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    formatter: function() {
                        return this.value +'';
                    },
                    style: {
                        color: '#89A54E'
                    }
                },
                title: {
                    text: 'Performance',
                    style: {
                        color: '#89A54E'
                    }
                }
            }, { // Secondary yAxis
                /* title: {
                    text: 'Rainfall',
                    style: {
                        color: '#4572A7'
                    }
                },
                 */labels: {
                    formatter: function() {
                        return this.value +' mm';
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
                        (this.series.name == 'Rainfall' ? ' mm' : '');
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
            series: [
            {
                name: 'Performance',
                color: '#89A54E',
                type: 'spline',
                data: [<%=jan%>,<%=feb%>,<%=mar%>,<%=apr%>,<%=may%>,<%=jun%>,<%=july%>,<%=aug%>,<%=sep%>,<%=oct%>,<%=nov%>,<%=dec%>]
            }]
        });
    });
    
});
		</script>		
		
        
