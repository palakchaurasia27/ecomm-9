package com.webservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private long userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userEmail")
	private String userEmail;
	
	@Column(name="userPwd")
	private String userPwd;
	
	@Column(name="userRole")
	private String userRole;
	
	
	
	@ManyToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
	@JoinTable(name="user_products_cart", joinColumns=@JoinColumn(name="userId"),
	inverseJoinColumns=@JoinColumn(name="productId"))
	private List<Product> cart;

	/*@OneToOne(targetEntity=Crt.class,cascade=CascadeType.ALL)
	@JoinTable(name="user_crt", joinColumns=@JoinColumn(name="userId"),
	inverseJoinColumns=@JoinColumn(name="cId"))
	private Crt crt;
	*/


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(long userId, String userName, String userEmail, String userPwd, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userRole = userRole;
	}


	public User(String userName, String userEmail, String userPwd, String userRole) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userRole = userRole;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPwd=" + userPwd
				+ ", userRole=" + userRole + ", cart=" + cart+ "]";
	}


	public List<Product> getCart() {
		return cart;
	}


	public void setCart(List<Product> cart) {
		this.cart = cart;
	}




	
	
	
	
	

}
