package cn.joker.utils;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/*
 * ���hibernate�Զ�������ʱ���õĲ���utf8�ַ��������� ע������url�������useUnicode=true&amp;characterEncoding=utf8
 * �ļ����������ü���
 * */
public class MySQLDialectUTF8 extends MySQL5InnoDBDialect {
	 @Override  
     public String getTableTypeString() {  
         return " ENGINE=InnoDB DEFAULT CHARSET=utf8";    
     }
}
