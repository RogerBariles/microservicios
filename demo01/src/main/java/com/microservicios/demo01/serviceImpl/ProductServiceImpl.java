package com.microservicios.demo01.serviceImpl;

import com.microservicios.demo01.entity.Categoria;
import com.microservicios.demo01.entity.Product;
import com.microservicios.demo01.repository.ProductRepository;
import com.microservicios.demo01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

     @Autowired
     private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        product.setEstado("CREATE");
        product.setCreateAt(new Date());
        product.setModifications(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {

        Product productExist = findById(product.getId());

        if(productExist == null) return null;

        productExist.setName(product.getName());
        productExist.setModifications(new Date());
        productExist.setCategoria(product.getCategoria());
        productExist.setDescripcion(product.getDescripcion());
        productExist.setPrecio(product.getPrecio());

        return productRepository.save(productExist);
    }

    @Override
    public void delete(Product product) {
        Product productExist = findById(product.getId());

        if(productExist == null) return;

        productExist.setEstado("DELETE");
        productRepository.save(productExist);
        return;
    }

    @Override
    public List<Product> findByCategory(Categoria categoria) {
        return productRepository.findByCategoria(categoria);
    }

    @Override
    public void updateStock(Product product, Integer quantity, String estado) {
        Product productExist = findById(product.getId());

        if(productExist == null) return;

        Integer stock = estado.equals("add") ? productExist.getStock() - quantity : productExist.getStock() + quantity;
        productExist.setStock(stock);
        productRepository.save(productExist);
        return ;
    }
}
