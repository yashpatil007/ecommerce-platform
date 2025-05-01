package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo productRepo;
	public List<Product> getAllProduct(){
		return productRepo.findAll();
	}
	public void addProduct(Product p) {
		productRepo.save(p);
	}
	public void removeProductById(long id) {
		productRepo.deleteById(id);
	}
	public Optional<Product> getProductById(long id){
		return productRepo.findById(id);
	}
	public List<Product> getAllProductByCategoryId(int id){
		return productRepo.findAllByCategory_Id(id);
	}
}

