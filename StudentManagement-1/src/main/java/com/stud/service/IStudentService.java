package com.stud.service;

import java.util.List;
import java.util.Optional;

import com.stud.modal.Student;

public interface IStudentService {
	Integer saveStudent(Student student);
	public List<Student> getAllStudents();
	Optional<Student> getStudent(Integer id);
	public void deleteEmployee(Integer id);
	Student updateStudent(Student student, Integer id);

}
