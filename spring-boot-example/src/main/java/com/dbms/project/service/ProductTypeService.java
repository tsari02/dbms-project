package com.dbms.project.service;

import com.dbms.project.dao.ProductTypeDao;
import com.dbms.project.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    private final ProductTypeDao productTypeDao;
    
    @Autowired
    public ProductTypeService(ProductTypeDao productTypeDao) {
        this.productTypeDao = productTypeDao;
    }

    public int insertProductType(ProductType productType) {
        return productTypeDao.insertProductType(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeDao.getAllProductTypes();
    }

    public ProductType getProductTypeById(int id) {
        return productTypeDao.getProductTypeById(id);
    }

    public int deleteProductType(int id) {
        return productTypeDao.deleteProductType(id);
    }

    public int updateProductType(int id, ProductType productType) {
        return productTypeDao.updateProductType(id, productType);
    }
}
