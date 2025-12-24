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
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Student s=new Student(
			req.getParameter("name"),
			req.getParameter("email"),
			req.getParameter("phone"),
			req.getParameter("city"));
	StudentDAO sdao=new StudentDAOImp();
	int status=sdao.insertStudent(s);
	if(status!=0)
	{
		resp.sendRedirect("FetchAll");
	}



}
}
