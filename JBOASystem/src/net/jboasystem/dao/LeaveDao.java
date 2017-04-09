package net.jboasystem.dao;

import java.util.List;

import net.jboasystem.entity.Leave;

public interface LeaveDao {
	/**
	 * �����������
	 * @param leave
	 * @return
	 */
	boolean addLeave(Leave leave);
	/**
	 * ��������ҳ��ѯĳ��Ա���������Ϣ
	 * @param empNo			��ٵ�Ա�����
	 * @param startDate		��ʼʱ��
	 * @param endDate		����ʱ��
	 * @param curPage		��ǰҳ
	 * @param pageSize		ÿҳ��¼��
	 * @return
	 */
	List<Leave> getLeavesByPerson(int empNo,String startDate,String endDate,int curPage,int pageSize);
	/**
	 * ��������ѯĳ��Ա���������Ϣ�ļ�¼�� 
	 * @param empNo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCountByPerson(int empNo,String startDate,String endDate);
	/**
	 * ��������ҳ��ѯĳ�� ��������Ա���������Ϣ
	 * @param deptNo
	 * @param startDate
	 * @param endDate
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	List<Leave> getLeavesByDept(int deptNo,String startDate,String endDate,int curPage,int pageSize);
	/**
	 * ��������ѯĳ����������Ա���������Ϣ�ļ�¼�� 
	 * @param empNo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCountByDept(int deptNo,String startDate,String endDate);
	/**
	 * ��������ҳ��ѯ����Ա���������Ϣ
	 * @param deptNo
	 * @param startDate
	 * @param endDate
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	List<Leave> getLeaves(String startDate,String endDate,int curPage,int pageSize);
	/**
	 * ��������ѯ����Ա���������Ϣ�ļ�¼�� 
	 * @param empNo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCount(String startDate,String endDate);
	
}
