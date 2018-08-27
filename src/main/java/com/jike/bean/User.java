package com.jike.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.jike.annotation.BetweenAnnotation;

public class User {

	@NotNull(message = "{NotNull.username}")
	private String username;

	@Pattern(regexp = "[0-9a-zA-Z_]{6}", message = "{Pattern.password}")
	private String password;

	@Length(min = 2, max = 10, message = "{Length.realname}")
	private String realname;

	@BetweenAnnotation(min = 18, max = 45)
	@NotNull(message = "{NotNull.age}")
	private Integer age;

	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
