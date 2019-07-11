package com.cqjtu.pcy.product_management_system.web;

import com.cqjtu.pcy.product_management_system.dal.entity.ProductAttribute;
import com.cqjtu.pcy.product_management_system.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductAttributeController {
    @Autowired
    ProductAttributeService productAttributeService;
    @RequestMapping("addProductAttribute")
    public String addProductAttribute(String color,String type,String price,String amount,String productId){
        System.out.println(color+type);
        productAttributeService.addProductAttribute(color,type,Integer.parseInt(amount),Double.valueOf(price),new Integer(productId));
        return "redirect:add_product_attribute.html?productId="+productId;
    }

    @RequestMapping("getAttributesByProductId")
    @ResponseBody
    public ProductAttribute getAttributeByAttributeId(String attributeId){
        return productAttributeService.getProductAttribute(new Integer(attributeId));
    }

    @RequestMapping("modifyProductAttribute")
    public String modifyProductAttribute(String color,String type,String price,String amount,String productId,String attributeId){
        System.out.println(productId);
        productAttributeService.modifyProductAttribute(new Integer(attributeId),color,type,Integer.parseInt(amount),Double.valueOf(price));
        return "redirect:add_product_attribute.html?productId="+productId;
    }

    @RequestMapping("deleteAttribute")
    public String deleteAttribute(String attributeId,String productId){
        productAttributeService.deleteProductAttributeByAttributeId(new Integer(attributeId));
        return "redirect:add_product_attribute.html?productId="+productId;

    }
}
