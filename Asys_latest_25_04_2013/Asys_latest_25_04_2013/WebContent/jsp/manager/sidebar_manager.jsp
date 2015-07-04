<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="grid_2">

            <div class="box sidemenu">
                <div class="block" id="section-menu">
                    <ul class="section menu">
                        <li><a class="menuitem">Mail</a>
                            <ul class="submenu">
                            	<li><a href="manager_compose_jsp">Compose</a> </li>
                                <li><a href="manager_mail_click_jsp">Inbox(<%=session.getAttribute("unread") %>)</a> </li>
                                <li><a  href="manager_sent_mail_jsp">Sent</a> </li>
                                <li><a href="manager_draft_mail_jsp">Draft</a> </li>
                                <li><a href="manager_ntfc_mail_jsp">Notification Mail</a></li>
                                <!-- <li><a>Trash</a> </li> -->
                                <!-- <li><a>Work </a> </li> -->
                            </ul>
                            </li>     
                    </ul>
                </div>
            </div>
        </div>
