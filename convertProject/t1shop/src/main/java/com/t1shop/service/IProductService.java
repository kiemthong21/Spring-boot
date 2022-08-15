package com.t1shop.service;

import com.t1shop.dto.ProductDTO;
import com.t1shop.model.Product;

public interface IProductService {
    //get all 

    //covert Entity to DTO
    ProductDTO maptoDTO(Product product);

    //convert DTO to Entity
    Product maptoEntity(ProductDTO productDTO);
}
