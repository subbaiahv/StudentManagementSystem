package com.tap.dao;

import java.util.List;

import com.tap.model.Student;

public interface StudentDAO {
   List<Student>fetchAll();
   int insertStudent(Student s);
   Student fetchOnId(int id);
   int updateStudent(Student s);
   int deleteStudent(int id);
   
}
