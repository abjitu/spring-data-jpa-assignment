package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.assignment.entity.CategorySport;

public interface CategorySportRepository extends CrudRepository<CategorySport, Integer> {

	@Query("Select cs from CategorySport cs inner join cs.students s where s.id = :id")
	public List<CategorySport> fetchSports(@Param("id") Integer id);
	
}
