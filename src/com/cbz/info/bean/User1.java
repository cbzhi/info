package com.cbz.info.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.support.ResourceBundleMessageSource;

public class User1 {
	
	@NotNull
	@Size(min=6,max=20)
	protected String username ;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}
