package com.cbz.info.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cbz.info.bean.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		if(arg0.equals(User.class)) {
			return true ;
		} 
		return false ;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "username", "1000", "用户名不能为空");
		ValidationUtils.rejectIfEmpty(arg1, "password", "1001", "密码不能为空");
	}

}
