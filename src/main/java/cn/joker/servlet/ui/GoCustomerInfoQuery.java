package cn.joker.servlet.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.bean.Page;
import cn.joker.service.InfoQueryService;

public class GoCustomerInfoQuery extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		String pageNum = request.getParameter("pageNum");
		String clId = request.getParameter("clId");
		String clIdentity = request.getParameter("clIdentity");
		//��ֵΪ�յ�ʱ��ֵΪnull
		clId =  "".equals(clId)?null:clId;
		clIdentity =  "".equals(clIdentity)?null:clIdentity;
		
		//ΪPage�����Ը���
		Page page = new Page();
		page.setPageNum(Integer.parseInt(pageNum));
		InfoQueryService service = new InfoQueryService();
		
		if(Integer.parseInt(index) == 1){
			page = service.queryClient(page,clId,clIdentity);
		}else if(Integer.parseInt(index)==2)
			page = service.queryDraw(page,clId);
		
		request.setAttribute("clId", clId);
		request.setAttribute("clIdentity", clIdentity);
		request.setAttribute("page", page);
		request.setAttribute("index", Integer.parseInt(index));
		request.getRequestDispatcher("/WEB-INF/jsp/customerInfoQuery.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
