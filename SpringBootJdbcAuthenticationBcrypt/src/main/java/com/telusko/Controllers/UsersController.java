package com.telusko.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Repositories.UsersRepo;
import com.telusko.model.User;

@RestController
public class UsersController {

    @Autowired
    private UsersRepo repo;
    
    	@GetMapping("/users")
    	public List<User> getUsers() {
    	    return repo.getUsers();
    	}
        
    }

