package cn.joker.service;

import cn.joker.dao.BussinessDao;
import cn.joker.entity.Client;



public class BussinessService {

	private BussinessDao dao;
	public Client find(String clId) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		return dao.find(clId);
	}
	public String drawMoney(String clId, String mgId,String money) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		//更新账户余额 返回当前余额
		String all = dao.drawMoney(clId,money);
		//更新取款信息表(添加一条取款操作)
		dao.insertDraw(clId,mgId,money,all);
		return all;
	}
	public String depositMoney(String clId, String mgId, String deMoney) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		//更新账户余额 返回当前余额
		String all = dao.depositMoney(clId,deMoney);
		//更新存款信息表（添加一条存款操作)
		dao.insertDeposit(clId,mgId,deMoney,all);
		return all;
	}
	public String transferMoney(String clId, String mgId, String trMoney,
			String trClId) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		//更新两个账户
		String all = dao.transferMoney(clId,trMoney,trClId);
		//更新转账信息表(添加一条转账信息）
		dao.insertTransfer(clId,mgId,trMoney,all,trClId);
		return all;
	}
	public String queryMoney(String clId) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		return dao.queryMoney(clId);
	}

}
