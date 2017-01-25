package com.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.StudentSportResp;
import com.assignment.service.StudentService;

@RestController
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	private @Autowired StudentService studentService;

	@RequestMapping(value = "/student/{id}")
	public List<StudentSportResp> greeting(@PathVariable Integer id) {
		log.info("Student by id :{}", id);
		return studentService.findById(id);
	}
}
