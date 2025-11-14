package fr.fms.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Shop {
	private ArrayList<Product> products = new ArrayList<Product>(
			Arrays.asList(new Fruit("Pomme", 1, "piece", 10, LocalDate.of(2025, 10, 10), 12),
					new Fruit("Orange", 1, "piece", 10, LocalDate.of(2025, 10, 10), 12)
					));
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	private float money;
	
	public float getPrice(Product _product, int _amount) {
		float price = _product.getPrice();
		price *= _amount;
		
		return price;
	}
	
	public boolean isAvailable(Product _product, float _quantity) {
		return _quantity <= _product.getStockQuantity();
	}
	
	public Product getProduct(String _name) {
		Map<String, Product> sortedProducts = products.stream()
				.collect(Collectors.toMap(Product::getName, Function.identity()));
		
		return sortedProducts.get(_name);
	}
	
	public void removeProduct(Product _product, int _quantity, Client _client) {
		_product.setStockQuantity(_product.getStockQuantity() - _quantity);
		setEarnings(_product, _quantity, _client);
	}
	
	public void setEarnings(Product _product, int _amount, Client _client) {
		this.money += getPrice(_product, _amount);
		if (!clients.contains(_client))
			clients.add(_client);
	}
}
