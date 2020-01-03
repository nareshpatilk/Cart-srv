package com.cart.Cart.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.Cart.model.Message;
import com.cart.Cart.services.MessageService;

@RestController
@RequestMapping("/postgressApp/")
public class MessageController {

	@Autowired
	MessageService msgServ;
	
	@RequestMapping("get-message")
	public HashMap<String, Message> getMessage(){
		System.out.println("fetced message");
		HashMap hm = new HashMap<String, Message>();
		hm.put("messages", msgServ.findAll());
		return hm;
	}
}
