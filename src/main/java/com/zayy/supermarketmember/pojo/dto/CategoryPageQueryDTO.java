package com.zayy.supermarketmember.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("商品分类分页查询数据传输模型")
public class CategoryPageQueryDTO {


    @ApiModelProperty("分类名称")
    private String name;
    @ApiModelProperty("页码")
    private Integer page;
    @ApiModelProperty("每页记录数")
    private Integer pageSize;
}
