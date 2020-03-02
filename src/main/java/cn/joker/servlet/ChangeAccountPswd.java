package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.AccountService;

public class ChangeAccountPswd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pswd = request.getParameter("newPswd");
		String clId = (String) request.getSession().getAttribute("clId");
		
		AccountService service = new AccountService();
		String clName = service.changePswd(clId,pswd);
		request.setAttribute("message", "姓名为<b style='font-size:20px;color:black'>"+clName+"</b>的客户修改密码成功");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
