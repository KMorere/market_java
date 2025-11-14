package fr.fms.entity;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Market {

	public static void main(String[] args) {
		/*LocalDate date = LocalDate.of(2025, 10, 10);
		
		Fruit fruit = new Fruit("Pomme", 1, "piece", 10, date, 35);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		
		System.out.println("Fruit picked date : " + fruit.getDate().format(dtf));
		System.out.println("Expiration Date   : " + fruit.calculateExpirationDate());
		System.out.println("Days remaining    : " + fruit.getDaysRemaining(LocalDate.of(2025, 11, 10)));*/
		
		Shop shop = new Shop();
		//System.out.println(shop.getProduct("Pomme"));
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Select your name :");
		String[] newName = scan.nextLine().split(" ");
		Client newClient = new Client(newName[0], newName[1]);

		System.out.println("Select a product :");
		String newProduct = scan.nextLine();
		
		if (shop.getProduct(newProduct) != null) {
			System.out.println("Select a quantity :");
			int quantity = scan.nextInt();
			
			newClient.buy(shop, newProduct, quantity);
		}
	}
}
