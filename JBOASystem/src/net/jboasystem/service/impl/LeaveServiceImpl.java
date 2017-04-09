package net.jboasystem.service.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import common.util.json.JSONException;
import common.util.json.JSONWriter;

import net.jboasystem.dao.CheckResultDao;
import net.jboasystem.dao.EmployeeDao;
import net.jboasystem.dao.LeaveDao;
import net.jboasystem.dao.impl.CheckResultDaoImpl;
import net.jboasystem.dao.impl.EmployeeDaoImpl;
import net.jboasystem.dao.impl.LeaveDaoImpl;
import net.jboasystem.entity.CheckedResult;
import net.jboasystem.entity.Employee;
import net.jboasystem.entity.Leave;
import net.jboasystem.service.LeaveService;

public class LeaveServiceImpl implements LeaveService {
	private LeaveDao leaveDao=new LeaveDaoImpl();
	private EmployeeDao empDao=new EmployeeDaoImpl();
	private CheckResultDao checkDao=new CheckResultDaoImpl();
	
	/**
	 * 记录数
	 */
	public int getCount(Employee emp, String startDate, String endDate) {
		if(emp.getJob().getJobName().equals("员工"))
			return leaveDao.getCountByPerson(emp.getEmpNo(), startDate, endDate);
		else if(emp.getJob().getJobName().equals("部门经理"))
			return leaveDao.getCountByDept(emp.getDepartment().getDeptNo(), startDate, endDate);
		
		return leaveDao.getCount(startDate, endDate);
	}
	/**
	 * 查看请假信息
	 */
	public List<Leave> getLeaves(Employee emp, String startDate,
			String endDate, int curPage, int pageSize) {
		if(emp.getJob().getJobName().equals("员工"))
			return leaveDao.getLeavesByPerson(emp.getEmpNo(), startDate, endDate, curPage, pageSize);
		else if(emp.getJob().getJobName().equals("部门经理"))
			return leaveDao.getLeavesByDept(emp.getDepartment().getDeptNo(), startDate, endDate, curPage, pageSize);
		
		return leaveDao.getLeaves(startDate, endDate, curPage, pageSize);
	}
	/**
	 * 查询请假信息，并转换为json格式
	 */
	public String getLeavesToJson(Employee emp, String startDate,
			String endDate, int curPage, int pageSize) {
		List<Leave> list=null;
		
		if(emp.getJob().getJobName().equals("员工"))
			list= leaveDao.getLeavesByPerson(emp.getEmpNo(), startDate, endDate, curPage, pageSize);
		else if(emp.getJob().getJobName().equals("部门经理"))
			list= leaveDao.getLeavesByDept(emp.getDepartment().getDeptNo(), startDate, endDate, curPage, pageSize);
		else
			list= leaveDao.getLeaves(startDate, endDate, curPage, pageSize);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		StringWriter sw=new StringWriter();
		
		JSONWriter json=new JSONWriter(sw);
		try {
			json.object();
			json.key("total").value(this.getCount(emp, startDate, endDate));
			json.key("rows").array();
			for (Leave leave : list) {
				//判断审批状态
				String state="待审核"; //审核状态
				String checkTime="";   //审核时间
				String checkIdea="";   //审核意见
		
				if(leave.getLeaveStatus()==2){
					state="已审核";
					CheckedResult check=checkDao.getCheckedResultByLeaveNo(leave.getLeaveNo());
					checkTime=sdf.format(check.getCheckedTime());
					checkIdea=check.getChenckedIdea(); 
				}
				else if(leave.getLeaveStatus()==3){
					state="已打回";
					CheckedResult check=checkDao.getCheckedResultByLeaveNo(leave.getLeaveNo());
					checkTime=sdf.format(check.getCheckedTime());
					checkIdea=check.getChenckedIdea(); 
				}
				json.object();
				json.key("leaveNo").value(leave.getLeaveNo());
				json.key("name").value(leave.getEmployeeByLeaveEmpNo().getEmpName()+"请假"+leave.getLeaveDateCount()+"天");
				json.key("createTime").value(sdf.format(leave.getCreateTime()));
				json.key("leaveEmpName").value(leave.getEmployeeByLeaveEmpNo().getEmpName());
				json.key("leaveDeptName").value(leave.getEmployeeByLeaveEmpNo().getDepartment().getDeptName());
				json.key("jobName").value(emp.getJob().getJobName());//当前登录人的职务
				json.key("leaveState").value(state);
				json.key("checkTime").value(checkTime);
				json.key("checkIdea").value(checkIdea);
				json.endObject();
			}
			json.endArray();
			json.endObject();
		} catch (JSONException e) {
			System.out.println("将请假信息转换为json错误："+e.getMessage());
		}
		return sw.toString();
	}
	
	/**
	 * 新增请假
	 */
	public boolean addLeave(Leave leave) {
		System.out.println("11111");
		//界面提供部分数据，其他数据需要查询
		//1、审核人是谁：当前登录人所在部门的部门经理
		Employee emp=leave.getEmployeeByLeaveEmpNo(); //取出当前登录人
	
		leave.setEmployeeByNextCheckEmpNo(empDao.getManagerByDeptNo(emp.getDepartment().getDeptNo()));

		//2、设置审核状态
		leave.setLeaveStatus(1);
		//3、设置创建时间
		leave.setCreateTime(new Date());
		//4、添加
		return leaveDao.addLeave(leave);
	}

}
