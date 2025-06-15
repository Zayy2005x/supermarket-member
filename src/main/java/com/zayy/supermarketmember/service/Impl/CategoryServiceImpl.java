package com.zayy.supermarketmember.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zayy.supermarketmember.common.constant.MessageConstant;
import com.zayy.supermarketmember.common.constant.StatusConstant;
import com.zayy.supermarketmember.common.context.BaseContext;
import com.zayy.supermarketmember.common.exception.CategoryDeleteException;
import com.zayy.supermarketmember.common.exception.CategoryExistException;
import com.zayy.supermarketmember.common.result.PageResult;
import com.zayy.supermarketmember.mapper.CategoryMapper;
import com.zayy.supermarketmember.mapper.ProductMapper;
import com.zayy.supermarketmember.pojo.dto.CategoryAddDTO;
import com.zayy.supermarketmember.pojo.dto.CategoryPageQueryDTO;
import com.zayy.supermarketmember.pojo.entity.Category;
import com.zayy.supermarketmember.pojo.entity.Product;
import com.zayy.supermarketmember.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;



    @Override
    /**
     * 新增分类
     */
    public void add(CategoryAddDTO categoryAddDTO) {
        //查询分类名是否已存在
        Category categoryByName = categoryMapper.getByName(categoryAddDTO.getName());
        if(!(categoryByName ==null)){
            //该商品分类已经存在
            throw new CategoryExistException(MessageConstant.CATEGORY_EXIST);
        }

        //添加该分类
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddDTO, category);

        Long id = BaseContext.getCurrentId();
        category.setCreateId(id);
        category.setUpdateId(id);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        //设置默认状态 0-禁用
        category.setStatus(StatusConstant.DISABLE);

        categoryMapper.insert(category);
    }

    /**
     * 设置商品分类状态
     * @param status
     * @param id
     */
    @Override
    public void setStatus(Byte status, Long id) {
        Category category = Category.builder()
                .status(status)
                .id(id)
                .build();
        categoryMapper.update(category);
    }

    /**
     * 删除商品分类
     * @param id
     */
    public void delete(Long id) {
        //查询该分类是否有关联商品
        List<Product> list = productMapper.getByCategoryId(id);
        if(!list.isEmpty()){
            //当前分类关联了商品,无法删除
            throw new CategoryDeleteException(MessageConstant.CATEGORY_BE_RELATED_PRODUCT);
        }

        //删除
        categoryMapper.deleteById(id);
    }

    /**
     * 商品分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page= categoryMapper.page(categoryPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
