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
				// �õ����еı�������Ŀǰ��������FileItem
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {
						// ���item�������ı���
						/*String name = item.getFieldName();
						String value = item.getString();
						System.out.print("������Ϊ:" + name + "����ֵΪ:" + value);*/
					} else {
						// ���item���ļ��ϴ�����

						// ����ļ�����·��
						String fileName = item.getName();
						
						DataBaseBackup dbk = new DataBaseBackup("D:\\MySql5.5\\bin\\mysql", "root", "594593");
						if(fileName != null)
							dbk.restore("F:/DeveSource/upload/"+fileName, "bcms");
						System.out.println(fileName);
						
						/*System.out.println(fileName);
						if (fileName != null) {
							File fullFile = new File(item.getName());
							// ����ļ��������ϴ�
							if (!fullFile.exists()) {
								File fileOnServer = new File("F:/DeveSource/upload/huifu",
										fullFile.getName());
								try {
									item.write(fileOnServer);
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								System.out.println("�ļ�"
										+ fileOnServer.getName() + "�ϴ��ɹ�");
							}
						}*/
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ���δ���ÿ������
		} else {

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
