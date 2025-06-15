package com.zayy.supermarketmember.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "管理员分页查询数据传输模型")
public class AdminPageQueryDTO {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("页码")
    private Integer page;
    @ApiModelProperty("每页记录数")
    private Integer pageSize;
}
