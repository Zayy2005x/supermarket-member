package com.zayy.supermarketmember.service;

import com.zayy.supermarketmember.pojo.dto.ProductAddDTO;

public interface ProductService {


    /**
     * 添加商品功能
     * @param productAddDTO
     */
    void addProduct(ProductAddDTO productAddDTO);
}
