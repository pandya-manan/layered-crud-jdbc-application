package com.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.entity.Student;
import com.jdbc.exception.StudentException;

public interface StudentDao {
	
	Boolean addNewStudent(Student student);
	Student retrieveStudentByRollNumber(Integer rollNumber);
	Boolean updateStudentTotalMarksByRollNumber(Integer rollNumber,Integer totalMarks);
	Boolean updateStudent(Integer rollNumber,Student student);
	Boolean deleteStudentByRollNumber(Integer rollNumber);
	List<Student> retrieveAllRecord();

}
