package com.dbms.project.dao;

import com.dbms.project.model.ProductType;
import com.dbms.project.preparedStatementSetters.ProductTypeIdPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProductTypeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertProductType(ProductType productType) {
        final String sql = "INSERT INTO productType(name, warrantyPeriod, quantity, price) VALUES(?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productType.getName());
            ps.setInt(2, productType.getWarrantyPeriod());
            ps.setInt(3, productType.getQuantity());
            ps.setString(4, productType.getPrice());


            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        productType.setId(id);
        return id;
    }

    public List<ProductType> getAllProductTypes() {
        final String sql = "SELECT p.id as 'id', p.name as 'name', p.warrantyPeriod as 'warrantyPeriod', p.price as 'price', (SELECT COUNT(p2.id)  " +
                "FROM product p2 " +
                "WHERE p2.productTypeId = p.id AND " +
                "p2.customerOrderId IS NULL) as 'quantity' " +
                "FROM productType p ";
        List<ProductType>  products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductType.class));
        return products;
    }

    public ProductType getProductTypeById(int id) {
        final String sql = "SELECT * from productType WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(ProductType.class));
    }

    public int deleteProductType(int id) {
        final String sql = "DELETE FROM productType WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateProductType(int id, ProductType productType) {
        final String sql = "UPDATE productType SET name = ?, warrantyPeriod = ?, quantity = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, productType.getName(), productType.getWarrantyPeriod(), productType.getQuantity(), productType.getPrice(), id);
    }

    public List<ProductType> getAllProductTypesInCustomerOrder(int customerOrderId) {
        final String sql = "SELECT p.id as 'id', p.name as 'name', p.warrantyPeriod as 'warrantyPeriod', p.price as 'price', (SELECT COUNT(p2.id)  " +
                "FROM product p2 " +
                "WHERE p2.productTypeId = p.id AND " +
                "p2.customerOrderId = ?) as 'quantity' " +
                "FROM productType p ";
        List<ProductType>  products = jdbcTemplate.query(sql, new Object[] {customerOrderId}, new BeanPropertyRowMapper<>(ProductType.class));
        return products;
    }

    @Transactional
    public int addProductTypeToCustomerOrder(int productTypeId, int quantity, int customerOrderId) {
        final String sql1 = "SELECT id FROM product WHERE customerOrderId IS NULL AND productTypeID = ? LIMIT ?";
        List<Integer> productIds = jdbcTemplate.queryForList(sql1, new Object[] {productTypeId, quantity},  int.class);

        final String sql2 = "CREATE temporary TABLE productIdsTemp (id INT NOT NULL);";
        jdbcTemplate.update(sql2);
        final String sql3 = "INSERT INTO productIdsTemp(id) VALUES (?)";
        jdbcTemplate.batchUpdate(sql3, new ProductTypeIdPreparedStatementSetter(productIds));

        final String sql4 = "UPDATE product SET customerOrderId = ? WHERE id IN (SELECT id FROM productIdsTemp)";
        int result = jdbcTemplate.update(sql4,customerOrderId);
        final String sql5 = "TRUNCATE FROM productIdsTemp";
        jdbcTemplate.update(sql5);
        return result;
    }
}
