package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.AccountService;

public class ValidateAccount extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clId = request.getParameter("clId");
		String clPswd = request.getParameter("pswd");
		AccountService service = new AccountService();
		String clName = service.validate(clId,clPswd);
		if(clName == null)
			request.setAttribute("message", "验证未通过");
		else{
			request.getSession().setAttribute("clId", clId);
			request.setAttribute("message", "姓名为<b style='font-size:20px;color:black'>"+clName+"</b>验证通过");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
