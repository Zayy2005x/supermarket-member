package com.zayy.supermarketmember.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "新增商品分类数据传输模型")
public class CategoryAddDTO {
    @ApiModelProperty("分类名")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("图标url")
    private String icon;
}
