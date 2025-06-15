package com.zayy.supermarketmember.mapper;


import com.github.pagehelper.Page;
import com.zayy.supermarketmember.pojo.dto.CategoryPageQueryDTO;
import com.zayy.supermarketmember.pojo.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    /**
     * 根据分类名进行查询
     * @param name
     */
    @Select("SELECT * FROM supermarket_member.category WHERE name=#{name}")
    Category getByName(String name);

    /**
     * 新增分类
     * @param category
     */
    @Insert("INSERT INTO supermarket_member.category(name, description, icon, status, create_time, update_time, create_id, update_id) " +
            "VALUES(#{name},#{description},#{icon},#{status},#{createTime},#{updateTime},#{createId},#{updateId}) ")
    void insert(Category category);


    /**
     * 更新商品分类信息
     * @param category
     */
    void update(Category category);

    /**
     * 根据id删除商品分类
     * @param id
     */
    @Delete("DELETE FROM supermarket_member.category WHERE id=#{id}")
    void deleteById(Long id);

    /**
     * 商品分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);
}
