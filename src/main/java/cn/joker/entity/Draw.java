package cn.joker.entity;

import java.util.Date;
import java.util.Set;

/*
 * ȡ����Ϣ
 * */
public class Draw {
	
	private String drId;
	private Manager ma;	//����ԱID��
	private Client cl;	//�ͻ��˺ţ����
	private Set<?> clAll;
	private Date drDate;	//ȡ��ʱ��
	private String drMoney;	//ȡ����
	
	public Set<?> getClAll() {
		return clAll;
	}
	public void setClAll(Set<?> clAll) {
		this.clAll = clAll;
	}
	
	
	public String getDrId() {
		return drId;
	}
	public void setDrId(String drId) {
		this.drId = drId;
	}
	public Manager getMa() {
		return ma;
	}
	public Client getCl() {
		return cl;
	}
	public Date getDrDate() {
		return drDate;
	}
	public String getDrMoney() {
		return drMoney;
	}
	public void setMa(Manager manager) {
		this.ma = manager;
	}
	public void setCl(Client client) {
		this.cl = client;
	}
	public void setDrDate(Date drDate) {
		this.drDate = drDate;
	}
	public void setDrMoney(String drMoney) {
		this.drMoney = drMoney;
	}
}
