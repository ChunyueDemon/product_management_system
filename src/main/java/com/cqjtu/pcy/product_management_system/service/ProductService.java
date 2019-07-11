package com.cqjtu.pcy.product_management_system.service;

import com.cqjtu.pcy.product_management_system.dal.entity.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(String productName,String productImg,String productDescImg,double productPrice,int productNumber,String available);
    List<Product> getProducts();
    Product getProduct(Integer productId);
    boolean modifyProductInfo(String productId,String productName,String productImgName,String productDescImgName,double productPrice,int productNumber,String available);
    boolean deleteProductInfo(Integer productId);
}
