package com.cqjtu.pcy.product_management_system.web;

import com.cqjtu.pcy.product_management_system.common.Result;
import com.cqjtu.pcy.product_management_system.service.FileUploadService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
public class fileUploadController {
    @Value("${static.upload.path}")
    private String uploadPath;
    @Value("${static.server.address}")
    private String serverAddress;
    @Autowired
    FileUploadService fileUploadService;

    @RequestMapping("uploadProductImg")
    @ResponseBody
    public Result uploadProductImg(MultipartFile file, String description){
        Result result = fileUploadService.uploadFile(file, uploadPath + "product/", serverAddress + "img/product/", description);
        if (result.isSuccess()){
            try {
                Thumbnails.of(uploadPath + "product/"+result.getMsg())
                        .size(160, 160)
                        .keepAspectRatio(false)
                        .toFile(uploadPath + "suolueProduct/"+result.getMsg());
                Thumbnails.of(uploadPath + "product/"+result.getMsg())
                        .size(400, 400)
                        .keepAspectRatio(false)
                        .toFile(uploadPath + "suolueProduct1/"+result.getMsg()); //首页缩略图
                Thumbnails.of(uploadPath + "product/"+result.getMsg())
                        .size(400, 400)
                        .keepAspectRatio(false)
                        .toFile(uploadPath + "suolueProduct2/"+result.getMsg());//详情页缩略图
                Thumbnails.of(uploadPath + "product/"+result.getMsg())
                        .size(280, 280)
                        .keepAspectRatio(false)
                        .toFile(uploadPath + "suolueProduct3/"+result.getMsg());//搜索结果页缩略图

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping("uploadProductDesc")
    @ResponseBody
    public Result uploadProductDesc(MultipartFile file, String description){
        Result result = fileUploadService.uploadFile(file, uploadPath + "productDesc/", serverAddress + "img/productDesc/", description);
        if (result.isSuccess()){
            try {
                Thumbnails.of(uploadPath + "productDesc/"+result.getMsg())
                        .size(400, 600)
                        .toFile(uploadPath + "suolueProductDesc/"+result.getMsg());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
