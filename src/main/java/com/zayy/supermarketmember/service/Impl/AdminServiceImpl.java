package com.zayy.supermarketmember.service.Impl;

import com.zayy.supermarketmember.common.constant.MessageConstant;
import com.zayy.supermarketmember.common.constant.RoleConstant;
import com.zayy.supermarketmember.common.constant.StatusConstant;
import com.zayy.supermarketmember.common.context.BaseContext;
import com.zayy.supermarketmember.common.exception.*;
import com.zayy.supermarketmember.mapper.AdminMapper;
import com.zayy.supermarketmember.pojo.dto.AdminLoginDTO;
import com.zayy.supermarketmember.pojo.dto.AdminRegisterDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import com.zayy.supermarketmember.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(AdminLoginDTO adminLoginDTO) {
        String username = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();

        Admin admin = adminMapper.getByUsername(username);

        if(admin == null){
            //账号不存在
            throw new AccountNotExistException(MessageConstant.ACCOUNT_NOT_EXIST);
        }



        //核对密码是否正确
        //TODO 后续改为使用MD5加密登录
        if(!admin.getPassword().equals(password)){
            //密码错误
            throw new PasswordWrongException(MessageConstant.PASSWORD_WRONG);
        }

        //校验状态是否启用
        if(Objects.equals(admin.getStatus(), StatusConstant.DISABLE)){
            //状态为0,返回 账户被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }
        //密码正确
        return admin;
    }

    /**
     * 新增管理员
     * @param adminRegisterDTO
     */
    @Override
    public void register(AdminRegisterDTO adminRegisterDTO) {
        //查询权限是否足够
        Long id = BaseContext.getCurrentId();
        //根据id查询操作人信息
        Admin operator = adminMapper.getByUserId(id);
        if (!operator.getRole().equals(RoleConstant.SUPER_ADMINISTRATION)) {
            //不是超级管理员用户
            throw new InsufficientPrivilegesException(MessageConstant.INSUFFICIENT_PRIVILEGES_WRONG);
        }
        //查询用户名是否存在
        Admin adminGetByUsername = adminMapper.getByUsername(adminRegisterDTO.getUsername());

        if(!(adminGetByUsername == null)){
            //用户名已经存在
            throw new AccountExistException(MessageConstant.ACCOUNT_EXIST);
        }

        //确认密码是否一致
        if(!adminRegisterDTO.getPassword().equals(adminRegisterDTO.getConfirmPassword())){
            //两次密码不一致
            throw new RePasswordNotMatchException(MessageConstant.RE_PASSWORD_NOT_MATCH);
        }
        //业务逻辑检验无误,写入数据库
        Admin admin = Admin.builder()
                .username(adminRegisterDTO.getUsername())
                .password(adminRegisterDTO.getPassword())
                .name(adminRegisterDTO.getName())
                .role(RoleConstant.ADMINISTRATION)  //权限设置为管理员
                .status(StatusConstant.DISABLE) //状态默认为禁用
                .lastLogin(LocalDateTime.now())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .updateId(id)
                .createId(id)
                .build();

        //写入数据库
        adminMapper.register(admin);
    }
}
