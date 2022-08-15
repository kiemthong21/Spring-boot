package com.t1shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long productid;
    private String title;
    private String summary;
    private Double price;
    private int discount;
    private int quantity;
    private String thumbnail;
    private SettingDTO category;
}
