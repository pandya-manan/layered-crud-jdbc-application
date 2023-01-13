package com.jdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.jdbc.entity.Student;
import com.jdbc.service.StudentService;
import com.jdbc.service.StudentServiceImpl;

public class StudentController {

	public static void main(String[] args) {
		
		StudentService service=new StudentServiceImpl();
		
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Database.");
		System.out.println("Choose from the following options.");
		System.out.println("1.Add New Student");
		System.out.println("2.Retrieve Student By Roll Number");
		System.out.println("3.Update Student Total Marks By Roll Number");
		System.out.println("4.Update Student");
		System.out.println("5.Delete Student by Roll Number");
		System.out.println("6.All records from DB");
		
		Scanner sc=new Scanner(System.in);	
		System.out.println("Enter the choice immediately: ");
		int userInput=sc.nextInt();
		
		switch(userInput)
		{
		case 1: System.out.println("Please enter the following details.");
				System.out.println("Enter the roll number");
				Integer rollNumber=sc.nextInt();
				System.out.println("Enter the first name");
				String firstName=sc.next();
				System.out.println("Enter the last name");
				String lastName=sc.next();
				System.out.println("Enter the total marks");
				Integer totalMarks=sc.nextInt();
				try
				{
					Student toAddStudent=new Student(rollNumber,firstName,lastName,totalMarks);
					Student addedStudent=service.addNewStudent(toAddStudent);
					if(addedStudent!=null)
						System.out.println("The Student: "+addedStudent.toString()+" is added successfully!");
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
		case 2: try
				{
					System.out.println("Enter roll number: ");
					Integer rollNumber2=sc.nextInt();
					Student retrieveStudentByRollNumber=service.retrieveStudentByRollNumber(rollNumber2);
					if(retrieveStudentByRollNumber!=null)
						System.out.println("The student details: "+retrieveStudentByRollNumber.toString());
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
		case 3: try
				{
					System.out.println("Enter the roll number whose marks have to be updated: ");
					Integer rollNumber3=sc.nextInt();
					System.out.println("Enter the total marks to be updated: ");
					Integer totalMarks3=sc.nextInt();
					Student updatedRecord=service.updateStudentTotalMarksByRollNumber(rollNumber3, totalMarks3);
					if(updatedRecord!=null)
						System.out.println("The updated record is: "+updatedRecord.toString());
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
		case 4: try
				{
					System.out.println("Please enter the following details.");
					System.out.println("Enter the roll number");
					Integer rollNumber4=sc.nextInt();
					System.out.println("Enter the first name");
					String firstName4=sc.next();
					System.out.println("Enter the last name");
					String lastName4=sc.next();
					System.out.println("Enter the total marks");
					Integer totalMarks4=sc.nextInt();
					
					Student toUpdateStudent=new Student(rollNumber4,firstName4,lastName4,totalMarks4);
					Student updatedStudent=service.updateStudent(rollNumber4, toUpdateStudent);
					if(updatedStudent!=null)
						System.out.println("The updated record is: "+updatedStudent.toString());
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
		case 5: try
				{
					System.out.println("Enter the roll number so that the particular student record can be deleted");
					Integer rollNumber5=sc.nextInt();
					Boolean deletedRecord=service.deleteStudentByRollNumber(rollNumber5);
					if(deletedRecord==true)
					{
						System.out.println("The Student was deleted successfully!");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
		case 6:	try
				{
					List<Student> allRecordsFromDb=service.retrieveAllRecord();
					if(!allRecordsFromDb.isEmpty() || !(allRecordsFromDb.size()==0))
					{
						System.out.println("The records from the db are: ");
						for(Student student:allRecordsFromDb)
						{
							System.out.print(student+" ");
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
				default:System.out.println("Only 6 ops available. Enter the correct option!!");
		
		}

	}

}
