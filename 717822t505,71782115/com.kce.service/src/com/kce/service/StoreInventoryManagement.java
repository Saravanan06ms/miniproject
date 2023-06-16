package com.kce.service;

public class StoreInventoryManagement {
	public static void main(String[] args) {
		InventoryManagementSystem inventorySystem = new InventoryManagementSystem();
		Electronics laptop = new Electronics(1, "Laptop", 1000.0, 10, "HP");
		try {
			inventorySystem.sellProduct(laptop.getId(), 5);
		    System.out.println("Remaining stock of " + laptop
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
