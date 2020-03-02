package cn.joker.service;

import java.util.Date;

import cn.joker.dao.AccountDao;
import cn.joker.entity.Client;

public class AccountService {

	private AccountDao dao = null;
	public String opentAccount(String name, String pswd, String identity,
			String all, String address) {
		// TODO Auto-generated method stub
		Client cl = new Client();
		cl.setClAddress(address);
		cl.setClAll(all);
		cl.setClIdentity(identity);
		cl.setClPswd(pswd);
		cl.setClName(name);
		cl.setClStatus("正常");
		cl.setClDate(new Date());
		dao = new AccountDao();
		dao.save(cl);
		
		return dao.find("clIdentity",identity,"clPswd",pswd);
	}
	public String delete(String identity, String pswd) {
		// TODO Auto-generated method stub
		dao = new AccountDao();
		String clId = dao.find("clIdentity",identity,"clPswd",pswd);
		dao.delete(identity,pswd);
		return clId;
	}
	public String reportLoss(String type, String value) {
		// TODO Auto-generated method stub
		dao = new AccountDao();
		dao.report(type,value,"挂失");
		return dao.find(type, value,null,null);
	}
	public String cancelReport(String identity, String clName) {
		// TODO Auto-generated method stub
		dao = new AccountDao();
		dao.report("clIdentity",identity,"正常");
		return dao.find("clIdentity", identity, null, null);
	}
	public String validate(String clId, String clPswd) {
		// TODO Auto-generated method stub
		dao = new AccountDao();
		
		return dao.validate(clId, clPswd);
	}
	public String changePswd(String clId, String pswd) {
		// TODO Auto-generated method stub
		
		dao = new AccountDao();
		dao.changePswd(clId,pswd);
		return dao.find("clId", clId, null, null);
	}

}
