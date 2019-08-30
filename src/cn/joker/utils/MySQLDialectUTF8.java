package cn.joker.utils;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/*
 * 解决hibernate自动创建表时采用的不是utf8字符集的问题 注：需在url后面添加useUnicode=true&amp;characterEncoding=utf8
 * 文件中正常配置即可
 * */
public class MySQLDialectUTF8 extends MySQL5InnoDBDialect {
	 @Override  
     public String getTableTypeString() {  
         return " ENGINE=InnoDB DEFAULT CHARSET=utf8";    
     }
}
