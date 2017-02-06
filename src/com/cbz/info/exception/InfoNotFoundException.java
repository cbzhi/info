package com.cbz.info.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="密码错误")
public class InfoNotFoundException extends RuntimeException {

}
