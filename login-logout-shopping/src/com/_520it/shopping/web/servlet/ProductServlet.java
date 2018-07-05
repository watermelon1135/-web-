package com._520it.shopping.web.servlet;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.dao.impl.ProductDAOimpl;
import com._520it.shopping.domain.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IProductDAO dao;

	public void init() throws ServletException {
		dao=new ProductDAOimpl();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		//判断session中是否有用户信息
        Object uin = req.getSession().getAttribute("USER_IN_SESSION");
        if (uin == null){
            req.setAttribute("errorMsg","你还没有登陆，请登录！");
            req.getRequestDispatcher("/Login.jsp").forward(req,resp);
            return ;
        }
        if ("save".equals(cmd)){
			saveOrUpdate(req, resp);
		}else if ("delete".equals(cmd)){
			delete(req, resp);
		}else if("edit".equals(cmd)){
			edit(req, resp);
		}else{
			list(req, resp);
		}
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		dao.delete(Long.valueOf(req.getParameter("id")));
		resp.sendRedirect("/product");
	}
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Product p = new Product();
		String sid=req.getParameter("id");
		p.setProduct(req.getParameter("product"));
		p.setSupplier(req.getParameter("supplier"));
		p.setNum(Integer.valueOf(req.getParameter("num")));
		p.setPrice(Double.valueOf(req.getParameter("price")));
		if (!"".equals(sid)&&sid!=null){
			dao.update(p, Long.valueOf(sid));
		}else{
			dao.save(p);
		}
		resp.sendRedirect("/product");
	}
	protected void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Product> list = dao.list();
		req.setAttribute("products", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
	protected void edit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sid = req.getParameter("id");
		if (!"".equals(sid) && sid!=null){
			Product p;
			p = dao.get(Long.valueOf(sid));
			req.setAttribute("product", p);
		}
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);		
	}
}
