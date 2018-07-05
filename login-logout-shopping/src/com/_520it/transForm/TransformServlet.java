package com._520it.transForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 模拟表单的重复提交
 * 表单重复提交原因有三个
 * 1.服务器缓慢重复点击按钮
 * 2.提交成功 点击刷新页面
 * 3.提交成功 点击回退按钮 再次提交
 */
@WebServlet("/transForm")
public class TransformServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String sessionToken = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
        String requestToken = req.getParameter("token");
        //比较session和request中的令牌是否一样
        if (requestToken.equals(sessionToken)){
            req.getSession().removeAttribute("TOKEN_IN_SESSION");
            String money = req.getParameter("money");
            System.out.println("转账金额为："+money);
            PrintWriter out = resp.getWriter();
            out.print("转账成功！");
        }else {
            System.out.println("不要重复提交........");
        }
    }
}
