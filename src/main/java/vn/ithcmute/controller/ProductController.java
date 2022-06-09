package vn.ithcmute.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.dao.impl.CategoryDaoImpl;
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.util.Constant;

@WebServlet(urlPatterns = { "/product", "/san-pham" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiáº¿t láº­p TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Láº¥y tham sá»‘ tá»« JSP
		String cid = req.getParameter("cid");
		String indexPage = req.getParameter("index");

		// khá»Ÿi táº¡o trang Ä‘áº§u
		if (indexPage == null || !indexPage.matches(Constant.regex)) {
			indexPage = "1";
		}
		if(cid.matches(Constant.regex)) {
			int index = Integer.parseInt(indexPage);
			int cid1 = Integer.parseInt(cid);

			// bÆ°á»›c 1:Khá»Ÿi táº¡o DAO
			ProductService productSerive  = new ProductServiceImpl();
			CategoryDaoImpl cateDao = new CategoryDaoImpl();

			// bÆ°á»›c 2:Sá»­ dá»¥ng List chá»©a DS tá»« ProductDAO
			List<ProductModel> list2 = productSerive.getTop8BestSeller();
			List<CategoryModel> listC = cateDao.getAllCategory();
		
			// bÆ°á»›c 3: Thiáº¿t láº­p dá»¯ liá»‡u lÃªn JSP
			if ("0".equals(cid)) { // All product
				int count = productSerive.countAll();
				// chia trang cho count
				int endPage = count / 6;
				if (count % 6 != 0) {
					endPage++;
				}
				List<ProductModel> list = productSerive.pagingProduct(index);
				req.setAttribute("endP", endPage);
				req.setAttribute("listAllproduct", list);
			} else {
				
				int count = productSerive.countCid(cid1);
				int endPage = count / 6;
				if (count % 6 != 0) {
					endPage++;
				}
				List<ProductModel> listPC = productSerive.pagingProductByCID(cid, index);
				req.setAttribute("endP", endPage);
				req.setAttribute("listAllproduct", listPC);
				
			}
				req.setAttribute("cate", listC);

			req.setAttribute("list4BestSeller", list2);
			req.setAttribute("listcate", listC);
			req.setAttribute("tagactive", cid);
			req.setAttribute("tag", index);
			// bÆ°á»›c 4: Tráº£ vá»� trang JSP nÃ o
			RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
			rq.forward(req, resp);
		}
		resp.sendRedirect(req.getContextPath()+"/home");
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}

