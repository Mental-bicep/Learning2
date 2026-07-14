package com.ec.mp2.cntroller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ec.mp2.repository.CartItem;
import com.ec.mp2.repository.Product;
import com.ec.mp2.service.CartService;
import com.ec.mp2.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
	ProductService productService ;
	@Autowired
	CartService cartService;
	
	@GetMapping("/cart")
	public String viewShoppingCart(HttpSession session, Model model) {
		ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
		if(cart == null) cart = new ArrayList<CartItem>();
		float total = cartService.calculateTotal(cart);
		model.addAttribute("cart",cart);
		model.addAttribute("total", total);
		return "cart";
	}
	
	@PostMapping("/cart/add")
	public String addToCart(@RequestParam("productId") String productId, @RequestParam("quantity") int quantity, HttpSession session ) {
		List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
		if(cart == null) cart = new ArrayList<CartItem>();
		
		Product product = productService.getProductById(productId);
		cart.add(new CartItem(product,quantity));
 
		session.setAttribute("cart", cart);
		return "redirect:/products";
	}
}
