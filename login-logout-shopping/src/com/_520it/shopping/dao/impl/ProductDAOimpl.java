package com._520it.shopping.dao.impl;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.domain.Product;
import com._520it.shopping.handler.ResultSetHandler;
import com._520it.shopping.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements IProductDAO {

    public void save(Product obj) {
        String sql = "insert into product(product,price,supplier,num) values(?,?,?,?)";
        JdbcTemplate.update(sql, obj.getProduct(),obj.getPrice(),obj.getSupplier(),obj.getNum());
    }

    public void delete(Long id) {
        String sql = "delete from product where id = ?";
        JdbcTemplate.update(sql, id);
    }

    public void update(Product obj, Long id) {
        String sql="update product set product=?,price=?,supplier=?,num=? where id=?";
        JdbcTemplate.update(sql,obj.getProduct(),obj.getPrice(),obj.getSupplier(),obj.getNum(),id);
    }

    public Product get(Long id) {
        String sql = "select * from product where id=?";
        List<Product> list = JdbcTemplate.query(sql,new ProductResultSetHandler(),id);
        return list.size() ==1?list.get(0):null;
    }

    public List<Product> list() {
        String sql="Select * from product";
        //贾琏欲执事
        return JdbcTemplate.query(sql,new ProductResultSetHandler());
    }

    class  ProductResultSetHandler  implements ResultSetHandler<List<Product>> {
        public List<Product> Handler(ResultSet rs) throws SQLException {

            List<Product> list = new ArrayList<>();
            while (rs.next()){
                Product p = new Product();
                list.add(p);
                p.setId(rs.getLong("id"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setProduct(rs.getString("product"));
                p.setSupplier(rs.getString("supplier"));
            }
            return list;
        }
    }
}
