package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.AccountService;

public class OpenAccount extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pswd = request.getParameter("pswd");
		String identity = request.getParameter("identity");
		String all = request.getParameter("all");
		String address = request.getParameter("address");
		
		AccountService service = new AccountService();
		String clId = service.opentAccount(name,pswd,identity,all,address);		//返回开户后所得账号
		request.setAttribute("message", "开户成功，您的账号为:<b style='font-size:20px;color:black'>"+clId+"</b>");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
