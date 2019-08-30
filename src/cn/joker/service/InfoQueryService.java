package cn.joker.service;

import cn.joker.bean.Page;
import cn.joker.dao.InfoQueryDao;

public class InfoQueryService {

	private InfoQueryDao dao = null;
	public Page queryClient(Page page, String clId, String clIdentity) {
		// TODO Auto-generated method stub
		dao = new InfoQueryDao();
		page = dao.queryClient(page,clId,clIdentity);
		return page;
	}
	public Page queryDraw(Page page, String clId) {
		// TODO Auto-generated method stub
		dao= new InfoQueryDao();
		page = dao.queryDraw(page,clId);
		return page;
	}
	public Page queryDeposit(Page page, String clId) {
		// TODO Auto-generated method stub
		dao = new InfoQueryDao();
		page = dao.queryDeposit(page,clId);
		return page;
	}
	public Page queryTransfer(Page page, String clId) {
		// TODO Auto-generated method stub
		dao = new InfoQueryDao();
		page = dao.queryTransfer(page,clId);
		return page;
	}

}
