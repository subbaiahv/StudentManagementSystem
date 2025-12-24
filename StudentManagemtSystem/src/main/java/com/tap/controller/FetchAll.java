package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.StudentDAO;
import com.tap.dao.impl.StudentDAOImp;
import com.tap.model.Student;

/**
 * Servlet implementation class FetchAll
 */
public class FetchAll extends HttpServlet {



@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

StudentDAO sdao=new StudentDAOImp();
List<Student>studentList=sdao.fetchAll();
req.getSession().setAttribute("studentList",studentList);
for(Student s:studentList)
{
	System.out.println(s);
}
resp.sendRedirect("home.jsp");


}

}
