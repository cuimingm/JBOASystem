package net.jboasystem.service;

import java.util.List;

import net.jboasystem.entity.Employee;
import net.jboasystem.entity.Leave;

public interface LeaveService {
	/**
	 * �����������
	 * @param leave
	 * @return
	 */
	boolean addLeave(Leave leave);
	/**
	 * �鿴�����Ϣ
	 * @param emp			��ǰ��¼��
	 * @param startDate		��ʼʱ��
	 * @param endDate		����ʱ��
	 * @param curPage		��ǰҳ
	 * @param pageSize		ÿҳ��¼��
	 * @return
	 */
	List<Leave> getLeaves(Employee emp,String startDate,String endDate,int curPage,int pageSize);
	/**
	 * ��ټ�¼��
	 * @param emp
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCount(Employee emp,String startDate,String endDate);
	
	String getLeavesToJson(Employee emp,String startDate,String endDate,int curPage,int pageSize);
}
