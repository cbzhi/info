package com.cbz.info.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test1 {
	
	@Value("${title}")
	private String title ;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String info(){
		System.out.println("title"+title);
		return title;
		
	}
	
}
