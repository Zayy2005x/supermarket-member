package com.zayy.supermarketmember.mapper;


import com.zayy.supermarketmember.pojo.entity.Admin;
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
    @Select("SELECT * FROM supermarket_member.admin WHERE username = #{username}")
    Admin getByUserId(Long id);

    /**
     * 新增用户
     * @param admin
     */
    void register(Admin admin);
}
