package com.cqjtu.pcy.product_management_system.web;

import com.cqjtu.pcy.product_management_system.dal.entity.Product;
import com.cqjtu.pcy.product_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("addProduct")
    public String addProductInfo(String productName, String productImgName, String productDescImgName, String productPrice, String productNumber,String available){
        productService.addProduct(productName,productImgName,productDescImgName,Double.valueOf(productPrice),Integer.parseInt(productNumber),available);
        return "redirect:product.html";
    }
    @RequestMapping("getProductInfo")
    @ResponseBody
    public Product getProductInfo(String productId){
        return productService.getProduct(new Integer(productId));
    }
    @RequestMapping("modifyProductInfo")
    public String modifyProductInfo(String productId,String productName,String productImgName,String productDescImgName,String productPrice,String productNumber,String available){
        productService.modifyProductInfo(productId,productName,productImgName,productDescImgName,Double.valueOf(productPrice),Integer.parseInt(productNumber),available);
        return "redirect:product.html";
    }

    @RequestMapping("deleteProductInfo")
    public String deleteProductInfo(String productId){
        productService.deleteProductInfo(new Integer(productId));
        return "redirect:product.html";
    }
}
