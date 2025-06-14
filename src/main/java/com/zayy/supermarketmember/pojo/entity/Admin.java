package com.zayy.supermarketmember.pojo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Getter
    private Long id;    //id
    private String username;    //用户名
    @JsonIgnore
    private String password;    //密码
    private String name;    //姓名
    private Integer role;   //角色
    private Byte status;    //状态 1-启用 0-禁用
    private LocalDateTime lastLogin;    //最后登录时间
    private LocalDateTime createTime;   //创建时间
    private LocalDateTime updateTime;   //更新时间
}
