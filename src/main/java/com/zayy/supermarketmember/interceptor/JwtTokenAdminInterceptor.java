package com.zayy.supermarketmember.interceptor;

import com.zayy.supermarketmember.common.constant.JwtClaimsConstant;
import com.zayy.supermarketmember.common.context.BaseContext;
import com.zayy.supermarketmember.common.properties.JwtProperties;
import com.zayy.supermarketmember.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源方法
        if(!(handler instanceof HandlerMethod)){
            //当前拦截到的不是动态方法,直接放行
            return true;
        }

        //从请求头中获得令牌
        String token = request.getHeader(jwtProperties.getAdminTokenName());

        //校验令牌
        try {
            log.info("jwt校验:{}",token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            Long adminId = Long.valueOf(claims.get(JwtClaimsConstant.ADMIN_ID).toString());
            log.info("当前管理员id:{}",adminId);
            //通过放行
            BaseContext.setCurrentId(adminId);
            return true;
        } catch (Exception e) {
            //不通过 相应401状态码
            response.setStatus(401);
            return false;
        }
    }
}
