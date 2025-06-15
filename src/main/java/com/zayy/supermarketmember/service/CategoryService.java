package com.zayy.supermarketmember.service;

import com.zayy.supermarketmember.common.result.PageResult;
import com.zayy.supermarketmember.pojo.dto.CategoryAddDTO;
import com.zayy.supermarketmember.pojo.dto.CategoryPageQueryDTO;

public interface CategoryService {

    /**
     * 新增商品分类
     * @param categoryAddDTO
     */
    void add(CategoryAddDTO categoryAddDTO);

    /**
     * 设置商品分类状态
     * @param status
     * @param id
     */
    void setStatus(Byte status, Long id);

    /**
     * 删除商品分类
     * @param id
     */
    void delete(Long id);

    /**
     * 商品分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
