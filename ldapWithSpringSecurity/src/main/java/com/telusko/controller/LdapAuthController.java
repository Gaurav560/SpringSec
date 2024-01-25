package com.telusko.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LdapAuthController {

	@GetMapping("/index")
	public String index() {
		return "<h1>Working with LDAP->Welcome to Telusko Tutorials:</h1>  <a href=\"https://telusko.com/\">Visit Telusko</a>\r\n"
				+ "";
		
	}
}
