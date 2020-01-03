package com.cart.Cart.controller;

import java.util.HashMap;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cart.Cart.model.User;
import com.cart.Cart.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/user")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store") 
public class UserController {

	@Autowired
	UserService userService;
	org.jboss.logging.Logger logger = LoggerFactory.logger(this.getClass());
	
	@PostMapping(value ="save")
	public ResponseEntity saveNewUserController(@RequestBody User user) {
		
		
		try {
			HashMap<String, Object>  result = new HashMap<String, Object>();
			HashMap<String, HashMap<String, Object>>  FinalRes = new HashMap<String, HashMap<String, Object>> ();
			long val =  userService.saveUser(user);
			int i = 1/0;
			if(val == 0) {
				
				result.put("error","User already exists");
				logger.info("User already exists hey {{user create controller}}");
				return ResponseEntity.badRequest().body(result);
				
			}else {
				
				 result.put("UserId", val);
			     result.put("api", "java");
			     FinalRes.put("data", result);
			     logger.info("User created succesfully {{user create controller}}");
			     return ResponseEntity.ok(FinalRes);
			     
			}
		}catch (Exception e) {
			logger.error("User already exists {{user create controller})"+ e.getMessage());
		}
		return ResponseEntity.badRequest().body("error");
	}
	
	@ApiOperation(value = "View a list of users products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@PostMapping(value= "sign-in")
	public ResponseEntity signIn(@RequestBody User user){
		HashMap<String, Object>  result = new HashMap<String, Object>();
		try {
			
			User validUser = userService.siginInCheck(user);
			
			if(validUser == null) {
				result.put("error","User not exists");
				logger.info("User not exists {{user controller}}");
				return ResponseEntity.badRequest().body(result);
			}else {
				 result.put("UserId", validUser.getUserId());
			     result.put("api", "java");
			}
			logger.info("User sigin succesfully {{user sigin controller}}");
		    return ResponseEntity.ok(result);
		}catch (Exception e) {
			logger.error("User sigin failed {{user sigin controller})"+ e.getMessage());
		}
		return ResponseEntity.badRequest().body("error");
	}
}
