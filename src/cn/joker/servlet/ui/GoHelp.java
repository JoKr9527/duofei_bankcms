package cn.joker.servlet.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoHelp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		if(Integer.parseInt(index) ==1)
			request.setAttribute("show", "��324�Ŷ��������죬��Ȩ�ؾ�");
		else
			request.setAttribute("show", "����****@**.com��ð���");
		request.getRequestDispatcher("/WEB-INF/jsp/goHelp.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
