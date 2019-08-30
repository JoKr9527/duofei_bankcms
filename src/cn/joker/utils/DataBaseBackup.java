package cn.joker.utils;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.io.OutputStreamWriter;  
import java.io.PrintWriter;  
import java.io.UnsupportedEncodingException;  
/** 
 * MySQL���ݿ�ı�����ָ� ȱ�ݣ����ܻᱻɱ��������� 
 *  
 * @author xxx 
 * @version xxx 
 */  
public class DataBaseBackup {  
    /** MySQL��װĿ¼��BinĿ¼�ľ���·�� */  
    private String mysqlBinPath;  
    /** ����MySQL���ݿ���û��� */  
    private String username;  
    /** ����MySQL���ݿ������ */  
    private String password;  
    public String getMysqlBinPath() {  
        return mysqlBinPath;  
    }  
    public void setMysqlBinPath(String mysqlBinPath) {  
        this.mysqlBinPath = mysqlBinPath;  
    }  
    public String getUsername() {  
        return username;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public DataBaseBackup(String mysqlBinPath, String username, String password) {  
        if (!mysqlBinPath.endsWith(File.separator)) {  
            mysqlBinPath = mysqlBinPath + File.separator; 
            
        }  
        this.mysqlBinPath = mysqlBinPath;  
        this.username = username;  
        this.password = password;  
    }  
    /** 
     * �������ݿ� 
     *  
     * @param output 
     *            ����� 
     * @param dbname 
     *            Ҫ���ݵ����ݿ��� 
     */  
    public void backup(OutputStream output, String dbname) {  
        String command = "cmd /c " + mysqlBinPath + "mysqldump -u" + username  
                + " -p" + password + " --set-charset=utf8 " + dbname;  
        PrintWriter p = null;  
        BufferedReader reader = null;  
        try {  
            p = new PrintWriter(new OutputStreamWriter(output, "utf8"));  
            Process process = Runtime.getRuntime().exec(command);  
            InputStreamReader inputStreamReader = new InputStreamReader(process  
                    .getInputStream(), "utf8");  
            reader = new BufferedReader(inputStreamReader);  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                p.println(line);  
              
            }  
            p.flush();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (reader != null) {  
                    reader.close();  
                }  
                if (p != null) {  
                    p.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    /** 
     * �������ݿ⣬���ָ��·�����ļ������ڻ��Զ����� 
     *  
     * @param dest 
     *            �����ļ���·�� 
     * @param dbname 
     *            Ҫ���ݵ����ݿ� 
     */  
    public void backup(String dest, String dbname) {  
        try {  
            OutputStream out = new FileOutputStream(dest);  
            backup(out, dbname);  
            try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * �ָ����ݿ� 
     *  
     * @param input 
     *            ������ 
     * @param dbname 
     *            ���ݿ��� 
     */  
    public void restore(InputStream input, String dbname) {  
        String command =mysqlBinPath + " -u" + username  
                + " -p" + password + " --default-character-set=utf8 " + dbname;  
        try {  
            Process process = Runtime.getRuntime().exec(command);  
            OutputStream out = process.getOutputStream();
            /*InputStream error = process.getErrorStream();
            File c = new File("D:/error.txt");
            byte[] b = new byte[1024];
           
            FileOutputStream in = new FileOutputStream(c);
            while(error.read()!=-1){
            	error.read(b);
            	in.write(b);
            }
            in.flush();
            in.close();*/
            
           
            
            String line = null;  
            String outStr = null;  
            StringBuffer sb = new StringBuffer("");  
            BufferedReader br = new BufferedReader(new InputStreamReader(input,  
                    "utf8"));  
            while ((line = br.readLine()) != null) {
                sb.append(line + "/r/n");  
            }  
            outStr = sb.toString();  
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");  
            writer.write(outStr);  
            writer.flush(); 
            try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            out.close();  
            br.close();  
            writer.close();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * �ָ����ݿ� 
     *  
     * @param dest 
     *            �����ļ���·�� 
     * @param dbname 
     *            ���ݿ��� 
     */  
    public void restore(String dest, String dbname) {  
        try {  
            InputStream input = new FileInputStream(dest);  
            restore(input, dbname);
            try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
    } 
   /* ʾ��
    * public static void main(String[] args) {  
        Configuration config = HibernateSessionFactory.getConfiguration();  
        String binPath = config.getProperty("mysql.binpath");  
        String userName = config.getProperty("connection.username");  
        String pwd = config.getProperty("connection.password");  
        DatabaseBackup bak = new DatabaseBackup(binPath, userName, pwd);  
        bak.backup("c:/ttt.sql", "ttt");  
                bak.restore("c:/ttt.sql", "ttt");  
    }  */
}
