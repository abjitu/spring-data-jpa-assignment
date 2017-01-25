package com.assignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
