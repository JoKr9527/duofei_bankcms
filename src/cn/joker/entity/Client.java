package cn.joker.entity;

import java.util.Date;

/*
 * �ͻ�������Ϣ
 * */
public class Client {
	
	private int clId;
	private String clName;
	private String clPswd;
	private String clIdentity; //�ͻ����֤
	private String clAll;	//���
	private String clStatus;	//����״̬
	private String clAddress;	//��ַ
	private Date clDate;	//��������
	
	public int getClId() {
		return clId;
	}
	public String getClName() {
		return clName;
	}
	public String getClPswd() {
		return clPswd;
	}
	public String getClIdentity() {
		return clIdentity;
	}
	public String getClAll() {
		return clAll;
	}
	public String getClStatus() {
		return clStatus;
	}
	public String getClAddress() {
		return clAddress;
	}
	public Date getClDate() {
		return clDate;
	}
	public void setClId(int clId) {
		this.clId = clId;
	}
	public void setClName(String clName) {
		this.clName = clName;
	}
	public void setClPswd(String clPswd) {
		this.clPswd = clPswd;
	}
	public void setClIdentity(String clIdentity) {
		this.clIdentity = clIdentity;
	}
	public void setClAll(String clAll) {
		this.clAll = clAll;
	}
	public void setClStatus(String clStatus) {
		this.clStatus = clStatus;
	}
	public void setClAddress(String clAddress) {
		this.clAddress = clAddress;
	}
	public void setClDate(Date clDate) {
		this.clDate = clDate;
	}
	
}
