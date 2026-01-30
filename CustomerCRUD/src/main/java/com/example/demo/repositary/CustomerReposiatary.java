package com.example.demo.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
@Repository
public interface CustomerReposiatary extends JpaRepository<Customer, Integer> {

	Customer findByMob(String mob);
}
