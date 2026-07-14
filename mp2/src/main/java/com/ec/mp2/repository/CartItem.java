package com.ec.mp2.repository;

public class CartItem {
	Product product;
	int quantity;
	float total;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + ", total=" + total + "]";
	}
	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.total = quantity * product.price;
	}
	
	
}
