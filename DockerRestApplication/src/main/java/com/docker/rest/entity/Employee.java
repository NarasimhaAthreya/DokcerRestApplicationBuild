package com.docker.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Column(name = "name")
	private String name;
	@Column(name = "city")
	private String city;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private Long empid;
	@Column(name = "department")
	private String department;

	public Employee() {
	}

	public Employee(String name, String city, Long empid, String department) {
		super();
		this.name = name;
		this.city = city;
		this.empid = empid;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", empid=" + empid + ", department=" + department + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
