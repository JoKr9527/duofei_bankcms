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
		//�����˻���� ���ص�ǰ���
		String all = dao.drawMoney(clId,money);
		//����ȡ����Ϣ��(���һ��ȡ�����)
		dao.insertDraw(clId,mgId,money,all);
		return all;
	}
	public String depositMoney(String clId, String mgId, String deMoney) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		//�����˻���� ���ص�ǰ���
		String all = dao.depositMoney(clId,deMoney);
		//���´����Ϣ�����һ��������)
		dao.insertDeposit(clId,mgId,deMoney,all);
		return all;
	}
	public String transferMoney(String clId, String mgId, String trMoney,
			String trClId) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		//���������˻�
		String all = dao.transferMoney(clId,trMoney,trClId);
		//����ת����Ϣ��(���һ��ת����Ϣ��
		dao.insertTransfer(clId,mgId,trMoney,all,trClId);
		return all;
	}
	public String queryMoney(String clId) {
		// TODO Auto-generated method stub
		dao = new BussinessDao();
		return dao.queryMoney(clId);
	}

}
