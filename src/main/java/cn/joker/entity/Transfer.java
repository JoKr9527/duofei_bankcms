package cn.joker.entity;

import java.util.Date;
import java.util.Set;

/*
 * ת����Ϣ
 * */
public class Transfer {
	
	private String trId;
	private Manager manager;	//����ԱID
	private Client client;	//�ͻ��˺ţ�
	private Set<String> clAll;	//���
	private Client trClient;	//�ͻ�ת���˺�
	private Date trDate;	//ת��ʱ��
	private String trMoney;		//ת�˽��
	
	
	public Set<String> getClAll() {
		return clAll;
	}
	public void setClAll(Set<String> clAll) {
		this.clAll = clAll;
	}	
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public Manager getManager() {
		return manager;
	}
	public Client getClient() {
		return client;
	}
	public Client getTrClient() {
		return trClient;
	}
	public Date getTrDate() {
		return trDate;
	}
	public String getTrMoney() {
		return trMoney;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setTrClient(Client trClient) {
		this.trClient = trClient;
	}
	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}
	public void setTrMoney(String trMoney) {
		this.trMoney = trMoney;
	}
}
