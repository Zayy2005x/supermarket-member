package com.zayy.supermarketmember.service.Impl;

import com.zayy.supermarketmember.common.constant.MessageConstant;
import com.zayy.supermarketmember.common.constant.StatusConstant;
import com.zayy.supermarketmember.common.exception.AccountLockedException;
import com.zayy.supermarketmember.common.exception.AccountNotExistException;
import com.zayy.supermarketmember.common.exception.PasswordWrongException;
import com.zayy.supermarketmember.mapper.AdminMapper;
import com.zayy.supermarketmember.pojo.dto.AdminLoginDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import com.zayy.supermarketmember.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
