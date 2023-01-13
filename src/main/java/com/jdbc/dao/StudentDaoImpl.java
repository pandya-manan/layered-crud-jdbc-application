package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {
	
	private Connection connectionToDb;
	
	public StudentDaoImpl()
	{
		super();
		try
		{
			connectionToDb=DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudassignment3", "postgres", "BB11**it");
			System.out.println("The connection is established to the database successfully!");
		}
		catch(SQLException ex)
		{
			System.out.println("The exception caught while establishing connection to Data base is: "+ex.getMessage());
			ex.printStackTrace();
		}
	}

	public Boolean addNewStudent(Student student) {
		Boolean isStudentAdded=false;
		String insertQuery="INSERT INTO STUDENT(ROLL_NUMBER,FIRST_NAME,LAST_NAME,TOTAL_MARKS) VALUES(?,?,?,?)";
		try
		{
			PreparedStatement preparedStatement=this.connectionToDb.prepareStatement(insertQuery);
			preparedStatement.setInt(1, student.getRollNumber());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setInt(4, student.getTotalMarks());
			System.out.println("The insert query to add student to db: "+preparedStatement);
			int insertionCount=preparedStatement.executeUpdate();
			if(insertionCount==1)
			{
				isStudentAdded=true;
			}
		}
		catch(SQLException e)
		{
			System.out.println("The exception caught while adding new student to db is: "+e.getMessage());
			e.printStackTrace();
		}
		return isStudentAdded;
	}

	public Student retrieveStudentByRollNumber(Integer rollNumber) {
		String retrievalQuery="SELECT * FROM STUDENT WHERE ROLL_NUMBER=?";
		Student foundStudent=null;
		try
		{
			PreparedStatement preparedStatement=this.connectionToDb.prepareStatement(retrievalQuery);
			preparedStatement.setInt(1, rollNumber);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				foundStudent=new Student(result.getInt("ROLL_NUMBER"),result.getString("FIRST_NAME"),result.getString("LAST_NAME"),result.getInt("TOTAL_MARKS"));
			}
		}
		catch(SQLException e)
		{
			System.out.println("The Exception is caught as while trying to get student details based on rollNumber is: "+e.getMessage());
			e.printStackTrace();
		}
		return foundStudent;
	}

	public Boolean updateStudentTotalMarksByRollNumber(Integer rollNumber, Integer totalMarks) {
		Boolean isStudentRecordUpdated=false;
		String updateStudentMarksQuery="UPDATE STUDENT SET TOTAL_MARKS=? WHERE ROLL_NUMBER=?";
		try
		{
			PreparedStatement preparedStatement=this.connectionToDb.prepareStatement(updateStudentMarksQuery);
			preparedStatement.setInt(1, totalMarks);
			preparedStatement.setInt(2, rollNumber);
			int countOfUpdatedOps=preparedStatement.executeUpdate();
			if(countOfUpdatedOps==1)
			{
				isStudentRecordUpdated=true;
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("The Exception caught is as follows during updation of student marks: "+e.getMessage());
			e.printStackTrace();
		}
		return isStudentRecordUpdated;
	}

	public Boolean updateStudent(Integer rollNumber, Student student) {
		Boolean isStudentUpdated=false;
		String updateQuery="UPDATE STUDENT SET FIRST_NAME=? , LAST_NAME=?, TOTAL_MARKS=? WHERE ROLL_NUMBER=?";
		try
		{
			PreparedStatement preparedStatement=this.connectionToDb.prepareStatement(updateQuery);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setInt(3, student.getTotalMarks());
			preparedStatement.setInt(4, rollNumber);
			int countOfUpdatedOps=preparedStatement.executeUpdate();
			if(countOfUpdatedOps==1)
			{
				isStudentUpdated=true;
			}
		}
		catch(SQLException e)
		{
			System.out.println("The exception occured during the update of student record is: "+e.getMessage());
			e.printStackTrace();
		}
		return isStudentUpdated;	 
				
	}

	public Boolean deleteStudentByRollNumber(Integer rollNumber) {
		Boolean isStudentDeleted=false;
		String deletionQuery="DELETE FROM STUDENT WHERE ROLL_NUMBER=?";
		try
		{
			PreparedStatement preparedStatement=this.connectionToDb.prepareStatement(deletionQuery);
			preparedStatement.setInt(1, rollNumber);
			int countOfDeletedRecords=preparedStatement.executeUpdate();
			if(countOfDeletedRecords==1)
			{
				isStudentDeleted=true;
			}
		}
		catch(SQLException e)
		{
			System.out.println("The deletion operation encountered an exception: "+e.getMessage());
			e.printStackTrace();
		}
		return isStudentDeleted;
	}

	public List<Student> retrieveAllRecord() {
		List<Student> allRecords=new ArrayList<Student>();
		String query="SELECT * FROM STUDENT ORDER BY ROLL_NUMBER";
		try
		{
			Statement statement=this.connectionToDb.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next())
			{
				Student obtainedStudent=new Student(result.getInt("ROLL_NUMBER"),result.getString("FIRST_NAME"),result.getString("LAST_NAME"),result.getInt("TOTAL_MARKS"));
				allRecords.add(obtainedStudent);
			}
		}
		catch(SQLException e)
		{
			System.out.println("The exception caught while retrieving all records: "+e.getMessage());
			e.printStackTrace();
		}
		return allRecords;
	}

}
