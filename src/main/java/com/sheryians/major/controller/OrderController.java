package com.sheryians.major.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sheryians.major.model.Order;
import com.sheryians.major.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/payNow")
    public String submitOrder(@ModelAttribute Order order, Model model) {
        
        Order savedOrder = orderService.saveOrder(order);
        Map<String, String> orderDetails = new HashMap<>();
        orderDetails.put("Customer Name", savedOrder.getFirstName() + " " + savedOrder.getLastName());
        orderDetails.put("Shipping Address", savedOrder.getAddressLine1() + ", " + savedOrder.getCity());
        orderDetails.put("Total Amount", "₹" + savedOrder.getTotalAmount());
        orderDetails.put("Order Date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")));
        model.addAttribute("order", savedOrder);
        model.addAttribute("parameters", orderDetails);
        model.addAttribute("orderId", "ORD-" + savedOrder.getId());
        return "orderPlaced";
    }

    @GetMapping("/order/checkout")
    public String checkoutPage(Model model) {
        model.addAttribute("order", new Order());
        return "checkout";
    }
    
    @GetMapping("/orderPlaced")
    public String orderPlaced() {
        return "orderPlaced"; // Create this view
    }
//    @GetMapping("/orderConfirmation")
//    public String showConfirmation(Model model) {
//        Map<String, String> orderDetails = new HashMap<>();
//        orderDetails.put("Customer Name", "John Doe");
//        orderDetails.put("Total Amount", "$100.00");   
//        model.addAttribute("parameters", orderDetails);
//        model.addAttribute("orderId", "ORD-123456");
//        return "orderPlaced";
//    }
}
