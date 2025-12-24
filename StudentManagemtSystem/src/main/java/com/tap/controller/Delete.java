package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.StudentDAO;
import com.tap.dao.impl.StudentDAOImp;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

int id=Integer.parseInt(req.getParameter("sid"));

StudentDAO sdao=new StudentDAOImp();
int status=sdao.deleteStudent(id);


if(status!=0)
{
	resp.sendRedirect("FetchAll");
}
}
}
