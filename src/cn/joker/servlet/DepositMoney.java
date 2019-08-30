package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.BussinessService;

public class DepositMoney extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deMoney = request.getParameter("depositMoney");
		String clId = (String) request.getSession().getAttribute("clId");
		String mgId = (String) request.getSession().getAttribute("managerId");
		BussinessService service = null;
		if(clId != null && mgId != null){
			service = new BussinessService();
			String all = service.depositMoney(clId,mgId,deMoney);
			request.setAttribute("message","账号为<b style='font-size:20px;color:black'>"+clId+"</b>的客户存款：<b style='font-size:20px;color:black'>"+deMoney+"</b>,操作成功<br>当前余额为"+all );
		}else{
			request.setAttribute("message", "客户验证信息过期，请重新验证");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
