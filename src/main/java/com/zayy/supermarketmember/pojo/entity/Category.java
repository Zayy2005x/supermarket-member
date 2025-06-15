package com.zayy.supermarketmember.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 产品分类表
 */
public class Category {
    private Long id;
    private String name;
    private String description;
    private String icon;
    private Byte status;    //0-禁用 1-启用
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createId;
    private Long updateId;
}
