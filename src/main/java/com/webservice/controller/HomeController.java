package com.webservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(value="/")
	public String indexMapping() {
		return "Server is up & running !";
	}
	
	@GetMapping(value="/hi")
	public String hiMapping() {
		return "Hi all, Today is good day!";
	}
	
	@GetMapping(value="/hello")
	public String helloMapping(@RequestParam("name") String name) {
		return "Hello user , "+name ;
	}
	
	@GetMapping(value="/message")
	public String messageMapping(@RequestParam("message") String message) {
		return "Hello user , "+message ;
	}
	
	@GetMapping(value="/message/{id}")
	public String msgMapping(@PathVariable("id") int id) {
		if(id==1001) {
			return "Message of Id "+id;
		}
		return "No Message found !";
	}
	
	 @RequestMapping(value = {  "/index" }, method = RequestMethod.GET)
	    public String index(Model model) {

	        String message = "Hello Spring Boot + JSP";

	        model.addAttribute("message", message);

	        return "index";
	    }
	 @RequestMapping(value = {  "/list-products" }, method = RequestMethod.GET)
	    public String listProducts(Model model) {

	        String message = "Hello Spring Boot + JSP";

	        model.addAttribute("message", message);

	        return "list-products";
	    }
	 @RequestMapping(value = {  "/add-product" }, method = RequestMethod.GET)
	    public String addProduct(Model model) {

	        String message = "Hello Spring Boot + JSP";

	        model.addAttribute("message", message);

	        return "add-product";
	    }
	
	 
}
