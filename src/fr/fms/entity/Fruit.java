package fr.fms.entity;

import java.time.*;

public class Fruit extends Product implements IConsumable {
	public Fruit(String _name, float _price, String _amount, int _stockQuantity, LocalDate _date, int _lifespan) {
		super(_name, _price, _amount, _stockQuantity, _date, _lifespan);
	}
	
	@Override
	public LocalDate calculateExpirationDate() {
		return this.getDate().plusDays(this.getLifespan());
	}
	
	@Override
	public boolean isRipe() {
		return LocalDate.now().isAfter(this.getDate().plusDays(this.getLifespan()));
	}
	
	@Override
	public boolean isExpired(LocalDate _date) {
		return LocalDate.now().isAfter(_date);
	}
	
	@Override
	public int getDaysRemaining(LocalDate _date) {
		if (isRipe())
			return 0;
		
		int days = 0;
		LocalDate newDate = _date;
		
		while (!newDate.isEqual(this.calculateExpirationDate())) {
			days++;
			newDate = newDate.plusDays(1);
		}
		
		return days;
	}
}
