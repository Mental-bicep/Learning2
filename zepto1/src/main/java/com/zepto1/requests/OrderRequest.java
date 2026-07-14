package com.zepto1.requests;

public class OrderRequest {
	String name;
	String qty;
	String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderRequest [name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
}
