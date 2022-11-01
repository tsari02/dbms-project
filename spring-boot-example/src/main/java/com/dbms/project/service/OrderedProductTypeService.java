package com.dbms.project.service;

import com.dbms.project.dao.OrderedProductTypeDao;
import com.dbms.project.model.OrderedProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductTypeService {
    private final OrderedProductTypeDao orderedProductTypeDao;

    @Autowired
    public OrderedProductTypeService(OrderedProductTypeDao orderedProductTypeDao) {
        this.orderedProductTypeDao = orderedProductTypeDao;
    }

    public int insertOrderedProductType(OrderedProductType orderedProductType) {
        return orderedProductTypeDao.insertOrderedProductType(orderedProductType);
    }

    public List<OrderedProductType> getAllOrderedProductTypes() {
        return orderedProductTypeDao.getAllOrderedProductTypes();
    }

    public OrderedProductType getOrderedProductTypeById(int id) {
        return orderedProductTypeDao.getOrderedProductTypeById(id);
    }

    public int deleteOrderedProductType(int id) {
        return orderedProductTypeDao.deleteOrderedProductType(id);
    }

    public int updateOrderedProductType(int id, OrderedProductType orderedProductType) {
        return orderedProductTypeDao.updateOrderedProductType(id, orderedProductType);
    }
}
