package com.cbz.info.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User2 extends User1{

	@NotNull
	@Size(min=6,max=20)
	private String password ;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
