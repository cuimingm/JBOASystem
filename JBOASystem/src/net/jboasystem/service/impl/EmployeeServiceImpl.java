package net.jboasystem.service.impl;

import net.jboasystem.dao.EmployeeDao;
import net.jboasystem.dao.impl.EmployeeDaoImpl;
import net.jboasystem.entity.Employee;
import net.jboasystem.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	//定义dao对象
	private EmployeeDao empDao=new EmployeeDaoImpl();
	
	/**
	 * 登录验证，验证成功后返回部分数据
	 */
	public boolean isLogin(Employee emp) {
		Employee empFromDB =empDao.getEmployeeByEmpNo(emp.getEmpNo());
		//工号存在、状态为在职、密码一致（未考虑加密问题）
		if(empFromDB!=null && empFromDB.getEmpStatus() && empFromDB.getLoginPassword().equals(emp.getLoginPassword())){
			emp.setEmpName(empFromDB.getEmpName());
			emp.setDepartment(empFromDB.getDepartment());
			emp.setJob(empFromDB.getJob());
			return true;
		}
		return false;
	}

}
