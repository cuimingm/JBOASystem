package net.jboasystem.service.impl;

import net.jboasystem.dao.EmployeeDao;
import net.jboasystem.dao.impl.EmployeeDaoImpl;
import net.jboasystem.entity.Employee;
import net.jboasystem.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	//����dao����
	private EmployeeDao empDao=new EmployeeDaoImpl();
	
	/**
	 * ��¼��֤����֤�ɹ��󷵻ز�������
	 */
	public boolean isLogin(Employee emp) {
		Employee empFromDB =empDao.getEmployeeByEmpNo(emp.getEmpNo());
		//���Ŵ��ڡ�״̬Ϊ��ְ������һ�£�δ���Ǽ������⣩
		if(empFromDB!=null && empFromDB.getEmpStatus() && empFromDB.getLoginPassword().equals(emp.getLoginPassword())){
			emp.setEmpName(empFromDB.getEmpName());
			emp.setDepartment(empFromDB.getDepartment());
			emp.setJob(empFromDB.getJob());
			return true;
		}
		return false;
	}

}
