package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.StudentDAO;
import com.tap.dao.impl.StudentDAOImp;
import com.tap.model.Student;

/**
 * Servlet implementation class UpdateStudent
 */
public class UpdateStudent extends HttpServlet {

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String phone=req.getParameter("phone");
	String city=req.getParameter("city");
	Student s=new Student(id,name,email,phone,city);
	StudentDAO sdao=new StudentDAOImp();
	int status=sdao.updateStudent(s);
	if(status!=0)
	{
		resp.sendRedirect("FetchAll");
	}
	

}

}
