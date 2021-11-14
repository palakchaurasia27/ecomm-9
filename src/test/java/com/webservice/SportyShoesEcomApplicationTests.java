package com.webservice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.webservice.controller.HomeController;
import com.webservice.controller.ProductController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Application Test:Main Test")
//@TestInstance(Lifecycle.PER_CLASS)
class Phase3SpringEcomWebserviceApplicationTests {

	@Autowired
	private HomeController controller;
	
	@LocalServerPort
	private int randomPort;
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	@DisplayName("Test:Load Application Context ")
	void contextLoads() {
	assertNotNull(controller);
	}

	@Test
	@DisplayName("Test:Server Running Test")
    void testForRunningServer()
    {
		String url="http://localhost:"+randomPort+"/";
    ResponseEntity<String> response=template.getForEntity(url, String.class);
    assertEquals(200,response.getStatusCodeValue());  
    assertEquals("Server is up & running !",response.getBody());
        
    }
	
	
	
	
}