package com.example.demo.bean;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int id;
	private String name;
	
	
	public Employee() {
		super();
	}
	public Employee (int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


