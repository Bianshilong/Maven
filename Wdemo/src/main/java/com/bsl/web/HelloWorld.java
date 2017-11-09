package com.bsl.web;

import com.bsl.java.Info;
import com.bsl.java.Student;
import com.bsl.java.Student2;

public class HelloWorld {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Hello World,I'm from web!");
		System.out.println(Student.getStu());
		
		Info.PrintMsg();
		System.out.println("----------------");
		System.out.println(Student2.getStu());
	}

}
