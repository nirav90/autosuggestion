package assys.com.dbAction.manager;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.ProjectDetailBean;
import assys.com.dbDAO.ProjectDetail;

public class AddProject {

	ProjectDetailBean projectDetailBean=new ProjectDetailBean();
	ProjectDetail projectDetail=new ProjectDetail();
	
	public String execute(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		Random rnd=new Random();
		int projId=rnd.nextInt(Integer.MAX_VALUE)+1;
		String projectId="prj"+projId;
		projectDetailBean.setProjectId(projectId);
		projectDetailBean.setProjectManagerEmpUserId(sd);
		projectDetail.insert(projectDetailBean);
		return "SUCCESS";
	}

	/**
	 * @return the projectDetailBean
	 */
	public ProjectDetailBean getProjectDetailBean() {
		return projectDetailBean;
	}

	/**
	 * @param projectDetailBean the projectDetailBean to set
	 */
	public void setProjectDetailBean(ProjectDetailBean projectDetailBean) {
		this.projectDetailBean = projectDetailBean;
	}

	
}
