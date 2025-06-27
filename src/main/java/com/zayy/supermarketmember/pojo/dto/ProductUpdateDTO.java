package com.zayy.supermarketmember.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@ApiModel(description = "修改商品信息数据传输模型")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductUpdateDTO {
    @ApiModelProperty("商品分类id")
    private Long categoryId;
    @ApiModelProperty("商品名")
    private String name;
    @ApiModelProperty("图片url")
    private String image;
    @ApiModelProperty("价格")
    private BigDecimal price;
    @ApiModelProperty("数量")
    private Integer stock;
}
