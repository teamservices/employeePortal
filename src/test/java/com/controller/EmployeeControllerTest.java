/**
 * Created on Jun 08, 2021 
 */
package com.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.model.Employee;
import com.repository.EmployeeRepository;

/**
 * EmployeeControllerTest test class for EmployeeController
 *
 * @author <a href="mailto:amit.kumar@gmail.com">Amit Kumar</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	
	/** The EmployeeController mock. */
	@InjectMocks
	private EmployeeController employeeControllerMock;

	/** The EmployeeRepository mock. */
	@Mock
	private EmployeeRepository employeeRepositoryMock;

	/** The Employee list mock. */
	private List<Employee> empList;

	/** The setup method to initlialise data required for test methods. */
	@Before
	public void setUp() {
		empList = new ArrayList<>();
		Employee emp = new Employee(1l,"John","Wick","Male","Logistics");
		empList.add(emp);
		when(employeeRepositoryMock.findAll()).thenReturn(empList);
	}

  /** The test method to check employee fetch functionality */
  @Test
  public void testGetListOfEmployee() {
    // Given
       //setUp
    // When
    ResponseEntity<List<Employee>> response = employeeControllerMock.getAllEmployees();
    // Then
    verify(employeeRepositoryMock, times(1)).findAll();
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody(), hasSize(1));
  }

  /** The test method to check employee fetch functionality exception case*/
  @Test
  public void testGetListOfEmployeeException() {
    // Given
	when(employeeRepositoryMock.findAll()).thenThrow(Exception.class);
    // When
    ResponseEntity<List<Employee>> response = employeeControllerMock.getAllEmployees();
    // Then
    verify(employeeRepositoryMock, times(1)).findAll();
    assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
    assertThat(response.getBody(), hasSize(1));
  }
}