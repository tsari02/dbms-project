package com.dbms.project.service;

import com.dbms.project.dao.ProductDao;
import com.dbms.project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public int insertProduct(Product product) {
        return productDao.insertProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public int deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }

    public int updateProduct(int id, Product product) {
        return productDao.updateProduct(id, product);
    }

    public List<Product> getProductsByCustomerOrderId(int customerOrderId) {
        return productDao.getProductsByCustomerOrderId(customerOrderId);
    }
}
