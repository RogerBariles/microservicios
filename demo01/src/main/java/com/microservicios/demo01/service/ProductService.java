package com.microservicios.demo01.service;

import com.microservicios.demo01.entity.Categoria;
import com.microservicios.demo01.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> findAll();
    public Product findById(Integer id);
    public Product create(Product product);
    public Product update(Product product);
    public  void delete(Product product);
    public List<Product> findByCategory(Categoria categoria);
    public void updateStock(Product product, Integer quantity, String estado);
}
