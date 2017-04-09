package net.jboasystem.dao;

import net.jboasystem.entity.Employee;

public interface EmployeeDao {
	/**
	 * 根据员工编号查询员工信息
	 * @param employeeNo
	 * @return
	 */
	Employee getEmployeeByEmpNo(int employeeNo);
	/**
	 * 查询某部门的经理
	 * @param deptNo
	 * @return
	 */
	Employee getManagerByDeptNo(int deptNo);
}
