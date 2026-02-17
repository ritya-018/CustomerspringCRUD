package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvaslidMovileNumber;
import com.example.demo.model.Customer;
import com.example.demo.repositary.CustomerReposiatary;

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired

	private CustomerReposiatary cr;

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		String mob=customer.getMob().trim();
		
		if(mob.startsWith("+91"))
			mob=mob.substring(3);
		
		if(mob.length()==10) {
			if(mob.charAt(0)=='0'||mob.charAt(0)=='1'||mob.charAt(0)=='2'||mob.charAt(0)=='4'||mob.charAt(0)=='5') {
				throw new InvaslidMovileNumber("INVSLID MOBILE NUMBER..!!");
			}
			for(int i=0;i<mob.length();i++) {
				if(!Character.isDigit(mob.charAt(i)))
					throw new InvaslidMovileNumber("INVALID MOBILE NUMBER..!!");
			}
			
		}else
			throw new InvaslidMovileNumber("INVALID MOBILE NUMBER..!!");
		
//		Integer id=customer.getId();
//		if(cr.existsById(id))
//			throw new InvalidId("Duplicate Id..!!");
//		if(id<=0) {
//			throw new InvalidId("ID Must be positive.!!");
//		}
		
			cr.save(customer);
	}

	@Override
	public List<Customer> display() {
		// TODO Auto-generated method stub
		return cr.findAll();// Select * from customer;
	}

	@Override
	public Customer delete(Integer id) {
		// TODO Auto-generated method stub
		// Search..
		if (cr.findById(id).isPresent()) {
			Customer temp = cr.findById(id).get();
			cr.deleteById(id);// Delete
			return temp;
		}

		return null;
	}

	@Override
	public void update(Customer customer, Integer id) {
		// TODO Auto-generated method stub
		customer.setId(id);
		cr.save(customer);
	}

	@Override
	public Customer search(Integer id) {
		// TODO Auto-generated method stub
		if (cr.findById(id).isPresent()) {
			Customer temp = cr.findById(id).get();
			return temp;
		}

		return null;
	}

	@Override
	public void addAll(List<Customer> list) {
		// TODO Auto-generated method stub
		cr.saveAll(list);
	}

	@Override
	public Customer findMob(String mob) {
		// TODO Auto-generated method stub
		return cr.findByMob(mob);
	}

}
