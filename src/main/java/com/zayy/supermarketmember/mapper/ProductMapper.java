package com.zayy.supermarketmember.mapper;


import com.zayy.supermarketmember.pojo.entity.Product;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 根据商品名查询商品个数(精确查询)
     * @param name
     * @return
     */
    @Select("SELECT COUNT(*) FROM supermarket_member.product WHERE name=#{name}")
    Long getCountByName(String name);

    /**
     * 添加商品
     * @param product
     */
    @Insert("INSERT INTO supermarket_member.product(category_id, name, image, price, stock, status, create_time, update_time, create_id, update_id) " +
            "VALUES(#{categoryId},#{name},#{image},#{price},#{stock},#{status},#{createTime},#{updateTime},#{createId},#{updateId}) ")
    void insert(Product product);


    void update(Product product);
}
