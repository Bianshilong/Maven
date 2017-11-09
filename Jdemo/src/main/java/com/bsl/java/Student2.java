package com.bsl.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
@SuppressWarnings("all")
@Setter@Getter
public class Student2 {
	
	private int id;
	private String name;
	private int age;
	private String tel;
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/bsl_demo?useSSL=false";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";
	
	public static String getStu() throws Exception {
		ArrayList at = getStuFromDB();
		String str ="";
		for (Object object : at) {
			str = str+(String) object+"\n";
		}
		return str;
	}

	
	private static ArrayList getStuFromDB() throws Exception{
		ArrayList sl = new ArrayList();
		Student2 student = new Student2();
		Class.forName(DBDRIVER);				//方式二
		//建立连接,导入java.sql.Connection包
		Connection conn = null;
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		//创建statement
		Statement st = conn.createStatement();
		String sql = "select * from stu where age > 25 and id > 10";
		//执行SQL语句
		ResultSet rs= st.executeQuery(sql);
		
		//循环处理得到的结果集
		while (rs.next()) {
			//取得每一条记录中的数据
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			student.setAge(age);
			student.setName(name);
			student.setId(id);
			student.setTel(tel);
			sl.add(student.toString());
		}
		//数据输出完毕
		//释放资源
		rs.close();
		st.close();
		conn.close();
		return sl;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}
}
