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
	 * 静态块：加载类时被执行
	 */
	static {
		//实体映射文件
		//Configuration config = new Configuration().configure();
		//使用注解配置实体
		Configuration config=new AnnotationConfiguration().configure();
		factory = config.buildSessionFactory();
	}

	/**
	 * 得到已经打开的数据库连接
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
	 * 通用增删改
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
			System.out.println("对【" + target + "】执行【" + option + "】操作错误"
					+ e.getMessage());
		}
		return flag;
	}

	/**
	 * 通用：根据主键值查询对象信息
	 * 
	 * @param clazz
	 *            要查询的实体类信息
	 * @param id
	 *            要查询的主键值
	 * @return 查询到的对象
	 */
	public Object get(Class clazz, Serializable id) {
		Object object = null;
		getSession();
		try {
			object = session.get(clazz, id);
		} catch (HibernateException e) {
			System.out.println("根据主键查询【" + clazz + "】信息错误：" + e.getMessage());
		}
		return object;
	}

	/**
	 * 通用：根据hql执行查询
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
			System.out.println("查询【" + hql + "】错误：" + e.getMessage());
		}
		return list;

	}

	/**
	 * 通用：根据hql执行分页查询
	 * @param hql		要执行的hql语句
	 * @param curPage	当前页
	 * @param pageSize	每页记录数
	 * @param params	hql中?占位符的值
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
			
			//增加分页语句
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			list = query.list();
		} catch (HibernateException e) {
			System.out.println("查询【" + hql + "】错误：" + e.getMessage());
		}
		return list;

	}
	/**
	 * 通用：执行hql语句得到唯一结果（多用于聚合函数）
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
			System.out.println("查询【" + hql + "】错误：" + e.getMessage());
		}
		return obj;

	}

}
