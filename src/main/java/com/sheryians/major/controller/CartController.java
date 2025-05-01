package com.sheryians.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.global.GlobalDara;
import com.sheryians.major.model.Order;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.ProductService;

@Controller
public class CartController {
	@Autowired
	ProductService productService;
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		GlobalDara.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}
	@GetMapping("/cart")
	public String cartGet(Model model) {
		model.addAttribute("cartCount",GlobalDara.cart.size());
		model.addAttribute("total",GlobalDara.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart",GlobalDara.cart);
		return "cart";
	}
	@GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
   	 GlobalDara.cart.remove(index);
   	 return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkOut(Model model) {
    	model.addAttribute("total",GlobalDara.cart.stream().mapToDouble(Product::getPrice).sum());
    	return "checkout";
    }
    @GetMapping("/cart/checkout")
    public String checkoutPage(Model model) {
        model.addAttribute("order", new Order());
        return "checkout"; // your HTML file
    }
}
