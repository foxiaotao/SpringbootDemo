package com.simon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simon.service.ISendMailService;

@Controller
@RequestMapping(value="/mail")
public class JavaMailController {

	
	@Autowired
	private ISendMailService sendMailService;
	
	@RequestMapping(value="/test")
	public void sendMail() {
		System.out.println("test in.......");
		sendMailService.sendMail();
	}
}
