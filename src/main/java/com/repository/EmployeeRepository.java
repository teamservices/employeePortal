/**
 * Created on Jun 08, 2021 
 */
package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Employee;

/**
 * EmployeeRepository repository class for employee
 *
 * @author <a href="mailto:amit.kumarn@gmail.com">Amit Kumar</a>
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
