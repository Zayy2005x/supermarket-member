package com.zayy.supermarketmember.controller.admin;


import com.zayy.supermarketmember.common.constant.MessageConstant;
import com.zayy.supermarketmember.common.result.Result;
import com.zayy.supermarketmember.common.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("admin/common")
@Api(tags = "公共接口")
public class CommonController {
    @Autowired
    private AliOssUtil aliOssUtil;
    /**
     * 文件上传
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public Result<String> upload(MultipartFile file){
        log.info("上传文件,{}",file);
        String filePath = "";
        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称
            String objectName = UUID.randomUUID().toString() + extension;
            //文件的保存路径
            filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败",e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
