package cn.joker.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.joker.entity.Client;
import cn.joker.utils.HibernateSessionFactory;

public class AccountDao {

	private Session session = null;

	public void save(Client cl) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(cl);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public String find(String type1, String value1, String type2, String value2) {
		// TODO Auto-generated method stub

		session = HibernateSessionFactory.getSession();
		if (type1 != null && type2 != null) {
			String hql = "select clId from Client where cl_identity=:identity and cl_pswd = :pswd";
			int clId = (int) session.createQuery(hql)
					.setParameter("identity", value1)
					.setParameter("pswd", value2).uniqueResult();
			session.close();
			return Integer.toString(clId);
		}else if(type1 != null && type2 == null){
			String hql = "select clName from Client where "+type1+"=:value1";
			String name = null;
			if("clId".equals(type1))
				name = (String) session.createQuery(hql).setParameter("value1", Integer.parseInt(value1)).uniqueResult();
			else
				name = (String) session.createQuery(hql).setParameter("value1", value1).uniqueResult();
			session.close();
			return name;
		}
		return null;
	}

	public void delete(String identity, String pswd) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();

			String hql = "delete from Client where cl_identity=:identity and cl_pswd =:pswd";
			tx = session.beginTransaction();
			session.createQuery(hql).setParameter("identity", identity)
					.setParameter("pswd", pswd).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public void report(String type, String value,String newStatus) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "update Client set clStatus = :newStatus where "
					+ type + " = :value";

			if ("clId".equals(type))
				session.createQuery(hql).setParameter("newStatus", newStatus)
						.setParameter("value", Integer.parseInt(value))
						.executeUpdate();
			else
				session.createQuery(hql).setParameter("newStatus", newStatus)
						.setParameter("value", value).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public String validate(String clId, String clPswd) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		String hql = "select clName from Client where cl_id = :id and cl_pswd = :pswd";
		String name = (String) session.createQuery(hql).setParameter("id", clId).setParameter("pswd", clPswd).uniqueResult();
		session.close();
		return  name;
		
	}

	public void changePswd(String clId, String pswd) {
		// TODO Auto-generated method stub
		
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "update Client set clPswd = :pswd where clId =:clId";
			session.createQuery(hql).setParameter("pswd", pswd)
					.setParameter("clId", Integer.parseInt(clId))
					.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}


}
