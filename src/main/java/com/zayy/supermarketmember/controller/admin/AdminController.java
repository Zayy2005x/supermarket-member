package com.zayy.supermarketmember.controller.admin;


import com.zayy.supermarketmember.common.constant.JwtClaimsConstant;
import com.zayy.supermarketmember.common.properties.JwtProperties;
import com.zayy.supermarketmember.common.result.PageResult;
import com.zayy.supermarketmember.common.result.Result;
import com.zayy.supermarketmember.common.utils.JwtUtil;
import com.zayy.supermarketmember.mapper.AdminMapper;
import com.zayy.supermarketmember.pojo.dto.AdminLoginDTO;
import com.zayy.supermarketmember.pojo.dto.AdminPageQueryDTO;
import com.zayy.supermarketmember.pojo.dto.AdminRegisterDTO;
import com.zayy.supermarketmember.pojo.entity.Admin;
import com.zayy.supermarketmember.pojo.vo.AdminVO;
import com.zayy.supermarketmember.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@Api(tags = "管理员相关接口" )
@RestController
@RequestMapping("/admin")
public class    AdminController {

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

    /**
     * 新增管理员(仅限超级管理员可用)
     * @param adminRegisterDTO
     * @return
     */
    @PostMapping("register")
    @ApiOperation("新增管理员接口")
    public Result<String> register(@RequestBody AdminRegisterDTO adminRegisterDTO){
        log.info("新增管理员:{}",adminRegisterDTO);
        adminService.register(adminRegisterDTO);
        return Result.success();
    }


    /**
     * 设置管理员状态
     * @param status
     * @param id
     * @return
     */
    @PutMapping("status/{status}")
    @ApiOperation("管理员状态设置接口")
    public Result<String> setStatus(@PathVariable Byte status,Long id){
        log.info("设置管理员:{},状态:{}",status,id);
        adminService.setStatus(id,status);
        return Result.success();
    }

    /**
     * 删除管理员
     * @return
     */
    @DeleteMapping()
    @ApiOperation("删除管理员接口")
    public Result<String> delete(Long id){
        adminService.delete(id);
        return Result.success();
    }

    /**
     * 管理员分页查询
     * @param adminPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("管理员分页查询")
    public Result<PageResult> page(AdminPageQueryDTO adminPageQueryDTO) {
        log.info("管理员分页查询:{}",adminPageQueryDTO);
        PageResult pageResult = adminService.page(adminPageQueryDTO);
        return Result.success(pageResult);
    }



}
