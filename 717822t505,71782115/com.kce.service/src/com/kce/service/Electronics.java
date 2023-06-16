package com.kce.service;

public class Electronics {
		class Electronics extends Product {
		    private String brand;
		    public Electronics(int id, String name, double price, int stock, String brand) {
		        super(id, name, price, stock);
		        this.brand = brand;
		    }
		    @Override
		    public double calculateTotalValue() {
		        return price * stock;
		    }
		}
		class StockShortageException extends Exception {
		    public StockShortageException(String message) {
		        super(message);
		    }
		}
}
