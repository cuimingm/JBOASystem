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
	 * ��¼��
	 */
	public int getCount(Employee emp, String startDate, String endDate) {
		if(emp.getJob().getJobName().equals("Ա��"))
			return leaveDao.getCountByPerson(emp.getEmpNo(), startDate, endDate);
		else if(emp.getJob().getJobName().equals("���ž���"))
			return leaveDao.getCountByDept(emp.getDepartment().getDeptNo(), startDate, endDate);
		
		return leaveDao.getCount(startDate, endDate);
	}
	/**
	 * �鿴�����Ϣ
	 */
	public List<Leave> getLeaves(Employee emp, String startDate,
			String endDate, int curPage, int pageSize) {
		if(emp.getJob().getJobName().equals("Ա��"))
			return leaveDao.getLeavesByPerson(emp.getEmpNo(), startDate, endDate, curPage, pageSize);
		else if(emp.getJob().getJobName().equals("���ž���"))
			return leaveDao.getLeavesByDept(emp.getDepartment().getDeptNo(), startDate, endDate, curPage, pageSize);
		
		return leaveDao.getLeaves(startDate, endDate, curPage, pageSize);
	}
	/**
	 * ��ѯ�����Ϣ����ת��Ϊjson��ʽ
	 */
	public String getLeavesToJson(Employee emp, String startDate,
			String endDate, int curPage, int pageSize) {
		List<Leave> list=null;
		
		if(emp.getJob().getJobName().equals("Ա��"))
			list= leaveDao.getLeavesByPerson(emp.getEmpNo(), startDate, endDate, curPage, pageSize);
		else if(emp.getJob().getJobName().equals("���ž���"))
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
				//�ж�����״̬
				String state="�����"; //���״̬
				String checkTime="";   //���ʱ��
				String checkIdea="";   //������
		
				if(leave.getLeaveStatus()==2){
					state="�����";
					CheckedResult check=checkDao.getCheckedResultByLeaveNo(leave.getLeaveNo());
					checkTime=sdf.format(check.getCheckedTime());
					checkIdea=check.getChenckedIdea(); 
				}
				else if(leave.getLeaveStatus()==3){
					state="�Ѵ��";
					CheckedResult check=checkDao.getCheckedResultByLeaveNo(leave.getLeaveNo());
					checkTime=sdf.format(check.getCheckedTime());
					checkIdea=check.getChenckedIdea(); 
				}
				json.object();
				json.key("leaveNo").value(leave.getLeaveNo());
				json.key("name").value(leave.getEmployeeByLeaveEmpNo().getEmpName()+"���"+leave.getLeaveDateCount()+"��");
				json.key("createTime").value(sdf.format(leave.getCreateTime()));
				json.key("leaveEmpName").value(leave.getEmployeeByLeaveEmpNo().getEmpName());
				json.key("leaveDeptName").value(leave.getEmployeeByLeaveEmpNo().getDepartment().getDeptName());
				json.key("jobName").value(emp.getJob().getJobName());//��ǰ��¼�˵�ְ��
				json.key("leaveState").value(state);
				json.key("checkTime").value(checkTime);
				json.key("checkIdea").value(checkIdea);
				json.endObject();
			}
			json.endArray();
			json.endObject();
		} catch (JSONException e) {
			System.out.println("�������Ϣת��Ϊjson����"+e.getMessage());
		}
		return sw.toString();
	}
	
	/**
	 * �������
	 */
	public boolean addLeave(Leave leave) {
		System.out.println("11111");
		//�����ṩ�������ݣ�����������Ҫ��ѯ
		//1���������˭����ǰ��¼�����ڲ��ŵĲ��ž���
		Employee emp=leave.getEmployeeByLeaveEmpNo(); //ȡ����ǰ��¼��
	
		leave.setEmployeeByNextCheckEmpNo(empDao.getManagerByDeptNo(emp.getDepartment().getDeptNo()));

		//2���������״̬
		leave.setLeaveStatus(1);
		//3�����ô���ʱ��
		leave.setCreateTime(new Date());
		//4�����
		return leaveDao.addLeave(leave);
	}

}
