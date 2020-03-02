package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.ManagerService;
import cn.joker.utils.CheckInput;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String managerId;
		String password;
		managerId = request.getParameter("manager");
		password = request.getParameter("password");
		
		ManagerService service = null;
		
		if(CheckInput.check(managerId,password)){
			service = new ManagerService();
			boolean isTrue = service.login(managerId,password);
			if(isTrue){
				request.setAttribute("managerId", managerId);
				request.getSession().setAttribute("managerId", managerId);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "µÇÂ¼Ê§°Ü£¬Çë¼ì²éÄúµÄÃÜÂëÕËºÅÊÇ·ñÕýÈ·");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
