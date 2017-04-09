package net.jboasystem.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import net.jboasystem.entity.Employee;
import net.jboasystem.entity.Leave;
import net.jboasystem.service.LeaveService;
import net.jboasystem.service.impl.LeaveServiceImpl;
import net.jboasystem.web.action.util.LeavesJson;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LeaveAction extends ActionSupport {
	private LeaveService leaveService=new LeaveServiceImpl();
	private Leave leave;
	private InputStream inputStream;
	private LeavesJson data;
	private int rows=10;   //datagrid�ؼ���ÿҳ��¼��
	private int page=1;  //datagrid�ؼ��ĵ�ǰҳ
	private String startDate="";  //��ʼʱ��
	private String endDate="";//����ʱ��
	/**
	 * ��ʾ�����Ϣ���첽��
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String show() throws UnsupportedEncodingException{
		//�õ���ǰ��¼����Ϣ
		Map session=ActionContext.getContext().getSession();
		Employee emp=(Employee)session.get("employee");
		
		/*int count=leaveService.getCount(emp, startDate, endDate);
		List<Leave> list=leaveService.getLeaves(emp, startDate, endDate, row, page);
		System.out.println(list.size());
		data=new LeavesJson(count, list);
		
		return "ajax";
		*/
		
		String result=leaveService.getLeavesToJson(emp, startDate, endDate, page, rows);
		inputStream=new ByteArrayInputStream(result.getBytes("UTF-8"));
		
		return SUCCESS;
	}
	
	/**
	 * ����������� (�첽)
	 */
	public String add() throws UnsupportedEncodingException{
	
		//�õ���ǰ��¼����Ϣ
		Map session=ActionContext.getContext().getSession();
		Employee emp=(Employee)session.get("employee");
		
		//����ǰ��¼����Ϣ������ٶ�����
		leave.setEmployeeByLeaveEmpNo(emp);
		
		String result="no";
		//����ҵ���߼��㷽��
		if(leaveService.addLeave(leave)){
			result="ok";
		}
		
		inputStream=new ByteArrayInputStream(result.getBytes("UTF-8"));
		return SUCCESS;
	}
	
	
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}



	public LeavesJson getData() {
		return data;
	}

	public void setData(LeavesJson data) {
		this.data = data;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int row) {
		this.rows = row;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
