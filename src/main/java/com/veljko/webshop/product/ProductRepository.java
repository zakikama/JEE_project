package com.veljko.webshop.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByOrderByIdAsc();

    Optional<Product> findTopByOrderByTimesSoldDesc();

    Optional<Product> findTopByOrderByPriceDesc();

    Optional<Product> findTopByOrderByStockDesc();

    Optional<Product> findByName(String name);
}
