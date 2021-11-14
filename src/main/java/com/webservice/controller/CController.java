/*package com.webservice.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entity.User;
import com.webservice.entity.Crt;

import com.webservice.entity.Product;

import com.webservice.repository.UserRepository;
import com.webservice.repository.ProductRepository;
import com.webservice.exceptions.AuthenticationFailedException;
import com.webservice.exceptions.InvalidProductException;
import com.webservice.exceptions.ProductNotFoundException;

@RestController
@RequestMapping("/api/user")
public class CController {


	HttpSession session;
	
	@Autowired
	UserRepository uRepo;
	@Autowired
	ProductRepository pRepo;
	
	@GetMapping("/crt")
	public Crt getCartProducts(HttpServletRequest request){
		session = request.getSession(false);
		if(session!=null && session.getAttribute("role").equals("user")) {
			long userId = (long) session.getAttribute("id");
			User user = uRepo.findById(userId).get();
			
			return user.getCrt();
		}
		else {
			
		throw new AuthenticationFailedException("User is not authenticated");
		}
	}
	
	@PostMapping("/crt/addtoproduct/{productId}")
	public User addToCart(@PathVariable long productId, HttpServletRequest request) {
		session = request.getSession(false);
		if(session!=null && session.getAttribute("role").equals("user")) {
			long userId = (long) session.getAttribute("id");
			User user = uRepo.findById(userId).get();
			Product p = pRepo.findById(productId).get();
			Crt crt=new Crt();
			
			if(p!=null) {
				List<Product> products = user.getProducts();
				products.add(p);
				crt.setProducts(products);
				user.setCrt(crt);
				return uRepo.save(user);
			}
			
			else {
			  throw new ProductNotFoundException("Product with the id does not exist");
			}
		}
		else {
	         
			throw new AuthenticationFailedException("User is not authenticated");
		}
	}
	
}

*/