package com._520it.shopping.domain;

import lombok.Data;

@Data
public class Product {
    private Long id;//商品id
    private String product;//商品名
    private Double price;//金额
    private String supplier;//生产商
    private int num;//库存量
}
