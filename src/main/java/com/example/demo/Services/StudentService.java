package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Students;

public interface StudentService 
{
	public  List<Students> getStudentInfo();
	
	public Students getStudentInfos(int studentId);
	
	public Students addStudents(Students student);

	public Students updateStudents(Students student);

	public  void deleteStudents(int parseLong);
}
