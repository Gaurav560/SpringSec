package com.telusko.restController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class UserController {

	  @RequestMapping(path = {"/api", "/api/"})
	    public String testPublicAccess() {
	        return "public";
	    }

	    @RequestMapping(path = {"/api/user", "/api/user/"})
	    public String testUserAccess() {
	        return "user";
	    }

	    @RequestMapping(path = {"/api/admin", "/api/admin/"})
	    public String testAdminAccess() {
	        return "admin";
	    }
	
	
}

