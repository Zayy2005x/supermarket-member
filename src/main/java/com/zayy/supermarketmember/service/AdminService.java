package com.zayy.supermarketmember.service;


import com.zayy.supermarketmember.common.result.PageResult;
import com.zayy.supermarketmember.pojo.dto.AdminLoginDTO;
import com.zayy.supermarketmember.pojo.dto.AdminPageQueryDTO;
import com.zayy.supermarketmember.pojo.dto.AdminRegisterDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    Admin login(AdminLoginDTO adminLoginDTO);

    /**
     * 新增管理员
     * @param adminRegisterDTO
     */
    void register(AdminRegisterDTO adminRegisterDTO);


    /**
     * 设置管理员状态
     * @param id
     * @param status
     */
    void setStatus(Long id, Byte status);

    /**
     * 分页查询
     * @param adminPageQueryDTO
     * @return
     */
    PageResult page(AdminPageQueryDTO adminPageQueryDTO);

    /**
     * 删除管理员
     * @param id
     */
    void delete(Long id);
}
