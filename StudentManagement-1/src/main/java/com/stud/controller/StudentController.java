package com.stud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stud.modal.Student;
import com.stud.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@PostMapping("/save")
	public Integer savedStudent(@RequestBody Student student){
		Integer id=studentService.saveStudent(student);
		return id;
	}
	@GetMapping("/getAllStudents")
	public List<Student> getStudent(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id){
		Optional<Student> student=studentService.getStudent(id);
		return student;
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Student> responseEntity= new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteEmployee(id);
		}
		catch (Exception e) {
			e.printStackTrace();
			responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@PutMapping("/upsateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

}
 