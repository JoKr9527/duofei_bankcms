package cn.joker.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadSqlFile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "F:/DeveSource/upload";
		String fileName = request.getParameter("fileName").replace("_", ".");
		
		File file = new File(path+"/"+fileName);
		
		if(file.exists()){
			//设置响应类型及响应头
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition", "attachment; filename=\""
				     + fileName + "\"");
			//读取文件
			InputStream inputStream = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			byte[] bytes = new byte[1024];
			
			ServletOutputStream outStream = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(outStream);
			int readLength = 0;
			while ((readLength = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, readLength);
			}
			// 释放资源
			inputStream.close();
			bis.close();
			bos.flush();
			outStream.close();
			bos.close();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
