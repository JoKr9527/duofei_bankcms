package cn.joker.servlet.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.entity.Client;
import cn.joker.service.BussinessService;

public class GoCustomerServiceManager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String index = request.getParameter("index");
		String clId = (String) request.getSession().getAttribute("clId");
		if(clId != null){
			BussinessService service = new BussinessService();
			Client cl = service.find(clId);
			request.setAttribute("client", cl);
			
		}else{
			request.setAttribute("message", "客户尚未通过验证");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
			
		request.setAttribute("index", Integer.parseInt(index));
		request.getRequestDispatcher("/WEB-INF/jsp/customerServiceManager.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
