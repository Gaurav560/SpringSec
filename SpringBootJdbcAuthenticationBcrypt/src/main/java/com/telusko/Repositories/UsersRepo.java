package com.telusko.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telusko.model.User;

@Repository
public class UsersRepo {

 

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${USERS_TABLE}")
    private String USERS_TABLE; // = "USERS";

    @Value("${ROLES_TABLE}")
    private String ROLES_TABLE; // = "AUTHORITIES";

    public List<User> getUsers() {
        List<User> users = jdbcTemplate.query("SELECT * FROM " + USERS_TABLE, BeanPropertyRowMapper.newInstance(User.class));
 
        return users;
    }  

}
