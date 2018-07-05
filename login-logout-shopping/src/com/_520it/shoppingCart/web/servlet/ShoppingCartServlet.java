package com._520it.shoppingCart.web.servlet;

import com._520it.shoppingCart.domain.CartItem;
import com._520it.shoppingCart.domain.shoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String cmd = req.getParameter("cmd");
        if("save".equals(cmd)){
            save(req,resp);
        }else if("delete".equals(cmd)){
            delete(req,resp);
        }else if("shopping".equals(cmd)){
            req.getRequestDispatcher("/WEB-INF/shoppingCart/product_list.jsp").forward(req,resp);
        }else {
        }
        req.getRequestDispatcher("/WEB-INF/shoppingCart/cart_list.jsp").forward(req, resp);
    }

    protected void save(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String p_name = req.getParameter("p_name");
        String p_num = req.getParameter("p_num");
        String p_price="";
        String id = "";
        if ("iphonex".equals(p_name)){
            p_price="8888";
            id="123";
        }else if("手表".equals(p_name)){
            p_price="589";
            id="456";
        }else if("衣服".equals(p_name)){
            p_price="299";
            id="789";
        }else{
            p_price="669";
            id="000";
        }
        CartItem cartItem = new CartItem(id,p_name,Double.valueOf(p_price),Integer.valueOf(p_num));
        shoppingCart listCart = (shoppingCart)req.getSession().getAttribute("SESSION_IN_CART");
        if (listCart == null){
            listCart=new shoppingCart();
            req.getSession().setAttribute("SESSION_IN_CART",listCart);
        }
        listCart.save(cartItem);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        shoppingCart listCart = (shoppingCart)req.getSession().getAttribute("SESSION_IN_CART");
        listCart.delete(id);
        System.out.println(listCart.getListItem()+id);
    }
}
