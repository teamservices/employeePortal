/**
 * Created on Jun 08, 2021 
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Employee model class for employee
 *
 * @author <a href="mailto:amit.kumarn@gmail.com">Amit Kumar</a>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

	/** Attribute employee id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** Attribute employee firstName. */
	@Column(name = "first_name", nullable = false)
	private String firstName;

	/** Attribute employee lastName. */
	@Column(name = "last_name", nullable = false)
	private String lastName;

	/** Attribute employee gender. */
	@Column(name = "gender", nullable = false)
	private String gender;

	/** Attribute employee department. */
	@Column(name = "department", nullable = false)
	private String department;

	/** To string method */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", department=" + department + "]";
	}
}
