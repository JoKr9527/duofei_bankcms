package cn.joker.bean;

import java.util.List;

public class Page {
	
	private int pageNum;	//����ҳ
	private int total;	//��ҳ��
	private int pageSize = 6;	//ÿҳ��С
	private int index;	//���ݿ�����ȡ��һ����¼��λ��
	
	private	int	startPage;	//ҳ����ʾ��ʼҳ
	private int endPage;
	private int betweenPages = 6;	//�ܹ���ʾҳ��  ��ʱֻ������Ϊż�������
	
	private List list=null;	//������ݵ�list����
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getBetweenPages() {
		return betweenPages;
	}
	public void setBetweenPages(int betweenPages) {
		this.betweenPages = betweenPages;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getTotal() {
		return total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public List getList() {
		return list;
	}
	public void setPageNum(int pageNum) {
		if(pageNum<=0)
			this.pageNum = 1;
		if(pageNum >= total)
			this.pageNum = total;
		this.index = (pageNum-1) * pageSize;
		this.pageNum = pageNum;
	}
	//����ʼҳ �ͽ���ҳ���߼�
	public void setTotal(int total) {
		//����ֳɶ���ҳ
		int x = total%pageSize;	 //���ж���
		int y ;	//��ҳ
		if(x>0)
			y=total/pageSize +1;
		else
			y = total/pageSize;
		if(y<=betweenPages){
			this.startPage = 1;
			this.endPage = y;
		}else if(pageNum - (betweenPages/2-1)>=1 && (pageNum + betweenPages/2)<=y){
			this.startPage = pageNum - (betweenPages/2-1);
			this.endPage = pageNum + betweenPages/2;
		}else if(pageNum - (betweenPages/2-1)<1 ){
			this.startPage = 1;
			this.endPage = pageNum + betweenPages/2;
		}else if((pageNum + betweenPages/2)>y){
			this.startPage = pageNum - (betweenPages/2-1);
			this.endPage = y;
		}
		this.total = total;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStartPage(int startPage) {
		
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
