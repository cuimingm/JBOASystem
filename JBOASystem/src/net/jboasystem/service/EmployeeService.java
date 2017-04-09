package net.jboasystem.service;

import net.jboasystem.entity.Employee;

public interface EmployeeService {
	/**
	 * 登录验证
	 * @param empNo		工号
	 * @param loginPass 密码
	 * @return			员工信息
	 */
	boolean isLogin(Employee emp);
}
