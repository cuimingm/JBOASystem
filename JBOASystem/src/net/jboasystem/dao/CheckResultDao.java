package net.jboasystem.dao;

import net.jboasystem.entity.CheckedResult;

public interface CheckResultDao {
	/**
	 * ��ѯĳ������������˽��
	 * @param leaveNo
	 * @return
	 */
	CheckedResult getCheckedResultByLeaveNo(int leaveNo);
}
