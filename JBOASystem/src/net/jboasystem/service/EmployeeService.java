package net.jboasystem.service;

import net.jboasystem.entity.Employee;

public interface EmployeeService {
	/**
	 * ��¼��֤
	 * @param empNo		����
	 * @param loginPass ����
	 * @return			Ա����Ϣ
	 */
	boolean isLogin(Employee emp);
}
