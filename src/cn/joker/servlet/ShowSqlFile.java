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
			// 存放备份文件路径
			String path = "F:/DeveSource/upload";
			// 备份数据库
			DataBaseBackup bak = new DataBaseBackup("D:\\MySql5.5\\bin\\",
					"root", "594593");
			// 使用时间作为文件名
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
			String dest = path + "/" + dateFormat.format(now) + ".sql";
			bak.backup(dest, "bcms");

			// 声明集合存放目录下所有的文件
			List<String> fileList = new ArrayList<String>();
			File folder = new File(path);
			// 判断文件夹是否存在并且是否是一个目录
			if (folder.exists() && folder.isDirectory()) {
				// 获得目录中所有文件及目录
				File[] files = folder.listFiles();
				// 遍历 ，将文件放入fileList下
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
			request.setAttribute("message", "登录失效，请重新登录");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
