package com.zayy.supermarketmember.mapper;


import com.github.pagehelper.Page;
import com.zayy.supermarketmember.pojo.dto.AdminPageQueryDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    /**
     * 根据用户名查询用户
     * @return
     */
    @Select("SELECT * FROM supermarket_member.admin WHERE username = #{username}")
    Admin getByUsername(String username);

    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM supermarket_member.admin WHERE id = #{id}")
    Admin getByUserId(Long id);

    /**
     * 新增用户
     * @param admin
     */
    void register(Admin admin);

    /**
     * 更新管理员信息
     * @param admin
     */
    void update(Admin admin);

    /**
     * 分页查询
     * @param adminPageQueryDTO
     * @return
     */
    Page<Admin> page(AdminPageQueryDTO adminPageQueryDTO);

    /**
     * 根据id删除管理员
     * @param id
     */
    @Delete("DELETE FROM supermarket_member.admin WHERE id=#{id}")
    void deleteById(Long id);
}
