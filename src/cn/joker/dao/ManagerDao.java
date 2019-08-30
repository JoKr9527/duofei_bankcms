package cn.joker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.joker.entity.Manager;
import cn.joker.utils.HibernateSessionFactory;

public class ManagerDao {

	private Session session = null;
	
	@SuppressWarnings("unchecked")
	public boolean login(String managerId, String password) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		String hql = "from Manager where mg_id = :id and mg_pswd = :pswd";
		List<Manager> list = session.createQuery(hql).setParameter("id", managerId).setParameter("pswd", password).list();
		session.close();
		return list.isEmpty() ?false:true;
	}

	public boolean changePswd(String mgId, String oldPw, String newPw) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Manager set mg_pswd = :newPw where mg_id=:mgId and mg_pswd=:oldPw";
		int result = session.createQuery(hql).setParameter("newPw", newPw).setParameter("mgId", mgId).setParameter("oldPw", oldPw)
		.executeUpdate();
		tx.commit();
		session.close();
		return result<=0?false:true;
	}

}
