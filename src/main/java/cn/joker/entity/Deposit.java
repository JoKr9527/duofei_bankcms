package cn.joker.entity;

import java.util.Date;
import java.util.Set;

/*
 * 存款信息
 * */
public class Deposit {
	
	private String deId;	
	
	private Manager ma;	//操作员Id
	private Client cl;	//客户账号
	private Set<?> clAll; //存款余额
	private Date deDate;
	private String deMoney;	//存款金额
	
	public String getDeId() {
		return deId;
	}
	public void setDeId(String deId) {
		this.deId = deId;
	}
	public Set<?> getClAll() {
		return clAll;
	}
	public void setClAll(Set<?> clAll) {
		this.clAll = clAll;
	}
	
	public Manager getMa() {
		return ma;
	}
	public Client getCl() {
		return cl;
	}
	public Date getDeDate() {
		return deDate;
	}
	public String getDeMoney() {
		return deMoney;
	}
	public void setMa(Manager manager) {
		this.ma = manager;
	}
	public void setCl(Client client) {
		this.cl = client;
	}
	public void setDeDate(Date deDate) {
		this.deDate = deDate;
	}
	public void setDeMoney(String deMoney) {
		this.deMoney = deMoney;
	}
	
	
}
