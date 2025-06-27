package com.zayy.supermarketmember.controller.admin;


import com.zayy.supermarketmember.common.result.Result;
import com.zayy.supermarketmember.pojo.dto.ProductAddDTO;
import com.zayy.supermarketmember.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商品相关接口")
@RestController
@RequestMapping("/admin/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加商品功能
     * @param productAddDTO
     * @return
     */
    @PostMapping()
    @ApiOperation("添加商品接口")
    public Result<String> addProduct(@RequestBody ProductAddDTO productAddDTO){
        log.info("添加商品:{}",productAddDTO);
        productService.addProduct(productAddDTO);
        return Result.success();
    }

    /**
     * 修改商品状态
     * @param status
     * @param id
     * @return
     */
    @PutMapping("/status/{status}")
    @ApiOperation("设置商品状态")
    public Result<String> setStatus(@PathVariable Byte status,Long id){
        log.info("修改商品状态id:{},status:{}",id,status);
        return Result.success();
    }
}
