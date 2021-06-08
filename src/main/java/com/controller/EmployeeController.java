/**
 * Created on Jun 08, 2021 
 */
package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constants.ServiceConstants;
import com.model.Employee;
import com.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * EmployeeController handles employee related requests
 *
 * @author <a href="mailto:amit.kumarn@gmail.com">Amit Kumar</a>
 */
@CrossOrigin(origins = "${cors.url}")
@RestController
@RequestMapping(ServiceConstants.EMPLOYEE_ENDPOINT)
@Slf4j
public class EmployeeController {

	/** The EmployeeRepository service for crud operations. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * This method fetches all employees records
	 * 
	 * @return employeeList response entity of list of employees with status code
	 */
	@GetMapping(ServiceConstants.GET_EMPLOYEE_ENDPOINT)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		log.info("EmployeeController.getAllEmployees()v : start");
		try {
			employeeList = employeeRepository.findAll();
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error occurred in method EmployeeController.getAllEmployees()", e.getMessage());
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method creates new employee record
	 * 
	 * @param employee employee to be created
	 * @return employeeCreated response entity of employee created with status code
	 */
	@PostMapping(ServiceConstants.SAVE_EMPLOYEE_ENDPOINT)
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee employeeCreated = null;
		log.info("EmployeeController.createEmployee() : start");
		try {
			employeeCreated = employeeRepository.save(employee);
			return new ResponseEntity<Employee>(employeeCreated, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error occurred in method EmployeeController.createEmployee()", e.getMessage());
			return new ResponseEntity<Employee>(employeeCreated, HttpStatus.NOT_FOUND);
		}
	}
}
