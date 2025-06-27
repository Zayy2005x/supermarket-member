package com.zayy.supermarketmember.service.Impl;


import com.zayy.supermarketmember.common.constant.MessageConstant;
import com.zayy.supermarketmember.common.constant.StatusConstant;
import com.zayy.supermarketmember.common.context.BaseContext;
import com.zayy.supermarketmember.common.exception.ProductExistException;
import com.zayy.supermarketmember.mapper.ProductMapper;
import com.zayy.supermarketmember.pojo.dto.ProductAddDTO;
import com.zayy.supermarketmember.pojo.entity.Product;
import com.zayy.supermarketmember.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {



    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加商品接口
     * @param productAddDTO
     */
    public void addProduct(ProductAddDTO productAddDTO) {
//        //查询是否有重复商品
//        Long count = productMapper.getCountByName(productAddDTO.getName());
//        if(count > 0){
//            //商品名已经存在
//            throw new ProductExistException(productAddDTO.getName()+MessageConstant.PRODUCT_EXIST);
//        }

        Product product = new Product();
        BeanUtils.copyProperties(productAddDTO,product );


        product.setStatus(StatusConstant.DISABLE);
        product.setCreateId(BaseContext.getCurrentId());
        product.setUpdateId(BaseContext.getCurrentId());
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());

        productMapper.insert(product);
    }
}
