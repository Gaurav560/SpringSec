package com.telusko.Repositories;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.telusko.model.Item;

@Repository
public class ItemsRepo {
       
    @Autowired
    private JdbcTemplate jdbcTemplate; 

    @Value("${ITEMS_TABLE}")
    private String ITEMS_TABLE; // = "items";
    
    public List<Item> getItems() {
        return jdbcTemplate.query("SELECT * FROM " + ITEMS_TABLE, BeanPropertyRowMapper.newInstance(Item.class));
    }  
}
