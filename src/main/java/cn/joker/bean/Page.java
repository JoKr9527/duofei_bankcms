package cn.joker.bean;

import java.util.List;

public class Page {
	
	private int pageNum;	//访问页
	private int total;	//总页数
	private int pageSize = 6;	//每页大小
	private int index;	//数据库所获取第一个记录的位置
	
	private	int	startPage;	//页面显示起始页
	private int endPage;
	private int betweenPages = 6;	//总共显示页数  暂时只处理了为偶数的情况
	
	private List list=null;	//存放数据的list集合
	
	
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
	//处理开始页 和结束页的逻辑
	public void setTotal(int total) {
		//计算分成多少页
		int x = total%pageSize;	 //做判断用
		int y ;	//分页
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
