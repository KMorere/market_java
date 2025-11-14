package fr.fms.entity;

import java.util.LinkedHashMap;

public class Client {
	private String firstName;
	private String lastName;
	private float totalSpent;
	
	private LinkedHashMap<String, Integer> items;
	
	public Client(String _firstName, String _lastName) {
		setFirstName(_firstName);
		setLastName(_lastName);
		
		this.items = new LinkedHashMap<String, Integer>();
	}
	
	public void buy(Shop _shop, String _name, float _quantity) {
		Product product = _shop.getProduct(_name);
		if (product != null) {
			if (_shop.isAvailable(product, _quantity)) {
				_shop.removeProduct(product, (int)_quantity, this);
				totalSpent += _shop.getPrice(product, (int)_quantity);
				
				System.out.println("Buying " + _quantity + " " + _name);
			}
			else
				System.out.println("Not enough "+ _name + " in stock, " + _quantity + " left.");
		}
	}

	//region Get and Set.
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(float totalSpent) {
		this.totalSpent = totalSpent;
	}
	//endregion

	@Override
	public String toString() {
		return this.getLastName() + " " + this.getFirstName();
	}
}
