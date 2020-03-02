package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.AccountService;

public class CancelAccount extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String identity = request.getParameter("identity");
		String pswd = request.getParameter("pswd");
		
		AccountService service = new AccountService();
		String clId = service.delete(identity,pswd);
		
		request.setAttribute("message", "�˺�Ϊ<b style='font-size:20px;color:black'>"+clId+"</b>�Ŀͻ��ѳɹ�����");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
