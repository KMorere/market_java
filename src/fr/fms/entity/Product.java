package fr.fms.entity;

import java.time.*;
import java.util.ArrayList;

public abstract class Product {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	private String name;
	private float price;
	private String amount;
	private int stockQuantity;
	private LocalDate date;
	private int lifespan;
	
	public Product(String _name, float _price, String _amount, int _stockQuantity, LocalDate _date, int _lifespan) {
		this.name = _name;
		this.price = _price;
		this.amount = _amount;
		this.stockQuantity = _stockQuantity;
		this.date = _date;
		this.lifespan = _lifespan;
		
		products.add(this);
	}
	
	public abstract LocalDate calculateExpirationDate();
	
	public void UpdateStock() {
		// TODO : Update the products list after a purchase.
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getLifespan() {
		return lifespan;
	}

	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getDate();
	}
}
