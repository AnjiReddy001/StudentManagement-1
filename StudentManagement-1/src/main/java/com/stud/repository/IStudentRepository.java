package com.stud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stud.modal.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
