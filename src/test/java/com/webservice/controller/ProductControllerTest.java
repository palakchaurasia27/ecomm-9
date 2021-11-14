package com.webservice.controller;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.webservice.entity.Product;





import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Application Test:Main Test")
public class ProductControllerTest {
	
	@LocalServerPort
	private int randomPort;
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	@DisplayName("Test :: List All Products")
    public void testGetAllProducts()
    {
		
		String url="http://localhost:"+randomPort+"/api/admin/products";
		//get all products
	    ResponseEntity<List> response=template.getForEntity(url,List.class);
	
	    assertEquals(200,response.getStatusCodeValue());  
	    //assertEquals(false,response.getBody().isEmpty());
	    System.out.println(response.getBody());
    }

	@Test
	@DisplayName("Test :: List one Products")
    public void testGetOneProduct()
    {
		
		String url="http://localhost:"+randomPort+"/api/admin/products/3";
		
		//get one products
	    ResponseEntity<Product> response=template.getForEntity(url,Product.class);
	
	    assertEquals(200,response.getStatusCodeValue());  
	    assertNotNull(response.getBody());
	    assertEquals(3,response.getBody().getProductId()); 
	    assertEquals("Nike",response.getBody().getProductName()); 
	    System.out.println(response.getBody());
    }
	
	@Test
	@DisplayName("Test :: get one product which does not exist")
    public void testGetOneProductNotExists()
    {
		
		String url="http://localhost:"+randomPort+"/api/products/1200";
		
		//get one products
	    ResponseEntity<Product> response=template.getForEntity(url,Product.class);
	
	    assertEquals(404,response.getStatusCodeValue());  
	   
    }
	
	
	@Test
	@DisplayName("Test ::Add one Product")
    public void testAddOneProduct()
    {
		
		String url="http://localhost:"+randomPort+"/api/admin/products";
		//create product object
		Product product=new Product("Puma","PM87","Purple","UK6",4200);
			//Http request entity object
		HttpEntity<Product> requestObj=new HttpEntity<>(product);
		//add one product
		   ResponseEntity<Product> response=template.postForEntity(url,requestObj,Product.class);
		
	    assertEquals(200,response.getStatusCodeValue());  
	    assertNotNull(response.getBody());
	    //assertEquals(9,response.getBody().getProductId()); 
	    assertEquals("Puma",response.getBody().getProductName()); 
	    System.out.println(response.getBody());
    }
	
	@Test
	@DisplayName("Test ::Add one null Product")
    public void testAddOneNullProduct()
    {
		String url="http://localhost:"+randomPort+"/api/admin/products";
		//create product object
		Product product=null;
		//Http request entity object
		HttpEntity<Product> requestObj=new HttpEntity<>(product);
		//add one product
		   ResponseEntity<Product> response=template.postForEntity(url,requestObj,Product.class);
		
	    assertEquals(415,response.getStatusCodeValue());  
	    
}
	//update(2) and delete(2)
	//update-postforentity
	//delete-getforentity(getonebyid)
	//update,delete a product which exist 
	//update,delete a product which does not exist
} 

