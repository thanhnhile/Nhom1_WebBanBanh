package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.impl.ReceiptServiceImpl;



@WebServlet(urlPatterns= {"/seller/receipt/list"})
public class ListReceiptController extends HttpServlet{
	ReceiptService service = new ReceiptServiceImpl();
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		Map<DeliveryDetailModel, List<ReceiptDetailModel>> map = new HashMap<DeliveryDetailModel, List<ReceiptDetailModel>>();
		HttpSession httpSession = req.getSession(false);
		if(httpSession != null && httpSession.getAttribute("acc") != null) {
			UserModel user = (UserModel)httpSession.getAttribute("acc");
			int sID = user.getShop().getsID();
			String type = req.getParameter("type");
			if(type.equals("all")) {
				map = service.getReceiptListByShop(0,sID);
			} else if(type.equals("waitting")) {
				map = service.getReceiptListByShop(1,sID);
			}else if(type.equals("delivering")) {
				map = service.getReceiptListByShop(2,sID);
			}else if(type.equals("delivered")) {
				map = service.getReceiptListByShop(3,sID);
			}else if(type.equals("cancelled")){
				map = service.getReceiptListByShop(4,sID);
			}
			req.setAttribute("orderList", map);
			req.getRequestDispatcher("/views/seller/list-order.jsp").forward(req, resp);
		}
		
		
	}

}
