package cn.joker.entity;

import java.util.Date;
import java.util.Set;

/*
 * 转账信息
 * */
public class Transfer {
	
	private String trId;
	private Manager manager;	//操作员ID
	private Client client;	//客户账号，
	private Set<String> clAll;	//余额
	private Client trClient;	//客户转账账号
	private Date trDate;	//转账时间
	private String trMoney;		//转账金额
	
	
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
