package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

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
