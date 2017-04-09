package net.jboasystem.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateBaseDao {
	private static Session session;
	private static SessionFactory factory;

	/**
	 * ��̬�飺������ʱ��ִ��
	 */
	static {
		//ʵ��ӳ���ļ�
		//Configuration config = new Configuration().configure();
		//ʹ��ע������ʵ��
		Configuration config=new AnnotationConfiguration().configure();
		factory = config.buildSessionFactory();
	}

	/**
	 * �õ��Ѿ��򿪵����ݿ�����
	 * 
	 * @return
	 */
	public static Session getSession() {
		if (session == null || !session.isOpen()) {
			session = factory.openSession();
		}
		return session;
	}

	/**
	 * ͨ����ɾ��
	 * 
	 * @param target
	 * @param option
	 * @return
	 */
	public boolean exeUpdate(Object target, Option option) {
		boolean flag = false;
		getSession();
		Transaction tran = session.beginTransaction();
		try {
			if (option == Option.SAVE)
				session.save(target);
			else if (option == Option.UPDATE)
				session.update(target);
			else
				session.delete(target);

			tran.commit();
			flag = true;
			session.clear();
		} catch (HibernateException e) {
			tran.rollback();
			e.printStackTrace();
			System.out.println("�ԡ�" + target + "��ִ�С�" + option + "����������"
					+ e.getMessage());
		}
		return flag;
	}

	/**
	 * ͨ�ã���������ֵ��ѯ������Ϣ
	 * 
	 * @param clazz
	 *            Ҫ��ѯ��ʵ������Ϣ
	 * @param id
	 *            Ҫ��ѯ������ֵ
	 * @return ��ѯ���Ķ���
	 */
	public Object get(Class clazz, Serializable id) {
		Object object = null;
		getSession();
		try {
			object = session.get(clazz, id);
		} catch (HibernateException e) {
			System.out.println("����������ѯ��" + clazz + "����Ϣ����" + e.getMessage());
		}
		return object;
	}

	/**
	 * ͨ�ã�����hqlִ�в�ѯ
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List find(String hql, Object... params) {
		List list = null;
		getSession();

		try {
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			list = query.list();
		} catch (HibernateException e) {
			System.out.println("��ѯ��" + hql + "������" + e.getMessage());
		}
		return list;

	}

	/**
	 * ͨ�ã�����hqlִ�з�ҳ��ѯ
	 * @param hql		Ҫִ�е�hql���
	 * @param curPage	��ǰҳ
	 * @param pageSize	ÿҳ��¼��
	 * @param params	hql��?ռλ����ֵ
	 * @return
	 */
	public List findByPage(String hql, int curPage, int pageSize,
			Object... params) {
		List list = null;
		getSession();

		try {
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			
			//���ӷ�ҳ���
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			list = query.list();
		} catch (HibernateException e) {
			System.out.println("��ѯ��" + hql + "������" + e.getMessage());
		}
		return list;

	}
	/**
	 * ͨ�ã�ִ��hql���õ�Ψһ����������ھۺϺ�����
	 * @param hql
	 * @param params
	 * @return
	 */
	public Object findByUniqueResult(String hql, Object... params) {
		Object obj=null;
		getSession();

		try {
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			obj=query.uniqueResult();
		} catch (HibernateException e) {
			System.out.println("��ѯ��" + hql + "������" + e.getMessage());
		}
		return obj;

	}

}
