package com.webservice.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entity.Login;
import com.webservice.entity.User;
import com.webservice.exceptions.AuthenticationFailedException;
import com.webservice.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class LoginController {
	HttpSession session;

	@Autowired
	UserRepository userRepo;

	@PostMapping("/login")
	public String login(@RequestBody Login login, HttpServletRequest request) {
		if (session == null) {

			if (login.getEmail().equals("admin@gmail.com") && login.getPassword().equals("admin123")) {
				session = request.getSession(true);
				session.setAttribute("role", "admin");
				if (session != null) {
					return "Admin Login Success";
				}
				else {
					throw new AuthenticationFailedException("Admin Login Failed");
				}
			}
			else {
				String userEmail = login.getEmail();
				String password = login.getPassword();
				List<User> users = userRepo.findAll();
				for (User u : users) {
					if (u.getUserEmail().equals(userEmail)) {
						if (u.getUserPwd().equals(password)) {
							session = request.getSession(true);
							session.setAttribute("role", "user");
							session.setAttribute("id", u.getUserId());
							return "User Login Success";
						}
						else {
							throw new AuthenticationFailedException("Invalid User Creds");
						}
					}
				}
			}
			throw new AuthenticationFailedException("Invalid User Credentials");
		}
		else {
			return "Already Logged In";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
			session = null;
			return "Logged Out";
		}
		else {
			return "Login First";
		}
		
	}

	@PostMapping("/signup")
	public User signUp(@RequestBody User user) {
		return userRepo.save(user);
	}
}