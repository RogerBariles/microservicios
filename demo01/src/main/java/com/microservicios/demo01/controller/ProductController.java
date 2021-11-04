package com.microservicios.demo01.controller;

import com.microservicios.demo01.entity.Product;
import com.microservicios.demo01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> listarProducto() {
        List<Product> listProduct = productService.findAll();

        if(listProduct.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(listProduct);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> productById(@PathVariable("id") Integer id) {
        Product productById = productService.findById(id);

        if(productById == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(productById);
    }
}
