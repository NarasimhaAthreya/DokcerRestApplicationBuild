package com.docker.rest.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.docker.rest.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long > {
	
	
	public List<Employee> findEmployeeByDepartment(String depname);
	
	@Query(value="SELECT * from EMPLOYEE WHERE DEPARTMENT = :department and NAME = :name",nativeQuery = true)
	public  List<Employee> findEmployeeByDeparmentandName(@Param("name")String name, @Param("department")String department);
	
	@Query("SELECT e from Employee e WHERE e.department = :department and e.name = :name")
	public  List<Employee> findEmployeeByDeparmentandName1(@Param("name")String name, @Param("department")String department);


}
