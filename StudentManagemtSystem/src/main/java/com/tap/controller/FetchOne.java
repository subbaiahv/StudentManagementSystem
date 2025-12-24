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
 * Servlet implementation class FetchOne
 */
public class FetchOne extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
int id=Integer.parseInt(req.getParameter("id"));		
StudentDAO sdao=new StudentDAOImp();
Student student=sdao.fetchOnId(id);
		req.getSession().setAttribute("student", student);
		resp.sendRedirect("editStudent.jsp");

	}

}
