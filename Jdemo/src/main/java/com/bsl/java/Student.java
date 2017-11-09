package com.bsl.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Student {
	
	private int id;
	private String name;
	private int age;
	private String tel;
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/bsl_demo?useSSL=false";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";
	
	public static Student getStu() throws Exception {
		return getStuFromDB();
	}

	
	private static Student getStuFromDB() throws Exception{
		Student student = new Student();
		Class.forName(DBDRIVER);				//方式二
		//建立连接,导入java.sql.Connection包
		Connection conn = null;
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		//创建statement
		Statement st = conn.createStatement();
		String sql = "select * from stu where id=20";
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
		}
		//数据输出完毕
		//释放资源
		rs.close();
		st.close();
		conn.close();
		return student;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}
}
