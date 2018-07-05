package com._520it.shopping.test;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.dao.impl.ProductDAOimpl;
import com._520it.shopping.domain.Product;
import org.junit.Test;

public class ProductDAOTest {
    private IProductDAO dao = new ProductDAOimpl();
    @Test
    public void testGet(){
        Product product = dao.get(5L);
        System.out.println(product);
    }

}
