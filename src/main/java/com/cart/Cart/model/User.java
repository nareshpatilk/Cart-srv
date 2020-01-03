package com.cart.Cart.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="user",  schema = "public")
public class User {

	@Id
	@Column(name= "userId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long userId;
    
	@Column(name= "userName")
	String userName;
    
	@Email
	@Column(name= "userEmail")
    String userEmail;
	
	@Column(name= "password")
    String password;
	
	@Column(name = "insdTime", columnDefinition = "timestamp with time zone not null")
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	Date insdTime;
	
	@Column(name = "updTime", columnDefinition = "timestamp with time zone not null")
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	Date updTime;
	
    @Column(name= "activeFlag", columnDefinition = "boolean default true", nullable = false)
    Boolean activeFlag = true;
    
    public User() {
    }

	public User(Long userId, String userName, @Email String userEmail, Date insdTime, Date updTime,
			Boolean activeFlag,  String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.insdTime = insdTime;
		this.updTime = updTime;
		this.activeFlag = true;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getInsdTime() {
		return updTime;
	}

	public void setInsdTime(Date insdTime) {
		this.insdTime = insdTime;
	}
	
	public Date getUpdTime() {
		return insdTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
