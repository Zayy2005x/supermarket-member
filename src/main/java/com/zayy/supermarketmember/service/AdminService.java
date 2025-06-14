package com.zayy.supermarketmember.service;


import com.zayy.supermarketmember.pojo.dto.AdminLoginDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {
    Admin login(AdminLoginDTO adminLoginDTO);
}
