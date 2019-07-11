package com.cqjtu.pcy.product_management_system.web;

import com.cqjtu.pcy.product_management_system.dal.entity.Product;
import com.cqjtu.pcy.product_management_system.dal.entity.ProductAttribute;
import com.cqjtu.pcy.product_management_system.service.ProductAttributeService;
import com.cqjtu.pcy.product_management_system.service.ProductService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Controller
public class PageForwardController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductAttributeService productAttributeService;
    @RequestMapping("product.html")
    public String product(ModelMap modelMap){
        List<Product> products = productService.getProducts();
        modelMap.put("products",products);
        return "product";
    }
    @RequestMapping("order_form.html")
    public String orderForm(){
        return "order_form";
    }

    @RequestMapping("add_product_attribute.html")
    public String addProductAttribute(ModelMap modelMap,String productId){
        List<ProductAttribute> attributes = productAttributeService.getAttributesById(new Integer(productId));
        modelMap.put("attributes",attributes);
        modelMap.put("productId",productId);
        return "add_product_attribute";
    }
    @RequestMapping("test")
    public void test() throws IOException {
        String filePath="E:\\img\\productDesc\\11111.jpg";
        File file = new File(filePath);
        Thumbnails.of(filePath)
                .size(400, 600)
                .toFile(file.getAbsolutePath() + "_200x300.jpg");


        /**
         * 按照比例进行缩放
         * scale(比例)
         * */
//        Thumbnails.of(filePath)
//                .scale(0.25f)
//                .toFile(file.getAbsolutePath() + "_25%.jpg");


        /**
         *  不按照比例，指定大小进行缩放
         *  keepAspectRatio(false) 默认是按照比例缩放的
         * */
//        Thumbnails.of(filePath)
//                .size(200, 200)
//                .keepAspectRatio(false)
//                .toFile(file.getAbsolutePath() + "_200x200.jpg");

        /**
         *  输出图片到流对象
         *
         * */
//        OutputStream os = new FileOutputStream(file.getAbsolutePath() + "_OutputStream.png");
//        Thumbnails.of(filePath)
//                .size(1280, 1024)
//                .toOutputStream(os);

        /**
         *  输出图片到BufferedImage
         * **/
//        BufferedImage thumbnail = Thumbnails.of(filePath)
//                .size(1280, 1024)
//                .asBufferedImage();
//        ImageIO.write(thumbnail, "jpg", new File(file.getAbsolutePath()+"_BufferedImage.jpg"));

    }
}
