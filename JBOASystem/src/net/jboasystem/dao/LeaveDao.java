package net.jboasystem.dao;

import java.util.List;

import net.jboasystem.entity.Leave;

public interface LeaveDao {
	/**
	 * 新增请假申请
	 * @param leave
	 * @return
	 */
	boolean addLeave(Leave leave);
	/**
	 * 带条件分页查询某个员工的请假信息
	 * @param empNo			请假的员工编号
	 * @param startDate		开始时间
	 * @param endDate		结束时间
	 * @param curPage		当前页
	 * @param pageSize		每页记录数
	 * @return
	 */
	List<Leave> getLeavesByPerson(int empNo,String startDate,String endDate,int curPage,int pageSize);
	/**
	 * 带条件查询某个员工的请假信息的记录数 
	 * @param empNo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCountByPerson(int empNo,String startDate,String endDate);
	/**
	 * 带条件分页查询某个 部门所有员工的请假信息
	 * @param deptNo
	 * @param startDate
	 * @param endDate
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	List<Leave> getLeavesByDept(int deptNo,String startDate,String endDate,int curPage,int pageSize);
	/**
	 * 带条件查询某个部门所有员工的请假信息的记录数 
	 * @param empNo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCountByDept(int deptNo,String startDate,String endDate);
	/**
	 * 带条件分页查询所有员工的请假信息
	 * @param deptNo
	 * @param startDate
	 * @param endDate
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	List<Leave> getLeaves(String startDate,String endDate,int curPage,int pageSize);
	/**
	 * 带条件查询所有员工的请假信息的记录数 
	 * @param empNo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCount(String startDate,String endDate);
	
}
