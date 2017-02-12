package com.cbz.info.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cbz.info.bean.User;
import com.cbz.info.bean.User2;


@Controller
@RequestMapping({"/user","myUser"})
public class UserController {
	
	@GetMapping(value = "/{request}")
	public String getRequest(@PathVariable String request){
		System.out.println("request=="+request);
		return "/user/" + request ;
	}
	
	@PostMapping("/login")
	public String loginPost(@Valid User user ,BindingResult result) {
		if(result.hasErrors()) {
			return "/user/login";
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register(@ModelAttribute("user")User user) {
		return "/user/register";
	}
	
	
	
	@RequestMapping("/test4")
	public ModelAndView test4(ModelAndView view) {
        view.setView(new RedirectView("/info/user/login", false));
        return view;
    }
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String register(@Valid User user ,Model model) throws IllegalStateException, IOException{
		return "/user/register";
	}
	
	@RequestMapping(value="/AdminLogin",method=RequestMethod.POST)
	public String loginForm(@Valid  User2 user, Errors errors){
		System.out.println(user.getUsername()+"----"+user.getPassword());
		if(errors.hasErrors()){
			System.out.println("error");
			return "/user/AdminLogin";
		} else {
			System.out.println("success");
		}
		
		return "/user/login";
	}
	
	/*@ExceptionHandler(Exception.class)
	public void handler(){
		System.out.println("error");
		return "/";
	}*/

}
