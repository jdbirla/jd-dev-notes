package com.jd.studentapi;




public class Student {
  
	private String studentName;
	private int marks;
	private String subject;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", marks=" + marks + ", subject=" + subject + "]";
	}
	
}
