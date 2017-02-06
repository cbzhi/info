package com.cbz.info.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cbz.info.exception.InfoNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(InfoNotFoundException.class)
	public String error(){
		return "error";
	}
}
