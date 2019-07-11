package com.cqjtu.pcy.product_management_system.dal;

import com.cqjtu.pcy.product_management_system.dal.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAttributeRepo extends JpaRepository<ProductAttribute,Integer> {
    ProductAttribute findOneByAttributeId(Integer attributeId);
    List<ProductAttribute> findByProductId(Integer productId);
    void deleteByProductId(Integer productId);
}
