package vn.ithcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.dao.impl.ShopDaoImpl;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.util.Constant;

@WebServlet(urlPatterns = { "/shop" })
public class ShopController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiáº¿t láº­p TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Láº¥y tham sá»‘ tá»« JSP
		String sid = req.getParameter("sid");
		if(sid != null && !sid.trim().isEmpty()) {
			// bÆ°á»›c 1:Khá»Ÿi táº¡o DAO
			ProductService productSerive  = new ProductServiceImpl();
			ShopDaoImpl shopDao = new ShopDaoImpl();

			// bÆ°á»›c 2:Sá»­ dá»¥ng List chá»©a DS tá»« ProductDAO
			List<ProductModel> list = productSerive.getProductBysID(Integer.parseInt(sid));
			ShopModel shop = shopDao.get(Integer.parseInt(sid));
			// bÆ°á»›c 3: Thiáº¿t láº­p dá»¯ liá»‡u lÃªn JSP
			req.setAttribute("list", list);
			req.setAttribute("shop", shop);
			// bÆ°á»›c 4: Tráº£ vá»� trang JSP nÃ o
			RequestDispatcher rq = req.getRequestDispatcher("/views/shop.jsp");
			rq.forward(req, resp);
		}
		else resp.sendRedirect(req.getContextPath()+"/home");
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
