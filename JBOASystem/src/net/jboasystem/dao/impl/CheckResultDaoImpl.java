package net.jboasystem.dao.impl;

import java.util.List;

import net.jboasystem.dao.CheckResultDao;
import net.jboasystem.entity.CheckedResult;
import net.jboasystem.util.HibernateBaseDao;

public class CheckResultDaoImpl extends HibernateBaseDao implements
		CheckResultDao {

	public CheckedResult getCheckedResultByLeaveNo(int leaveNo) {
		String hql="from CheckedResult where checkedType=2 and checkedItemNo="+leaveNo;
		List<CheckedResult> list=super.find(hql);
		return list.size()==0?null:list.get(0);
	}

}
