package com.zayy.supermarketmember.pojo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Byte role;   //角色
    private Byte status;    //状态 1-启用 0-禁用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;    //最后登录时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;   //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;   //更新时间
    private Long createId;  //创建人id
    private Long updateId;  //更新人id
}
