package com.assignment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", schema = "public")
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<CategorySport> getCategorySportses() {
		return this.categorySportses;
	}

	public void setCategorySportses(Set<CategorySport> categorySportses) {
		this.categorySportses = categorySportses;
	}

}
