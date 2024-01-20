package com.telusko.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankRestController {
@GetMapping("/")
	public String welcomePage() {
		return "Welcome to ICICI Bank";
	}
@GetMapping("/transfer")
public String fundTransfer() {
	return "Fund Transfer Initiated";
	
}

@GetMapping("/balance")
public String checkBalance() {
	return "balance amount is 100000 INR";
}

@GetMapping("/about")
public String aboutUs() {
	return "ICICI bank is managed by Indian Central Government";
}
	

}
