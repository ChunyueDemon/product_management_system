package com.cqjtu.pcy.product_management_system.dal;

import com.cqjtu.pcy.product_management_system.dal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findOneByProductId(Integer productid);
}
