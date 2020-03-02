package cn.joker.servlet.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoCustomerInfoManager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		String clId = (String) request.getSession().getAttribute("clId");
		if("2".equals(index) || "3".equals(index)){
			if( clId == null){
				request.setAttribute("message","�ͻ���δ��֤");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;
			}else if(clId != null && "3".equals(index)){
				request.getSession().removeAttribute("client");
				request.getSession().removeAttribute("clId");
				request.setAttribute("message","�˺�Ϊ<b style='font-size:20px;color:black'>"+clId+"</b>�Ŀͻ�ע���ɹ�");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;
			}
		}
		request.setAttribute("index", Integer.parseInt(index));
		request.getRequestDispatcher("/WEB-INF/jsp/customerInfoManager.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
