package com.microservicios.demo01.repository;

import com.microservicios.demo01.entity.Categoria;
import com.microservicios.demo01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByCategoria(Categoria categoria);
}
