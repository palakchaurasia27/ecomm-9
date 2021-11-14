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
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name="crt")
	public class Crt {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="cId")
		private long cId;
  
		
		@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
		@JoinTable(name="crt_product", joinColumns=@JoinColumn(name="cId"),
		inverseJoinColumns=@JoinColumn(name="productId"))
		private List<Product> products;


		public Crt() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Crt(long cId, List<Product> products) {
			super();
			this.cId = cId;
			this.products = products;
		}


		public long getcId() {
			return cId;
		}


		public void setcId(long cId) {
			this.cId = cId;
		}


		public List<Product> getProducts() {
			return products;
		}


		public void setProducts(List<Product> products) {
			this.products = products;
		}
		
		
		

	
	}
