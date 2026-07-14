package com.ec.mp2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ec.mp2.repository.CartItem;

@Service
public class CartService {
	
	public float calculateTotal(ArrayList<CartItem> cart) {
		float total = 0;
		for(CartItem item: cart) total += item.getTotal();
		return total;
	}
}
