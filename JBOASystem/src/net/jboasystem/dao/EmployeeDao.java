package net.jboasystem.dao;

import net.jboasystem.entity.Employee;

public interface EmployeeDao {
	/**
	 * ����Ա����Ų�ѯԱ����Ϣ
	 * @param employeeNo
	 * @return
	 */
	Employee getEmployeeByEmpNo(int employeeNo);
	/**
	 * ��ѯĳ���ŵľ���
	 * @param deptNo
	 * @return
	 */
	Employee getManagerByDeptNo(int deptNo);
}
