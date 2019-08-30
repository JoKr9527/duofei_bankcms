package cn.joker.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.joker.utils.DataBaseBackup;
import cn.joker.utils.HibernateSessionFactory;

public class UploadSqlFile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {

			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 得到所有的表单域，它们目前都被当作FileItem
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {
						// 如果item是正常的表单域
						/*String name = item.getFieldName();
						String value = item.getString();
						System.out.print("表单域名为:" + name + "表单域值为:" + value);*/
					} else {
						// 如果item是文件上传表单域

						// 获得文件名及路径
						String fileName = item.getName();
						
						DataBaseBackup dbk = new DataBaseBackup("D:\\MySql5.5\\bin\\mysql", "root", "594593");
						if(fileName != null)
							dbk.restore("F:/DeveSource/upload/"+fileName, "bcms");
						System.out.println(fileName);
						
						/*System.out.println(fileName);
						if (fileName != null) {
							File fullFile = new File(item.getName());
							// 如果文件存在则上传
							if (!fullFile.exists()) {
								File fileOnServer = new File("F:/DeveSource/upload/huifu",
										fullFile.getName());
								try {
									item.write(fileOnServer);
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								System.out.println("文件"
										+ fileOnServer.getName() + "上传成功");
							}
						}*/
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 依次处理每个表单域
		} else {

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
