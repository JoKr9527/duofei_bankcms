package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.AccountService;

public class ReportAccount extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identity = request.getParameter("identity");
		String clId = request.getParameter("clId");
		
		AccountService service = new AccountService();
		String name = null;
		if(identity != null && "".equals(clId)){
			name = service.reportLoss("clIdentity",identity);
		}else if("".equals(identity) && clId != null)
			name = service.reportLoss("clId", clId);
		request.setAttribute("message", "����Ϊ<b style='font-size:20px;color:black'>"+name+"</b>�Ŀͻ��ѳɹ������ʧ");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
