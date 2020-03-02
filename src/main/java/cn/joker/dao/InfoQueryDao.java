package cn.joker.dao;

import java.util.List;

import org.hibernate.Session;

import cn.joker.bean.Page;
import cn.joker.entity.Client;
import cn.joker.entity.Draw;
import cn.joker.utils.HibernateSessionFactory;

public class InfoQueryDao {

	private Session session;
	public Page queryClient(Page page, String clId, String clIdentity) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		String hql = null;
		String hq2 = null;
		if(clId==null && clIdentity == null){
			hql = "from Client";
			hq2 = "select count(*) from Client";
		}
		else if(clId!=null && clIdentity == null){
			hql = "from Client where clId ="+Integer.parseInt(clId);
			hq2 = "select count(*) from Client where clId ="+Integer.parseInt(clId);
		}
		else if(clId==null && clIdentity != null){
			hql = "from Client where clIdentity = '"+clIdentity+"'";
			hq2 = "select count(*) from Client where clIdentity = '"+clIdentity+"'";
		}
		else if(clId!=null && clIdentity != null){
			hql = "from Client where clId ="+Integer.parseInt(clId)+"and clIdentity ='"+clIdentity+"'";
			hq2 = "select count(*) from Client where clId ="+Integer.parseInt(clId)+" and clIdentity ='"+clIdentity+"'";
		}
		String total =  session.createQuery(hq2).uniqueResult().toString();
		page.setTotal(Integer.parseInt(total));
		@SuppressWarnings("unchecked")
		List<Client> list = session.createQuery(hql).setFirstResult(page.getIndex()).setMaxResults(page.getPageSize()).list();
		page.setList(list);
		session.close();
		return page;
	}
	public Page queryDraw(Page page, String clId) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		String hql = null;
		String hq2 = null;
		if(clId==null){
			hql = "from Draw";
			hq2 = "select count(*) from Draw";
		}
		else if(clId!=null){
			hql = "from Draw d where d.cl.clId ="+Integer.parseInt(clId);
			hq2 = "select count(*) from Draw d where d.cl.clId ="+Integer.parseInt(clId);
		}
		String total =  session.createQuery(hq2).uniqueResult().toString();
		page.setTotal(Integer.parseInt(total));
		@SuppressWarnings("unchecked")
		List<Draw> list = session.createQuery(hql).setFirstResult(page.getIndex()).setMaxResults(page.getPageSize()).list();
		page.setList(list);
		session.close();
		return page;
	}
	public Page queryDeposit(Page page, String clId) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		String hql = null;
		String hq2 = null;
		if(clId==null){
			hql = "from Deposit";
			hq2 = "select count(*) from Deposit";
		}
		else if(clId!=null){
			hql = "from Deposit d where d.cl.clId ="+Integer.parseInt(clId);
			hq2 = "select count(*) from Deposit d where d.cl.clId ="+Integer.parseInt(clId);
		}
		String total =  session.createQuery(hq2).uniqueResult().toString();
		page.setTotal(Integer.parseInt(total));
		@SuppressWarnings("unchecked")
		List<Draw> list = session.createQuery(hql).setFirstResult(page.getIndex()).setMaxResults(page.getPageSize()).list();
		page.setList(list);
		session.close();
		return page;
	}
	public Page queryTransfer(Page page, String clId) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		String hql = null;
		String hq2 = null;
		if(clId==null){
			hql = "from Transfer";
			hq2 = "select count(*) from Transfer";
		}
		else if(clId!=null){
			hql = "from Transfer t where t.client.clId ="+Integer.parseInt(clId);
			hq2 = "select count(*) from Transfer t where t.client.clId ="+Integer.parseInt(clId);
		}
		String total =  session.createQuery(hq2).uniqueResult().toString();
		page.setTotal(Integer.parseInt(total));
		@SuppressWarnings("unchecked")
		List<Draw> list = session.createQuery(hql).setFirstResult(page.getIndex()).setMaxResults(page.getPageSize()).list();
		page.setList(list);
		session.close();
		return page;
	}

}
