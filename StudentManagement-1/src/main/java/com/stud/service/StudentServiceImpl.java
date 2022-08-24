package com.stud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.stud.exception.ResourceNotFound;
import com.stud.modal.Student;
import com.stud.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public Integer saveStudent(Student student) {
		Student studentSaved=studentRepository.save(student);
		return studentSaved.getId();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudebt=studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("Student", "id", id));
		existingStudebt.setFirstName(student.getFirstName());
		existingStudebt.setLastName(student.getLastName());
		existingStudebt.setDob(student.getDob());
		existingStudebt.setClassName(student.getClassName());
		existingStudebt.setSubject(student.getSubject());
		studentRepository.save(existingStudebt);
		return existingStudebt;
	}

}
