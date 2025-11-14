package fr.fms.entity;

import java.time.*;

public interface IConsumable {
	public boolean isRipe();
	public boolean isExpired(LocalDate _date);
	public int getDaysRemaining(LocalDate _date);
}
