package net.jboasystem.dao.impl;

import java.util.Date;
import java.util.List;

import net.jboasystem.dao.EmployeeDao;
import net.jboasystem.dao.LeaveDao;
import net.jboasystem.entity.Employee;
import net.jboasystem.entity.Leave;
import net.jboasystem.util.HibernateBaseDao;
import net.jboasystem.util.Option;

public class LeaveDaoImpl extends HibernateBaseDao implements LeaveDao {
	/**
	 * 所有员工请假次数
	 */
	public int getCount(String startDate, String endDate) {
		String hql="select count(le) from Leave le where 1=1 ";
		
		if(!startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd') and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}else if(!startDate.equals("") && endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd')";
		}else if(startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}
		return Integer.parseInt(super.findByUniqueResult(hql).toString());
	}
	/**
	 * 所有员工请假信息
	 */
	public List<Leave> getLeaves(String startDate, String endDate, int curPage,
			int pageSize) {
		String hql="from Leave where 1=1 ";
		
		if(!startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd') and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}else if(!startDate.equals("") && endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd')";
		}else if(startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}
		
		return super.findByPage(hql, curPage, pageSize);
	}
	/**
	 * 部门请假次数
	 */
	public int getCountByDept(int deptNo, String startDate, String endDate) {
		String hql="select count(le) from Leave le where employeeByLeaveEmpNo.department.deptNo="+deptNo;
		
		if(!startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd') and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}else if(!startDate.equals("") && endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd')";
		}else if(startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}
		return Integer.parseInt(super.findByUniqueResult(hql).toString());
	}
	/**
	 * 员工请假次数
	 */
	public int getCountByPerson(int empNo, String startDate, String endDate) {
		String hql="select count(le) from Leave le where employeeByLeaveEmpNo.empNo="+empNo;
		
		if(!startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd') and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}else if(!startDate.equals("") && endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd')";
		}else if(startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}
		return Integer.parseInt(super.findByUniqueResult(hql).toString());
	}
	/**
	 * 部门请假信息
	 */
	public List<Leave> getLeavesByDept(int deptNo, String startDate,
			String endDate, int curPage, int pageSize) {
		String hql="from Leave where employeeByLeaveEmpNo.department.deptNo="+deptNo;
		
		if(!startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd') and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}else if(!startDate.equals("") && endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd')";
		}else if(startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}
		
		return super.findByPage(hql, curPage, pageSize);
	}
	/**
	 * 员工请假信息
	 */
	public List<Leave> getLeavesByPerson(int empNo, String startDate,
			String endDate, int curPage, int pageSize) {
		String hql="from Leave where employeeByLeaveEmpNo.empNo="+empNo;
		
		if(!startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd') and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}else if(!startDate.equals("") && endDate.equals("")){
			hql+=" and leaveStartTime=toDate('"+startDate+"','yyyy-mm-dd')";
		}else if(startDate.equals("") && !endDate.equals("")){
			hql+=" and leaveEndTime=toDate('"+endDate+"','yyyy-mm-dd')";
		}
		
		return super.findByPage(hql, curPage, pageSize);
	}
	/**
	 * 新增
	 */
	public boolean addLeave(Leave leave) {
		return super.exeUpdate(leave, Option.SAVE);
	}
	
	public static void main(String[] args) {
		LeaveDaoImpl dao=new LeaveDaoImpl();
		Leave leave=new Leave();
		leave.setCreateTime(new Date());
		leave.setLeaveStartTime(new Date());
		leave.setLeaveEndTime(new Date());
		leave.setLeaveDateCount(3.0);
		leave.setLeaveNo(100009);
		leave.setLeaveReason("dd");
		leave.setLeaveStatus(1);
		leave.setLeaveType(1);
		EmployeeDao edao=new EmployeeDaoImpl();
		Employee emp=edao.getEmployeeByEmpNo(100006);
		Employee man=edao.getManagerByDeptNo(emp.getDepartment().getDeptNo());
		leave.setEmployeeByLeaveEmpNo(emp);
		leave.setEmployeeByNextCheckEmpNo(man);
		System.out.println(dao.addLeave(leave));
	}

}
