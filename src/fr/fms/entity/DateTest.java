package fr.fms.entity;

public class DateTest {
	private int day, month, year;

	public DateTest(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "[" + this.getDay() + "-" + this.getMonth() + "-" + this.getYear() + "]";
	}
}
