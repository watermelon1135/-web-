package com._520it.shopping.dao;

import com._520it.shopping.domain.Product;

import java.util.List;

public interface IProductDAO {
    /**
     *
     * @param obj 要保存的商品信息
     */
    void save(Product obj);

    /**
     *
     * @param id 删除指定的商品
     */
    void delete(Long id);

    /**
     *
     * @param obj 更新之后的商品信息
     * @param id 要更新的商品信息
     */
    void update(Product obj,Long id);

    /**
     *
     * @param id 要查询的商品id
     * @return 查询出的商品
     */
    Product get(Long id);

    /**
     *
     * @return 查询所有的商品信息
     */
    List<Product> list();
}
