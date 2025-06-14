package com.zayy.supermarketmember.controller;


import com.zayy.supermarketmember.common.constant.JwtClaimsConstant;
import com.zayy.supermarketmember.common.properties.JwtProperties;
import com.zayy.supermarketmember.common.result.Result;
import com.zayy.supermarketmember.common.utils.JwtUtil;
import com.zayy.supermarketmember.pojo.dto.AdminLoginDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import com.zayy.supermarketmember.pojo.vo.AdminVO;
import com.zayy.supermarketmember.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@Api(tags = "管理员相关接口" )
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @GetMapping("/login")
    @ApiOperation("管理员登录接口")
    public Result<AdminVO> login(@RequestBody AdminLoginDTO adminLoginDTO){
        log.info("管理员登录:{}",adminLoginDTO);
        Admin admin = adminService.login(adminLoginDTO);
        //登录成功,生成JWT令牌
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ADMIN_ID, admin.getId());
        String jwt = JwtUtil.createJWT(jwtProperties.getAdminSecretKey(), jwtProperties.getAdminTtl(), claims);

        AdminVO adminVO = AdminVO
                .builder()
                .id(admin.getId())
                .name(admin.getName())
                .token(jwt)
                .build();
        return Result.success(adminVO);
    }
}
