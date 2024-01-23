package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.entity.AuthRequest;
import com.telusko.entity.UserInfo;
import com.telusko.service.JwtService;
import com.telusko.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	
	@Autowired
	private UserInfoService userInfoService;
 
    @Autowired	
	private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to spring security tutorials";
	}
	
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserInfo userInfo) {
	return userInfoService.addUser(userInfo);
	}
	
	
	@PostMapping("/login")
	public String addUser(@RequestBody AuthRequest authRequest) {
Authentication authenticate= authenticationManager
			.authenticate
			(new UsernamePasswordAuthenticationToken
					(authRequest.getUserName(), authRequest.getPassword()));

if (authenticate.isAuthenticated()) {
		return jwtService.generateToken(authRequest.getUserName());
	
}
else {
	throw new UsernameNotFoundException("Invalid User Request");
}
	}
	
	
	@GetMapping("/getUsers")
	public List<UserInfo> getAllUsers(){
		return userInfoService.getAllUser();
		
		
	}
	
	
	@GetMapping("/getUser/{id}")
	public UserInfo getAllUsers(@PathVariable Integer id){
		return userInfoService.getUser(id);
		
		
	}
	
	
}






