package com.dbms.project.service;

import com.dbms.project.dao.OrderedProductTypesDao;
import com.dbms.project.model.OrderedProductTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductTypesService {
    private final OrderedProductTypesDao orderedProductTypesDao;

    @Autowired
    public OrderedProductTypesService(OrderedProductTypesDao orderedProductTypesDao) {
        this.orderedProductTypesDao = orderedProductTypesDao;
    }

    public int insertOrderedProductTypes(OrderedProductTypes orderedProductTypes) {
        return orderedProductTypesDao.insertOrderedProductTypes(orderedProductTypes);
    }

    public List<OrderedProductTypes> getAllOrderedProductTypes() {
        return orderedProductTypesDao.getAllOrderedProductTypes();
    }

    public OrderedProductTypes getOrderedProductTypesById(int id) {
        return orderedProductTypesDao.getOrderedProductTypesById(id);
    }

    public int deleteOrderedProductTypes(int id) {
        return orderedProductTypesDao.deleteOrderedProductTypes(id);
    }

    public int updateOrderedProductTypes(int id, OrderedProductTypes orderedProductTypes) {
        return orderedProductTypesDao.updateOrderedProductTypes(id, orderedProductTypes);
    }
}
