package com.jdbc.entity;

public class Student {
	
	private Integer rollNumber;
	private String firstName;
	private String lastName;
	private Integer totalMarks;
	public Student(Integer rollNumber, String firstName, String lastName, Integer totalMarks) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalMarks = totalMarks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", totalMarks=" + totalMarks + "]";
	}
	
	

}
