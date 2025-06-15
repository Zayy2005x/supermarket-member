package com.zayy.supermarketmember.controller.admin;


import com.zayy.supermarketmember.common.result.PageResult;
import com.zayy.supermarketmember.common.result.Result;
import com.zayy.supermarketmember.mapper.CategoryMapper;
import com.zayy.supermarketmember.pojo.dto.CategoryAddDTO;
import com.zayy.supermarketmember.pojo.dto.CategoryPageQueryDTO;
import com.zayy.supermarketmember.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@Slf4j
@RequestMapping("admin/category")
@Api(tags = "分类相关接口")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    /**
     * 新增商品分类
     * @param categoryAddDTO
     * @return
     */
    @PostMapping()
    @ApiOperation("新增商品分类接口")
    public Result<String> addCategory(@RequestBody CategoryAddDTO categoryAddDTO){
        log.info("新增商品分类:{}",categoryAddDTO);
        categoryService.add(categoryAddDTO);
        return Result.success();
    }

    /**
     * 设置商品分类的启用状态
     * @param status
     * @param id
     * @return
     */
    @PutMapping("/status/{status}")
    @ApiOperation("设置商品分类状态接口")
    public Result<String> setStatus(@PathVariable Byte status,Long id){
        log.info("设置商品:{},分类状态:{}",id,status);
        categoryService.setStatus(status,id);
        return Result.success();
    }


    @DeleteMapping()
    @ApiOperation("删除商品分类接口")
    public Result<String> delete(Long id){
        log.info("删除商品分类:{}",id);
        categoryService.delete(id);
        return Result.success();
    }


    @GetMapping("/page")
    @ApiOperation("商品分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("商品分类分页查询:{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }
}
