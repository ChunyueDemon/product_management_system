package com.cqjtu.pcy.product_management_system.service.Impl;

import com.cqjtu.pcy.product_management_system.common.DeleteFileUtil;
import com.cqjtu.pcy.product_management_system.dal.ProductRepo;
import com.cqjtu.pcy.product_management_system.dal.entity.Product;
import com.cqjtu.pcy.product_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${static.upload.path}")
    private String uploadPath;
    @Autowired
    ProductRepo productRepo;
    @Override
    public boolean addProduct(String productName, String productImg, String productDescImg, double productPrice, int productNumber,String available) {
        try{
            Product product=new Product();
            product.setProductName(productName);
            product.setProductImg(productImg);
            product.setProductDescImg(productDescImg);
            product.setProductPrice(productPrice);
            product.setProductNumber(productNumber);
            product.setAvailable(available);
            productRepo.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(Integer productId) {
        return productRepo.findOneByProductId(productId);
    }

    @Override
    public boolean modifyProductInfo(String productId,String productName,String productImgName,String productDescImgName,double productPrice,int productNumber,String available) {
        Product oneByProductId = productRepo.findOneByProductId(new Integer(productId));
        oneByProductId.setProductName(productName);
        oneByProductId.setProductImg(productDescImgName);
        oneByProductId.setProductDescImg(productDescImgName);
        oneByProductId.setProductPrice(productPrice);
        oneByProductId.setProductNumber(productNumber);
        oneByProductId.setAvailable(available);
        productRepo.save(oneByProductId);
        System.out.println(oneByProductId.toString());
        return true;
    }

    @Override
    public boolean deleteProductInfo(Integer productId) {
        try{
            Product deletionProduct = productRepo.findOneByProductId(productId);
            productRepo.deleteById(productId);
            String productImgFileName=deletionProduct.getProductImg();
            String productDescImgFileName=deletionProduct.getProductDescImg();
            DeleteFileUtil.deleteFile(uploadPath+"product/"+productImgFileName);//删除商品封面图片
            DeleteFileUtil.deleteFile(uploadPath+"suolueProduct/"+productImgFileName);//删除商品封面缩略图片
            DeleteFileUtil.deleteFile(uploadPath+"suolueProduct1/"+productImgFileName);//删除商品展示缩略图片
            DeleteFileUtil.deleteFile(uploadPath+"productDesc/"+productDescImgFileName);//删除商品描述图片
            DeleteFileUtil.deleteFile(uploadPath+"suolueProductDesc/"+productDescImgFileName);//删除商品描述缩略图片

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
