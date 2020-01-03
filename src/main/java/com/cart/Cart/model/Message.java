package com.cart.Cart.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long message_id;
	String message;
	Date insdtime;
	Date upddtime;
	
	public Message() {
		
	}
	
	public Message(Long message_id, String message, Date insdtime, Date upddtime) {
		super();
		this.message_id = message_id;
		this.message = message;
		this.insdtime = insdtime;
		this.upddtime = upddtime;
	}
	public Long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getInsdtime() {
		return insdtime;
	}
	public void setInsdtime(Date insdtime) {
		this.insdtime = insdtime;
	}
	public Date getUpddtime() {
		return upddtime;
	}
	public void setUpddtime(Date upddtime) {
		this.upddtime = upddtime;
	}
	
	
}
