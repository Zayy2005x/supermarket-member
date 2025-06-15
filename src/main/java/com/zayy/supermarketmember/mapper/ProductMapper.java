package com.zayy.supermarketmember.mapper;


import com.zayy.supermarketmember.pojo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 根据分类id查询商品
     * @param categoryId
     * @return
     */
    @Select("SELECT * FROM supermarket_member.product WHERE category_id =#{categoryId}")
    List<Product> getByCategoryId(Long categoryId);
}
