package cn.joker.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joker.utils.DataBaseBackup;
import cn.joker.utils.HibernateSessionFactory;

public class ShowSqlFile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("managerId") != null) {
			// ��ű����ļ�·��
			String path = "F:/DeveSource/upload";
			// �������ݿ�
			DataBaseBackup bak = new DataBaseBackup("D:\\MySql5.5\\bin\\",
					"root", "594593");
			// ʹ��ʱ����Ϊ�ļ���
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
			String dest = path + "/" + dateFormat.format(now) + ".sql";
			bak.backup(dest, "bcms");

			// �������ϴ��Ŀ¼�����е��ļ�
			List<String> fileList = new ArrayList<String>();
			File folder = new File(path);
			// �ж��ļ����Ƿ���ڲ����Ƿ���һ��Ŀ¼
			if (folder.exists() && folder.isDirectory()) {
				// ���Ŀ¼�������ļ���Ŀ¼
				File[] files = folder.listFiles();
				// ���� �����ļ�����fileList��
				for (File file : files) {
					if (file.isFile())
						fileList.add(file.getName());
				}
			}
			request.setAttribute("fileList", fileList);

			request.setAttribute("index", 2);
			request.getRequestDispatcher("/WEB-INF/jsp/systemManager.jsp")
					.forward(request, response);
		}else{
			request.setAttribute("message", "��¼ʧЧ�������µ�¼");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
