package com.hql.app;
public class Runner 
{
	public static void main(String[] args) 
	{
		StudentDao dao = new StudentDao();
		StudentDto studentDto = dao.findByName("Kshitij joshi");
		System.out.println(studentDto);
	}
}
