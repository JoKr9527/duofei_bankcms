package cn.joker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.service.ManagerService;
import cn.joker.utils.CheckInput;

public class ChangePswd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldPw;
		String newPw;
		String mgId = (String) request.getSession().getAttribute("managerId");
		oldPw = request.getParameter("oldPw");
		newPw = request.getParameter("newPw");
		
		
		ManagerService service = null;
		if(mgId!=null && CheckInput.check(oldPw,newPw)){
			
			service = new ManagerService();
			boolean b = service.changePswd(mgId,oldPw,newPw);
			if(b)
				request.setAttribute("message", "�޸�����ɹ�");
			else
				request.setAttribute("message", "�޸�����ʧ�ܣ�������");
		}else if(mgId == null){
			request.setAttribute("message", "��¼ʧЧ�������µ�¼");
		}else if(!CheckInput.check(oldPw,newPw))
			request.setAttribute("message", "�����˲��Ϸ��ַ�");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
