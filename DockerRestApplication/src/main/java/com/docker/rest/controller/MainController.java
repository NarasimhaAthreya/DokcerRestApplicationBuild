package com.docker.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docker.rest.DAO.EmployeeRepository;
import com.docker.rest.entity.Employee;

@RestController
public class MainController {

	@Autowired
	EmployeeRepository emp;

	@RequestMapping("/test-rest")
	public String testRrest() {

		return "Docker Rest Application is working";
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getCity());
		emp.save(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		System.out.println(id);
		Optional<Employee> obj = emp.findById((long) id);
		Employee emp1 = obj.get();
		System.out.println(emp1);
		return new ResponseEntity<Employee>(emp1, HttpStatus.OK);

	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> emps = (List<Employee>) emp.findAll();
		return emps;

	}

	@GetMapping("/employees/{department}")
	public List<Employee> getbyDepartment(@PathVariable("department") String depname) {
		List<Employee> emps = (List<Employee>) emp.findEmployeeByDepartment(depname);
		return emps;

	}

	@GetMapping("/employees/{department}/{name}")
	public ResponseEntity<List<Employee>> getbyDepartment(@PathVariable("department") String depname,
			@PathVariable("name") String sname) {

		List<Employee> emps = (List<Employee>) emp.findEmployeeByDeparmentandName(sname, depname);
		if (emps.isEmpty()) {

			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.NOT_FOUND);

	}
	

	@GetMapping("/employees/jpql/{department}/{name}")
	public ResponseEntity<List<Employee>> getbyDepartment1(@PathVariable("department") String depname,
			@PathVariable("name") String sname) {

		List<Employee> emps = (List<Employee>) emp.findEmployeeByDeparmentandName(sname, depname);
		if (emps.isEmpty()) {

			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.NOT_FOUND);

	}

}
