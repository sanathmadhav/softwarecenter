package com.wf.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.sc.model.Employee;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

	@RequestMapping(path = "/getEmployee")
	public Employee getEmpDet() {
		return new Employee(10, "Sanath");
	}

}