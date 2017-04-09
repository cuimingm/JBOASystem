package net.jboasystem.web.action;

import java.util.Map;

import net.jboasystem.entity.Employee;
import net.jboasystem.service.EmployeeService;
import net.jboasystem.service.impl.EmployeeServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private EmployeeService empService=new EmployeeServiceImpl();
	private Employee emp;
	private String message=null;
	
	/**
	 * ��¼
	 * @return
	 */
	public String login(){
		boolean flag=empService.isLogin(emp);
	
		if(!flag){
			message="���Ż�������������µ�¼��";
			return INPUT;
		}
		
		//��¼�ɹ�������¼��Ϣ�����лỰ��
		Map session=ActionContext.getContext().getSession();
		session.put("employee", emp);
		return SUCCESS;
	}
	/**
	 * ��ȫ�˳�
	 * @return
	 */
	public String exit(){
		//ɾ��session���ڱ�ǵ�¼��key
		Map session=ActionContext.getContext().getSession();
		session.remove("employee");
		
		return INPUT;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
