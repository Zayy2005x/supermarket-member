package com.zayy.supermarketmember.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;
    private Long categoryId;
    private String name;
    private String image;
    private BigDecimal price;
    private Integer stock;  //数量
    private Byte status;    //状态 0-禁售 1-启售
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createId;
    private Long updateId;
}
