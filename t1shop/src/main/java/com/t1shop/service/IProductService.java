package com.t1shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.t1shop.dto.ProductDTO;
import com.t1shop.model.Product;

public interface IProductService {
    // get all product
    ResponseEntity<List<ProductDTO>> getAllProduct(Pageable pageable);

    // get product by condition

    // covert Entity to DTO
    ProductDTO maptoDTO(Product product);

    // convert DTO to Entity
    Product maptoEntity(ProductDTO productDTO);
}
