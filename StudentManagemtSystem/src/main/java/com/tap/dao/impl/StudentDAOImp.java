package com.tap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.connect.DBConnection;
import com.tap.dao.StudentDAO;
import com.tap.model.Student;

public class StudentDAOImp implements StudentDAO{

	private Connection con;


	String fetchAll="select * from student";
	String addStudent="insert into student(name,email,phone,city)values(?,?,?,?)";
String fetchOnID="select * from student where id=?";
String updateStudent="update student set name=?,phone=?,city=? where id=?";
String deleteStudent="delete from student where id=?";
 List<Student> studentList=new ArrayList<>();
private Statement stmt;

private ResultSet res;

private PreparedStatement psmt;

private int status;

	public StudentDAOImp()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DBConnection.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<Student> fetchAll() {
         try
         {
        	 stmt=con.createStatement();
        	 res=stmt.executeQuery(fetchAll);
        	 studentList=extract(res);
        	 
        	 
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         return studentList;
      
	}
	List<Student>extract(ResultSet res)

	{
		try
		{
			while(res.next())
			{
				studentList.add(new Student(res.getString("name"),res.getString("email"),
						res.getString("phone"),res.getString("city")
						));
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public int insertStudent(Student s) {
        try
        {
        	psmt=con.prepareStatement(addStudent);
        	psmt.setString(1,s.getName());
        	psmt.setString(2,s.getEmail());
        	psmt.setString(3,s.getPhone());
        	psmt.setString(4,s.getCity());
        	status=psmt.executeUpdate();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return status;

	}
public Student fetchOnId(int id)
{
	try
	{
	   psmt=con.prepareStatement(fetchOnID);
	   psmt.setInt(1, id);
	   res=psmt.executeQuery();
	   studentList=extract(res);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return studentList.get(0);
}

@Override
public int updateStudent(Student s) {
    try
    {
    	psmt=con.prepareStatement(updateStudent);
    	psmt.setString(1, s.getName());
    	psmt.setString(2,s.getPhone());
    	psmt.setString(3, s.getCity());
    	psmt.setInt(4, s.getId());
    	status=psmt.executeUpdate();
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
  return status;
}

@Override
public int deleteStudent(int id) {
	try
    {
    	psmt=con.prepareStatement(deleteStudent);
    	psmt.setInt(1,id);
    	status=psmt.executeUpdate();
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
  return status;
}
}
