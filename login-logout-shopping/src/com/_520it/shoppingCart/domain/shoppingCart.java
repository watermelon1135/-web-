package com._520it.shoppingCart.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class shoppingCart {
    private List<CartItem> listItem= new ArrayList<>();

    //把商品加入购物车
    public void save(CartItem cartItem){
        for (CartItem it:listItem) {
            if (it.getId().equals(cartItem.getId())){//商品已经在购物车中存在
                it.setNum(it.getNum()+cartItem.getNum());//修改购买数量
                return ;
            }
        }
        listItem.add(cartItem);
    }

    //删除指定商品
    public void delete(String id){
        Iterator<CartItem> iterator = listItem.iterator();
        // 注意边迭代边删除 要使用迭代器的删除 不能使用集合的删除
        // 所以不能使用foreach循环
        while (iterator.hasNext()){
            CartItem item = iterator.next();
            if (item.getId().equals(id)){
                iterator.remove();
                break;
            }
        }
    }

    //计算购物车的总价
    public Double getTotalPrice(){
        Double totalPrice = new Double(0);
        for (CartItem item:listItem
             ) {
            totalPrice+=item.getPrice()*item.getNum();
        }
        return totalPrice;
    }

    //购物车中全部的商品
    public List<CartItem> getListItem(){
        return listItem;
    }

}
