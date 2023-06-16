package com.kce.service;

public class InventoryManagementSystem {
		    private Connection connection;
		    public InventoryManagementSystem() {
		        try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_inventory", "username", "password");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    public boolean isProductInStock(int productId) throws SQLException {
		        PreparedStatement statement = connection.prepareStatement("SELECT stock FROM products WHERE id = ?");
		        statement.setInt(1, productId);
		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		            int stock = resultSet.getInt("stock");
		            return stock > 0;
		        }
		        return false;
		    }
		    public void updateStock(int productId, int quantity) throws SQLException {
		        PreparedStatement statement = connection.prepareStatement("UPDATE products SET stock = stock - ? WHERE id = ?");
		        statement.setInt(1, quantity);
		        statement.setInt(2, productId);
		        statement.executeUpdate();
		    }
		    public void sellProduct(int productId, int quantity) throws StockShortageException, SQLException {
		        if (!isProductInStock(productId)) {
		            throw new StockShortageException("Product is out of stock.");
		        }
		        updateStock(productId, quantity);
		        System.out.println("Product sold successfully.");
		    }
		}
}
