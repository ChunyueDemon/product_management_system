package com.cqjtu.pcy.product_management_system.service.Impl;

import com.cqjtu.pcy.product_management_system.dal.ProductAttributeRepo;
import com.cqjtu.pcy.product_management_system.dal.entity.ProductAttribute;
import com.cqjtu.pcy.product_management_system.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    @Autowired
    ProductAttributeRepo productAttributeRepo;
    /**
     * 添加商品的属性
     * @param color //商品颜色
     * @param type //商品的属性类型
     * @param amount //该属性的商品数量
     * @param productId //属于的商品的id
     * @return 删除成功返回true
     */
    @Override
    public boolean addProductAttribute(String color, String type, int amount, double price, Integer productId) {
        try{
            ProductAttribute productAttribute=new ProductAttribute();
            productAttribute.setColor(color);
            productAttribute.setAmount(amount);
            productAttribute.setType(type);
            productAttribute.setProductId(productId);
            productAttribute.setPrice(price);
            productAttributeRepo.save(productAttribute);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 根据商品id和属性id的到一项商品属性
     * @param attributeId
     * @return
     */
    @Override
    public ProductAttribute getProductAttribute(Integer attributeId) {
        return productAttributeRepo.findOneByAttributeId(attributeId);
    }

    /**
     * 根据商品id得到所有的商品属性类型
     * @param productId
     * @return
     */
    @Override
    public List<ProductAttribute> getAttributesById(Integer productId) {
        return productAttributeRepo.findByProductId(productId);
    }

    /**
     * 修改商品的一项属性
     * @param attributeId //商品属性id
     * @param color //yanse
     * @param type //属性类型
     * @param amount //数量
     * @return
     */
    @Override
    public boolean modifyProductAttribute(Integer attributeId, String color, String type, int amount, double price) {
        try {
            ProductAttribute oneByAttributeId = productAttributeRepo.findOneByAttributeId(attributeId);
            oneByAttributeId.setColor(color);
            oneByAttributeId.setType(type);
            oneByAttributeId.setAmount(amount);
            oneByAttributeId.setPrice(price);
            productAttributeRepo.save(oneByAttributeId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 根据商品属性id删除一项属性记录
     * @param attributeId //商品属性id
     * @return
     */
    @Override
    public boolean deleteProductAttributeByAttributeId(Integer attributeId) {
        try{
            productAttributeRepo.deleteById(attributeId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据商品id删除一项或多项属性记录
     * @param productId //商品id
     * @return
     */
    @Override
    public boolean deleteProductAttributesByProductId(Integer productId) {
        try{
            productAttributeRepo.deleteByProductId(productId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
