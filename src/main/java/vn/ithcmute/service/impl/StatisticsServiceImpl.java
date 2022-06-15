package vn.ithcmute.service.impl;


import java.util.List;

import vn.ithcmute.dao.StatisticsDao;
import vn.ithcmute.dao.impl.StatisticsDaoImpl;
import vn.ithcmute.model.StatisticsModel;
import vn.ithcmute.service.StatisticsService;



public class StatisticsServiceImpl implements StatisticsService{
	StatisticsDao dao  = new StatisticsDaoImpl();
	
	@Override
	public List<StatisticsModel> getListAllReceipt(int sID) {
		return dao.getListAllReceipt(sID);
	}

	@Override
	public List<StatisticsModel> getListDeliveredReceipt(int sID) {
		return dao.getListDeliveredReceipt(sID);
	}

	@Override
	public List<StatisticsModel> getStatisticsCategory(int sID) {
		return dao.getStatisticsCategory(sID);
	}

	@Override
	public List<StatisticsModel> getStatisticsProduct(int sID) {
		return dao.getStatisticsProduct(sID);
	}

	@Override
	public List<StatisticsModel> getStatistics(String sql,int sID) {
		return dao.getStatistics(sql,sID);
	}

}
