package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@PostMapping("add")
	public void add(@RequestBody Customer c) {
		cs.add(c);
	}

	@PostMapping("add all")
	public void addAll(@RequestBody List<Customer>list) {
		cs.addAll(list);
	}

	@GetMapping("display")
	public List<Customer> display() {
		return cs.display();
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Customer temp=cs.delete(id);
		if(temp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found !!");
		}
		return ResponseEntity.ok(temp);
	}
	@PostMapping("search/mob/{mob}")
	public ResponseEntity<?> searchMob(@PathVariable String mob) {
		Customer temp=cs.findMob(mob);
		if(temp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND..!!");
		}
		return ResponseEntity.ok(temp);
	}
	
}
