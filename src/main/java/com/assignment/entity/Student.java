package com.assignment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "public")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String cls;
	private String section;
	private Set<CategorySport> categorySportses = new HashSet<CategorySport>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cls")
	public String getCls() {
		return this.cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	@Column(name = "section")
	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_sport", schema = "public", joinColumns = {
			@JoinColumn(name = "student_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "sport_id", nullable = false, updatable = false) })
	public Set<CategorySport> getCategorySportses() {
		return this.categorySportses;
	}

	public void setCategorySportses(Set<CategorySport> categorySportses) {
		this.categorySportses = categorySportses;
	}

}
