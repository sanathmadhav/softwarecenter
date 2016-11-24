package com.wf.sc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wf.sc.to.EmployeeTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

	@ApiOperation(value = "getEmployee", nickname = "getEmployee")
	/*
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(name = "name", value = "User's name", required = false,
	 * dataType = "string", paramType = "query", defaultValue = "Niklas") })
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = EmployeeTO.class) })
	@RequestMapping(method = RequestMethod.GET, path = "/getEmployee")
	public HttpEntity<EmployeeTO> getEmpDet() {
		EmployeeTO employeeTO = new EmployeeTO(10, "Sanath Madhav");
		return new ResponseEntity<EmployeeTO>(employeeTO, HttpStatus.OK);
	}

}