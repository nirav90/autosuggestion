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
                <h2>
                    Clock</h2>
                <div class="block">
                    <div id="chart1">
                    </div>
                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
        
        <div class="clear">
        </div>
    </div>
<script type="text/javascript">
$(function () {
	
	/**
	 * Get the current time
	 */
	function getNow () {
	    var now = new Date();
	        
	    return {
	        hours: now.getHours() + now.getMinutes() / 60,
	        minutes: now.getMinutes() * 12 / 60 + now.getSeconds() * 12 / 3600,
	        seconds: now.getSeconds() * 12 / 60
	    };
	};
	
	/**
	 * Pad numbers
	 */
	function pad(number, length) {
		// Create an array of the remaining length +1 and join it with 0's
		return new Array((length || 2) + 1 - String(number).length).join(0) + number;
	}
	
	var now = getNow();
	
	// Create the chart
	var chart = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'chart1',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false,
	        height: 200
	    },
	    
	    credits: {
	        enabled: false
	    },
	    
	    title: {
	    	text: ' Clock'
	    },
	    
	    pane: {
	    	background: [{
	    		// default background
	    	}, {
	    		// reflex for supported browsers
	    		backgroundColor: Highcharts.svg ? {
		    		radialGradient: {
		    			cx: 0.5,
		    			cy: -0.4,
		    			r: 1.9
		    		},
		    		stops: [
		    			[0.5, 'rgba(255, 255, 255, 0.2)'],
		    			[0.5, 'rgba(200, 200, 200, 0.2)']
		    		]
		    	} : null
	    	}]
	    },
	    
	    yAxis: {
	        labels: {
	            distance: -20
	        },
	        min: 0,
	        max: 12,
	        lineWidth: 0,
	        showFirstLabel: false,
	        
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 5,
	        minorTickPosition: 'inside',
	        minorGridLineWidth: 0,
	        minorTickColor: '#666',
	
	        tickInterval: 1,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 10,
	        tickColor: '#666',
	        title: {
	            text: 'Powered by<br/>Highcharts',
	            style: {
	                color: '#BBB',
	                fontWeight: 'normal',
	                fontSize: '8px',
	                lineHeight: '10px'                
	            },
	            y: 10
	        }       
	    },
	    
	    tooltip: {
	    	formatter: function () {
	    		return chart.tooltipText;
	    	}
	    },
	
	    series: [{
	        data: [{
	            id: 'hour',
	            y: now.hours,
	            dial: {
	                radius: '60%',
	                baseWidth: 4,
	                baseLength: '95%',
	                rearLength: 0
	            }
	        }, {
	            id: 'minute',
	            y: now.minutes,
	            dial: {
	                baseLength: '95%',
	                rearLength: 0
	            }
	        }, {
	            id: 'second',
	            y: now.seconds,
	            dial: {
	                radius: '100%',
	                baseWidth: 1,
	                rearLength: '20%'
	            }
	        }],
	        animation: false,
	        dataLabels: {
	            enabled: false
	        }
	    }]
	}, 
	                                 
	// Move
	function (chart) {
	    setInterval(function () {
	        var hour = chart.get('hour'),
	            minute = chart.get('minute'),
	            second = chart.get('second'),
	            now = getNow(),
	            // run animation unless we're wrapping around from 59 to 0
	            animation = now.seconds == 0 ? 
	                false : 
	                {
	                    easing: 'easeOutElastic'
	                };
	                
	        // Cache the tooltip text
	        chart.tooltipText = 
				pad(Math.floor(now.hours), 2) + ':' + 
	    		pad(Math.floor(now.minutes * 5), 2) + ':' + 
	    		pad(now.seconds * 5, 2);
	        
	        hour.update(now.hours, true, animation);
	        minute.update(now.minutes, true, animation);
	        second.update(now.seconds, true, animation);
	        
	    }, 1000);
	
	});
});

// Extend jQuery with some easing (copied from jQuery UI)
$.extend($.easing, {
	easeOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
	}
});
		</script>
		<script src="http://code.highcharts.com/highcharts-more.js"></script>