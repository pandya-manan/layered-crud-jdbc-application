package com.jdbc.service;

import java.util.List;

import com.jdbc.entity.Student;
import com.jdbc.exception.StudentException;

public interface StudentService {
	
	Student addNewStudent(Student student) throws StudentException;
	Student retrieveStudentByRollNumber(Integer rollNumber) throws StudentException;
	Student updateStudentTotalMarksByRollNumber(Integer rollNumber,Integer totalMarks) throws StudentException;
	Student updateStudent(Integer rollNumber,Student student) throws StudentException;
	Boolean deleteStudentByRollNumber(Integer rollNumber) throws StudentException;
	List<Student> retrieveAllRecord() throws StudentException;

}
