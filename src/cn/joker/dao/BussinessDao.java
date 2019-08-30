package cn.joker.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import org.hibernate.Transaction;

import cn.joker.entity.Client;
import cn.joker.entity.Deposit;
import cn.joker.entity.Draw;
import cn.joker.entity.Manager;
import cn.joker.entity.Transfer;
import cn.joker.utils.HibernateSessionFactory;

public class BussinessDao {

	
	public Client find(String clId) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Client cl = (Client) session.get(Client.class,Integer.parseInt(clId));
		session.close();
		return cl;
	}
	public String drawMoney(String clId, String money) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();

			tx = session.beginTransaction();
			String hql = "update Client set clAll = (clAll - :money) where clId = :clId";
			session.createQuery(hql).setParameter("money", money)
					.setParameter("clId", Integer.parseInt(clId))
					.executeUpdate();
			tx.commit();
			String hq2 = "select clAll from Client where clId = :clId";
			String all = (String) session.createQuery(hq2)
					.setParameter("clId", Integer.parseInt(clId))
					.uniqueResult();
			return all;
			
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
			throw e;
		} finally {
			session.close();
		}
		
	}
	
	/**
	 * @param mgId	操作员Id
	 * @param money 用户取款金额
	 * @param all 用户余额
	 * */
	public void insertDraw(String clId, String mgId, String money,String all) {
		// TODO Auto-generated method stub
		Client cl = new Client();
		cl.setClId(Integer.parseInt(clId));
		Manager ma = new Manager();
		ma.setMgId(mgId);
		Set<String> al = new HashSet<String>();
		al.add(all);
		Draw draw = new Draw();
		draw.setCl(cl);
		draw.setClAll(al);
		draw.setDrDate(new Date());
		draw.setDrMoney(money);
		draw.setMa(ma);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(draw);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
			
	}
	public String depositMoney(String clId, String deMoney) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();

			tx = session.beginTransaction();
			String hql = "update Client set clAll = (clAll + :money) where clId = :clId";
			session.createQuery(hql).setParameter("money", deMoney)
					.setParameter("clId", Integer.parseInt(clId))
					.executeUpdate();
			tx.commit();
			String hq2 = "select clAll from Client where clId = :clId";
			String all = (String) session.createQuery(hq2)
					.setParameter("clId", Integer.parseInt(clId))
					.uniqueResult();
			return all;	
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
			throw e;
		} finally {
			session.close();
		}
		
		
	}
	public void insertDeposit(String clId, String mgId, String deMoney,
			String all) {
		// TODO Auto-generated method stub
		
		Client cl = new Client();
		cl.setClId(Integer.parseInt(clId));
		Manager ma = new Manager();
		ma.setMgId(mgId);
		Set<String> al = new HashSet<String>();
		al.add(all);
		Deposit de = new Deposit();
		de.setCl(cl);
		de.setClAll(al);
		de.setDeDate(new Date());
		de.setDeMoney(deMoney);
		de.setMa(ma);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(de);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}

	}
	public String transferMoney(String clId, String trMoney, String trClId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionFactory.getSession();

			tx = session.beginTransaction();
			String hql = "update Client set clAll = (clAll - :money) where clId = :clId";
			session.createQuery(hql).setParameter("money", trMoney)
					.setParameter("clId", Integer.parseInt(clId))
					.executeUpdate();
			session.flush();
			// 存入另一账户
			String hq2 = "update Client set clAll = (clAll + :money) where clId = :trClId";
			session.createQuery(hq2).setParameter("money", trMoney)
					.setParameter("trClId", Integer.parseInt(trClId))
					.executeUpdate();
			tx.commit();
			// 查询当前账户余额
			/*drawMoney(clId, trMoney);
			depositMoney(trClId, trMoney);
			Session session = HibernateSessionFactory.getSession();*/
			String hq3 = "select clAll from Client where clId = :clId";
			String all = (String) session.createQuery(hq3)
					.setParameter("clId", Integer.parseInt(clId)).uniqueResult();
			return all;
			
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
			throw e;
		} finally {
			session.close();
		}
		
	}
	/**
	 * @param clId 当前账户
	 * @param trMoney 转账金额
	 * @param	all		当前账户余额
	 * @param trClId 目的账户
	 * */
	public void insertTransfer(String clId, String mgId, String trMoney,
			String all, String trClId) {
		// TODO Auto-generated method stub
		Client cl = new Client();
		cl.setClId(Integer.parseInt(clId));
		Manager ma = new Manager();
		ma.setMgId(mgId);
		Set<String> al = new HashSet<String>();
		al.add(all);
		Client trCl = new Client();
		trCl.setClId(Integer.parseInt(trClId));
		Transfer tr = new Transfer();
		tr.setClAll(al);
		tr.setClient(cl);
		tr.setManager(ma);
		tr.setTrClient(trCl);
		tr.setTrDate(new Date());
		tr.setTrMoney(trMoney);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(tr);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
			
	}
	public String queryMoney(String clId) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select clAll from Client where clId = :clId";
		String all = (String) session.createQuery(hql)
				.setParameter("clId", Integer.parseInt(clId)).uniqueResult();
		session.close();
		return all;
	}

}
