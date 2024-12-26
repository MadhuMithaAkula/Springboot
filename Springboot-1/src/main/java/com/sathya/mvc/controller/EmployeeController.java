package com.sathya.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.mvc.model.EmployeeModel;
@Controller
public class EmployeeController
{
	@GetMapping("/employeeform")
	public String getemployeeform()
	{
		return "add-employee";
	}
	@PostMapping("/savedetails")
	public String savedetails(EmployeeModel res)
	{
		System.out.println(res);
		return "storeddetails";
	}

}
