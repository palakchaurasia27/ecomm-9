package com.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")
	private long productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productDesc")
	private String productDesc;
	
	@Column(name="productColour")
	private String productColour;
	
	@Column(name="productSize")
	private String productSize;
	
	@Column(name="productPrice")
	private double productPrice;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Product(long productId, String productName, String productDesc, String productColour, String productSize,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productColour = productColour;
		this.productSize = productSize;
		this.productPrice = productPrice;
	}


	

	public Product(String productName, String productDesc, String productColour, String productSize,
			double productPrice) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productColour = productColour;
		this.productSize = productSize;
		this.productPrice = productPrice;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductColour() {
		return productColour;
	}

	public void setProductColour(String productColour) {
		this.productColour = productColour;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productColour=" + productColour + ", productSize=" + productSize + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
}