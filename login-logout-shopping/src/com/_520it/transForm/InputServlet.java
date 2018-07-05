package com._520it.transForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 使用令牌机制解决表单重复提交
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    //生成随机令牌
        String token = UUID.randomUUID().toString();
        req.getSession().setAttribute("TOKEN_IN_SESSION",token);
        req.setAttribute("token",token);
        req.getRequestDispatcher("/repeatSubmit/input.jsp").forward(req,resp);
    }
}
