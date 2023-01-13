package com.jdbc.service;

import java.util.List;

import com.jdbc.dao.StudentDao;
import com.jdbc.dao.StudentDaoImpl;
import com.jdbc.entity.Student;
import com.jdbc.exception.StudentException;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentRepo=new StudentDaoImpl();

	public Student addNewStudent(Student student) throws StudentException {
		
		this.studentRepo.addNewStudent(student);
		return this.studentRepo.retrieveStudentByRollNumber(student.getRollNumber());
		
	}

	public Student retrieveStudentByRollNumber(Integer rollNumber) throws StudentException {
		Student obtainedStudent=this.studentRepo.retrieveStudentByRollNumber(rollNumber);
		try {
			if(obtainedStudent==null)
			{
				throw new StudentException("The student could not be retrieved.");
			}
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obtainedStudent;
	}

	public Student updateStudentTotalMarksByRollNumber(Integer rollNumber, Integer totalMarks) throws StudentException {
		Student searchResult=this.studentRepo.retrieveStudentByRollNumber(rollNumber);
		if(searchResult==null)
			throw new StudentException("No student with matching roll number to update total marks.");
		this.studentRepo.updateStudentTotalMarksByRollNumber(rollNumber, totalMarks);
		return this.studentRepo.retrieveStudentByRollNumber(rollNumber);
	}

	public Student updateStudent(Integer rollNumber, Student student) throws StudentException {
		Student searchResult=this.studentRepo.retrieveStudentByRollNumber(rollNumber);
		if(searchResult==null)
			throw new StudentException("No student with matching roll number to update records.");
		this.studentRepo.updateStudent(rollNumber, student);
		return this.studentRepo.retrieveStudentByRollNumber(rollNumber);
	}

	public Boolean deleteStudentByRollNumber(Integer rollNumber) throws StudentException {
		Student searchResult=this.studentRepo.retrieveStudentByRollNumber(rollNumber);
		Boolean isStudentDeleted=false;
		if(searchResult==null)
		{
			throw new StudentException("No student with matching roll number could be deleted.");
		}
		studentRepo.deleteStudentByRollNumber(rollNumber);
		isStudentDeleted=true;
		return isStudentDeleted;
	}

	public List<Student> retrieveAllRecord() throws StudentException {
		List<Student> allRecords=studentRepo.retrieveAllRecord();
		if(allRecords.size()==0 || allRecords.isEmpty())
		{
			throw new StudentException("There are no records available in db.");
		}
		return allRecords;
	}

}
