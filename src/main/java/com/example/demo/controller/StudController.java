package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.StudentService;
import com.example.demo.entities.Students;

@RestController
public class StudController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/studenthome")
	public String studentinfo() {
		return "This is Student Information";
	}

	// Get Student Information

	@GetMapping("/studentinfo")
	public List<Students> getStudentInfo() {
		return this.studentService.getStudentInfo();

	}

	// Get Information of Students
	@GetMapping("/studentinfo/{studentId}")
	public Students getStudentInfos(@PathVariable int studentId) {
		return this.studentService.getStudentInfos(studentId);
	}

	// Add Information of Students
	@PostMapping("/studentinfo")
	public Students addStudents(@RequestBody Students student) {
		return this.studentService.addStudents(student);
	}

	// Update Information of Students
	@PutMapping("/studentinfo")
	public Students updateStudents(@RequestBody Students student) {
		return this.studentService.updateStudents(student);
	}

	// Delete Information of Students

	@DeleteMapping("/studentinfo/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudents(@PathVariable int studentId) {
		try {
			this.studentService.deleteStudents(studentId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
