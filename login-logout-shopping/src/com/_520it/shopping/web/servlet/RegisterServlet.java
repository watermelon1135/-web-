package com._520it.shopping.web.servlet;

import com._520it.shopping.dao.IUserDAO;
import com._520it.shopping.dao.impl.UserDAOimpl;
import com._520it.shopping.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private IUserDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new UserDAOimpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //检验账号是否存在 两次密码是否正确
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordTwo = req.getParameter("passwordTwo");
        User newUser = new User();
        newUser.setUsername(username);
        User u = dao.getUserByUsername(username);
        if (u != null){
            req.setAttribute("errorMsg","该账号已经存在了哦");
            req.getRequestDispatcher("/Register.jsp").forward(req,resp);
            return ;
        }
        if (!password.equals(passwordTwo)){
            req.setAttribute("errorMsg","两次密码不一样哦");
            req.getRequestDispatcher("/Register.jsp").forward(req,resp);
            return ;
        }
        newUser.setPassword(password);
        dao.save(newUser);
        resp.sendRedirect("/Login.jsp");
    }
}
