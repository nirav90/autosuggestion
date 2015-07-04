<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>AtWork</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]-->
    <link href="${pageContext.request.contextPath}/css/table/demo_page.css" rel="stylesheet" type="text/css" />
    
    <link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/css/fullcalendar.css' />
	<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/css/fullcalendar.print.css' media='print' />
	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tcal.css" />
    
    <!-- BEGIN: load jquery -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.mouse.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.sortable.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/table/jquery.dataTables.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/1.8.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
    <!-- END: load jquery -->
    <!-- chart jquery  -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tcal.js"></script> 
    <script src="${pageContext.request.contextPath}/js/highchart_module.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/highchart.js" type="text/javascript"></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
    
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.datepicker.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery.ui.progressbar.min.js" type="text/javascript"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/table/table.js"></script>
    <script src="${pageContext.request.contextPath}/js/setup.js" type="text/javascript"></script>
    
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/editor.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            setupLeftMenu();

            $('.datatable').dataTable();
			setSidebarHeight();


        });
    </script>
    
    <script language="javascript" type="text/javascript">
    //alert("hi in fun");
            var url = "http://localhost:8082/Asys_latest/jsp/AjaxInbox.action";
          
           reload_content();
          
          function reload_content()
          {
				//alert("in reload content hi");
				load_contents();
				//alert("after reload content");
				setTimeout("reload_content()",120000);
				
          }
           
          
            function load_contents()
            {
      			//alert("in load content");
      			//reload_content();
                $.ajax({
                	
                       url:url,
                       data:{},
                       datatype:"HTML",
                       type:"post",
                       success:function(data)
                            {
                               $("#div_content").append(data);

                            }
                        });
    
            }

        </script>
            
</head>
<body>
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft">
                    <img src="${pageContext.request.contextPath}/img/logo_final.jpeg" alt="Logo" /></div>
                <div class="floatright">
                    <div class="floatleft">
                        <img src="${pageContext.request.contextPath}/img/img-profile.jpg" alt="Profile Pic" /></div>
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                            <li>Hello <%=session.getAttribute("userName") %></li>
                            <!-- <li><a href="#">Config</a></li> -->
                            <li><a href="Logout_jsp">Logout</a></li>
                        </ul>
                        <br />
                        <span class="small grey">Last Login: 3 hours ago</span>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <ul class="nav main">
                <li class="ic-dashboard"><a href="employee_dashboard_jsp"><span>Dashboard</span></a> </li>
                <li class="ic-form-style"><a href="employee_compose_jsp"><span>Mail</span></a>
                    <!-- <ul>
                        <li><a href="form-controls.html">Contacts</a> </li>
                        <li><a href="buttons.html">Calander</a> </li>
                        <li><a href="form-controls.html">Work</a> </li>
                        <li><a href="table.html">Reports</a> </li>
                    </ul> -->
                </li>
                <li class="ic-contact"><s:a href="employee_contacts_jsp.action"><span>Contacts</span></s:a></li>
                <li class="ic-work"><s:a href="employee_given_work_to_submit_jsp"><span>Work</span></s:a></li>
				<li class="ic-dashboard1"><a href="employee_profile_jsp"><span>Profile</span></a></li>
                <li class="ic-typography"><a href="employee_calender_jsp"><span>Calendar</span></a></li>
                <li class="ic-leave"><a href="employee_leave_jsp"><span>Leave</span></a></li>
                <li class="ic-grid-tables"><a href="employee_change_password_jsp"><span>Settings</span></a>
                	<!-- <ul>
                        <li><a href="add_user_jsp.action"></a> </li>
                        <li><a href="buttons.html">Change Password</a> </li>
                        <li><a href="form-controls.html">Mail Settings</a> </li>
                        <li><a href="table.html">SMS Settings</a> </li>
                    </ul> -->
                </li>
                <li class="ic-charts"><a href="employee_report_jsp"><span>Reports</span></a>
               		<!--  <ul>
                        <li><a href="image-gallery.html">Pretty Photo</a> </li>
                        <li><a href="gallery-with-filter.html">Gallery with Filter</a> </li>
                    </ul> -->
                </li>
                <%-- <li class="ic-notifications"><s:a href="add_user.action"><span></span></s:a></li> --%>

            </ul>
</div>
        <div class="clear">
        </div>
