package vn.ithcmute.api.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.ithcmute.model.StatisticsModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.StatisticsService;
import vn.ithcmute.service.impl.StatisticsServiceImpl;
import vn.ithcmute.util.HttpUtil;



@WebServlet(urlPatterns= {"/api-category"})
public class CategoryStatisticAPI extends HttpServlet{

	StatisticsService service = new StatisticsServiceImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		UserModel userModel = (UserModel)session.getAttribute("acc");
		int sID = userModel.getShop().getsID();
			
		 ObjectMapper mapper = new ObjectMapper();
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("application/json");
		 List<StatisticsModel> cateS =  HttpUtil.of(req.getReader()).listModel(StatisticsModel.class);
		 cateS = service.getStatisticsCategory(sID);
		 mapper.writeValue(resp.getOutputStream(), cateS);
	}

}
