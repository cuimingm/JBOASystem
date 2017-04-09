package net.jboasystem.dao;

import net.jboasystem.entity.CheckedResult;

public interface CheckResultDao {
	/**
	 * 查询某个请假申请的审核结果
	 * @param leaveNo
	 * @return
	 */
	CheckedResult getCheckedResultByLeaveNo(int leaveNo);
}
