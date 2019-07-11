package com.cqjtu.pcy.product_management_system.service;

import com.cqjtu.pcy.product_management_system.dal.entity.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {
    boolean addProductAttribute(String color,String type,int amount,double price,Integer productId);
    ProductAttribute getProductAttribute(Integer attributeId);
    List<ProductAttribute> getAttributesById(Integer productId);
    boolean modifyProductAttribute(Integer attributeId,String color,String type,int amount,double price);
    boolean deleteProductAttributeByAttributeId(Integer attributeId);
    boolean deleteProductAttributesByProductId(Integer productId);
}
