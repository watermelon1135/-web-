package com._520it.shoppingCart.domain;

import lombok.Data;

//购物车的商品对象和普通商品对象不一样
@Data
public class CartItem {
    private String id;//商品唯一标识
    private String name;//商品名字
    private Double price;//商品金额
    private Integer num;//购买数量

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public CartItem(String id, String name, Double price, Integer num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
    }
}
