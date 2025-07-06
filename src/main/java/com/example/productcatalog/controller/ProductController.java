package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home() {
        return "index"; 
    }

    @GetMapping("/add")
    public String showAddProductForm() {
        return "addProduct"; 
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/add?success=true";
    }

    @GetMapping("/display")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "display"; 
    }
}