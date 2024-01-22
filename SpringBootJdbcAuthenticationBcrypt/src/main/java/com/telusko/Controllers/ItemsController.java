package com.telusko.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Repositories.ItemsRepo;
import com.telusko.model.Item;

@RestController
public class ItemsController {

    @Autowired
    private ItemsRepo repo;
    
    @GetMapping("/items")
    public List<Item> getItems() {
        return repo.getItems();
    }

    @GetMapping("/freeitems")
    public List<Item> getFreeItems() {
        return repo.getItems();  
    } 
    
    
}
