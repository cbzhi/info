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
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@Valid User user, BindingResult result){
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String loginPost(@Valid User user ,BindingResult result) {
		System.out.println("nihao");
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.toString());
			}
			return "/user/login";
		}
		
		return null;
		
	}
	
	/*@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="密码错误")*/
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute(new User());
		model.addAttribute("cbz", "陈炳展");
		return "redirect:info/user/login";
		 
	}
	
	
	
	@RequestMapping("/test4")
	public ModelAndView test4(ModelAndView view) {
        view.setView(new RedirectView("/info/user/login", false));
        return view;
    }
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="密码错误")
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String register(@RequestPart("pictrue") MultipartFile file ,Model model) throws IllegalStateException, IOException{
		model.addAttribute("cbz", "陈炳展");
		String originalFilename = file.getOriginalFilename();
		File file1 = new File("E:/aa.text");
		file.transferTo(file1);
		System.out.println(originalFilename);
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
