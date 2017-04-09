package net.jboasystem.dao.impl;

import java.util.List;

import net.jboasystem.dao.EmployeeDao;
import net.jboasystem.entity.Employee;
import net.jboasystem.util.HibernateBaseDao;

public class EmployeeDaoImpl extends HibernateBaseDao implements EmployeeDao {
	/**
	 * 根据主键查询
	 */
	public Employee getEmployeeByEmpNo(int employeeNo) {
		return (Employee)super.get(Employee.class, employeeNo);
	}
	/**
	 * 查询某部门的经理
	 */
	public Employee getManagerByDeptNo(int deptNo) {
		String hql="from Employee where department.deptNo="+deptNo+" and job.jobName='部门经理'";
		List<Employee> list=super.find(hql);
		return list.size()==0?null:list.get(0);
	}
}
