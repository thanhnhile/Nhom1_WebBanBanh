package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ReceiptServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;


@WebServlet(urlPatterns= {"/seller/home"})
public class HomeController extends HttpServlet{
	ProductService productService = new ProductServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	ReceiptService receiptService = new ReceiptServiceImpl();

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//Lay tai khoan dang nhap de lay Shop ID
		HttpSession httpSession = req.getSession(false);
		if(httpSession != null && httpSession.getAttribute("acc") != null) {
			UserModel user = (UserModel)httpSession.getAttribute("acc");
			int sID = user.getShop().getsID();
			int countAllProduct = productService.countProduct(sID);
			int countActiveProduct = productService.countActiveProduct(sID);
			int countNoActiveProduct =productService.countNoActiveProduct(sID);
			int countNoneProduct = productService.countNoneProduct(sID);
			
			//int countRAll = receiptService.countAll();
			int countWaitting = receiptService.CountState(1,sID);
			int countDelivering = receiptService.CountState(2,sID);
			int countDelivered = receiptService.CountState(3,sID);
			int countCancelled = receiptService.CountState(4,sID);
			
			//Top 4 New Product
			List <ProductModel> list4New = productService.getTop4NewProduct(sID);
			HashMap<Integer, Integer> map = productService.getSoldAmount();
			List<ProductModel> litst4BestSell = productService.getTop4BestSeller(sID);
			
			req.setAttribute("countAll", countAllProduct);
			req.setAttribute("countActive", countActiveProduct);
			req.setAttribute("countNoActive", countNoActiveProduct );
			req.setAttribute("countNone", countNoneProduct);
			
			req.setAttribute("countCancelled", countCancelled);
			req.setAttribute("countWaitting", countWaitting);
			req.setAttribute("countDelivering", countDelivering);
			req.setAttribute("countDelivered", countDelivered);
			
			req.setAttribute("list4New", list4New);
			req.setAttribute("soldAmount", map);
			req.setAttribute("list4Best", litst4BestSell );
			
			req.getRequestDispatcher("/views/seller/home.jsp").forward(req, resp);
		}
		
	}

}