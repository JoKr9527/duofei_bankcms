package cn.joker.service;

import cn.joker.dao.ManagerDao;

public class ManagerService {
	
	private ManagerDao dao;
	
	public boolean login(String managerId, String password) {
		// TODO Auto-generated method stub
		
		dao = new ManagerDao();
		return dao.login(managerId,password);
	}

	public boolean changePswd(String mgId, String oldPw, String newPw) {
		// TODO Auto-generated method stub
		dao = new ManagerDao();
		return dao.changePswd(mgId,oldPw,newPw);
	}

}
