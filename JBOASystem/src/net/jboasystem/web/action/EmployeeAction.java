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
	 * 登录
	 * @return
	 */
	public String login(){
		boolean flag=empService.isLogin(emp);
	
		if(!flag){
			message="工号或密码错误，请重新登录！";
			return INPUT;
		}
		
		//登录成功，将登录信息存入中会话中
		Map session=ActionContext.getContext().getSession();
		session.put("employee", emp);
		return SUCCESS;
	}
	/**
	 * 安全退出
	 * @return
	 */
	public String exit(){
		//删除session用于标记登录的key
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
