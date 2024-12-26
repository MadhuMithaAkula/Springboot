package com.sathya.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EmployeeModel {
@Data
@NoArgsConstructor
@AllArgsConstructor

	public class Employee
	{
		private String EId;
		private String Ename;
		private String Department;
		private double Age;
		private int Salary;
	}

}
