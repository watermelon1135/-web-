package com._520it.shopping.web.servlet;

import com._520it.shopping.dao.IUserDAO;
import com._520it.shopping.dao.impl.UserDAOimpl;
import com._520it.shopping.domain.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IUserDAO dao;
    public void init() throws ServletException {
        dao = new UserDAOimpl();
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = dao.getUserByUsername(username);
       // System.out.println(password);
        //检查该账号是否存在
        if (user==null){
            req.setAttribute("errorMsg", "该"+username+"账号不存在");
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);;
        }
        //检查密码是否正确
        if(!user.getPassword().equals(password)){
            req.setAttribute("errorMsg", "账号或密码不正确");
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);;
        }
        //将登陆账户放入到session中
        req.getSession().setAttribute("USER_IN_SESSION",user);
        resp.sendRedirect("/product");

    }
}
