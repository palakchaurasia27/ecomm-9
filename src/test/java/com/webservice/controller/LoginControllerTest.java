package com.webservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.webservice.entity.Login;
import com.webservice.entity.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Application Test:Login Test")
public class LoginControllerTest {

		@LocalServerPort
		private int randomPort;
		
		@Autowired
		private TestRestTemplate template;
		
		@Test
		@DisplayName("Test :: Admin Login")
	    public void testAdminLogin()
	    {
			
			String url = "http://localhost:"+randomPort+"/api/login";
			Login login = new Login("admin@gmail.com","admin123");
			HttpEntity<Login> requestObj = new HttpEntity<>(login);
			ResponseEntity<String> response = template.postForEntity(url, requestObj, String.class);
			assertNotNull(response.getBody());
			assertEquals("Admin Login Success",response.getBody());
			System.out.println(response.getBody());
			assertEquals(HttpStatus.OK , response.getStatusCode());
	    }

		
		
	
}
