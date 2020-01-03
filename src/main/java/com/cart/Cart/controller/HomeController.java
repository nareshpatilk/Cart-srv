package com.cart.Cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.Cart.model.Employee;
import com.cart.Cart.services.EmployeeServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/postgressApp/")
public class HomeController {

	@Autowired
	private EmployeeServices employeeServie;
	
	@GetMapping("get-employee")
	public List<Employee> replyCust() {
		return employeeServie.findAll();
	}
	
	@PostMapping(value = "create-employee")
	public boolean insertEmployee(@RequestBody Employee emp) {
		System.out.println("emp>>>"+ emp);
		System.out.println(employeeServie.save(emp));
		return false;
	}
	
	@GetMapping("get-employee/{empid}")
	public ResponseEntity getEmpployee(@PathVariable(value = "empid") String empid) {
	    HashMap<String, Object> result = new HashMap<>();
	    List<String> emp = employeeServie.findByEmployeeaddressContaining(empid);
	    if(emp == null) {
	    	result.put("error","Not found");
	    	return ResponseEntity.badRequest().body(result);
	    }
	    result.put("emp", emp);
	    result.put("api", "java");
	    return ResponseEntity.ok(result);
	}
	
	
}
