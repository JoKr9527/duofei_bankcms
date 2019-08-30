package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.BussinessService;

public class DrawMoney extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String money = request.getParameter("drawMoney");
		String clId = (String) request.getSession().getAttribute("clId");
		String mgId = (String) request.getSession().getAttribute("managerId");
		BussinessService service = null;
		if(clId!=null && mgId != null){
			service = new BussinessService();
			String all = service.drawMoney(clId,mgId,money);
			request.setAttribute("message","�˺�Ϊ<b style='font-size:20px;color:black'>"+clId+"</b>�Ŀͻ�ȡ�<b style='font-size:20px;color:black'>"+money+"</b>,�����ɹ�<br>��ǰ���Ϊ"+all );	
		}else{
			request.setAttribute("message", "�ͻ���֤��Ϣ���ڣ���������֤");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
