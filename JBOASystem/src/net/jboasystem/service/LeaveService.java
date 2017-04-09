package net.jboasystem.service;

import java.util.List;

import net.jboasystem.entity.Employee;
import net.jboasystem.entity.Leave;

public interface LeaveService {
	/**
	 * 新增请假申请
	 * @param leave
	 * @return
	 */
	boolean addLeave(Leave leave);
	/**
	 * 查看请假信息
	 * @param emp			当前登录人
	 * @param startDate		开始时间
	 * @param endDate		结束时间
	 * @param curPage		当前页
	 * @param pageSize		每页记录数
	 * @return
	 */
	List<Leave> getLeaves(Employee emp,String startDate,String endDate,int curPage,int pageSize);
	/**
	 * 请假记录数
	 * @param emp
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCount(Employee emp,String startDate,String endDate);
	
	String getLeavesToJson(Employee emp,String startDate,String endDate,int curPage,int pageSize);
}
