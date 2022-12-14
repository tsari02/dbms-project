package com.dbms.project.service;

import com.dbms.project.dao.ProductTypeDao;
import com.dbms.project.model.ProductSpecification;
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

    public List<ProductSpecification> getProductTypeSpecificationsbyid(int id) {
        return productTypeDao.getProductTypeSpecificationsbyid(id);
    }

    public int deleteProductType(int id) {
        return productTypeDao.deleteProductType(id);
    }

    public int updateProductType(int id, ProductType productType) {
        return productTypeDao.updateProductType(id, productType);
    }

    public List<ProductType> getAllProductTypesInCustomerOrder(int customerOrderId) {
        return productTypeDao.getAllProductTypesInCustomerOrder(customerOrderId);
    }

    public List<ProductType> getAllProductTypesInSupplierOrder(int supplierOrderId) {
        return productTypeDao.getAllProductTypesInSupplierOrder(supplierOrderId);
    }

    public int addProductTypeToCustomerOrder(int productTypeId, int quantity, int customerOrderId) {
        return productTypeDao.addProductTypeToCustomerOrder(productTypeId, quantity, customerOrderId);
    }
}
