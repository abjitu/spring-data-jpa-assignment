package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.dto.StudentSportResp;
import com.assignment.entity.CategorySport;
import com.assignment.entity.Student;
import com.assignment.repository.CategorySportRepository;
import com.assignment.repository.StudentRepository;

@Service
public class StudentService {

	private @Autowired StudentRepository studentRepository;
	
	private @Autowired CategorySportRepository categorySportRepository;

	@Transactional(readOnly = true)
	public List<StudentSportResp> findById1(Integer id) {
		List<StudentSportResp> studentSports = new ArrayList<>();
		Student student = studentRepository.findOne(id);
		for (CategorySport cs : student.getCategorySportses()) {
			StudentSportResp studentSportResp = new StudentSportResp();
			studentSportResp.setCategory(cs.getCategory().getName());
			studentSportResp.setSport(cs.getName());
			studentSportResp.setStudent(student.getName());
			studentSports.add(studentSportResp);
		}
		return studentSports;
	}
	
	@Transactional(readOnly = true)
	public List<StudentSportResp> findById(Integer id) {
		List<StudentSportResp> studentSports = new ArrayList<>();
		List<CategorySport> sports = categorySportRepository.fetchSports(id);
		for (CategorySport cs : sports) {
			StudentSportResp studentSportResp = new StudentSportResp();
			studentSportResp.setCategory(cs.getCategory().getName());
			studentSportResp.setSport(cs.getName());
			studentSportResp.setStudent(cs.getStudents().iterator().next().getName());
			studentSports.add(studentSportResp);
		}
		return studentSports;
	}

}
