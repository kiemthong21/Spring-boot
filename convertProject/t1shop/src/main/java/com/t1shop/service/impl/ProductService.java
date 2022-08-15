package com.t1shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.t1shop.dto.ProductDTO;
import com.t1shop.model.Product;
import com.t1shop.repository.ProductRepository;
import com.t1shop.service.IProductService;

public class ProductService implements IProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
   
    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO maptoDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    @Override
    public Product maptoEntity(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return product;
    }
    
}
