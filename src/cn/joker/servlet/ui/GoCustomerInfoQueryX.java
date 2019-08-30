package cn.joker.servlet.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.bean.Page;
import cn.joker.service.InfoQueryService;

public class GoCustomerInfoQueryX extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String index = request.getParameter("index");
		String pageNum = request.getParameter("pageNum");
		String clId = request.getParameter("clId");
		
		//当值为空的时候赋值为null
		clId =  "".equals(clId)?null:clId;
		
		//为Page各属性复制
		Page page = new Page();
		page.setPageNum(Integer.parseInt(pageNum));
		InfoQueryService service = new InfoQueryService();
		
		if(Integer.parseInt(index) == 1){
			page = service.queryDeposit(page,clId);
		}else if(Integer.parseInt(index)==2)
			page = service.queryTransfer(page,clId);
		
		request.setAttribute("clId", clId);
		request.setAttribute("page", page);
		request.setAttribute("index", Integer.parseInt(index));
		request.getRequestDispatcher("/WEB-INF/jsp/customerInfoQueryX.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
