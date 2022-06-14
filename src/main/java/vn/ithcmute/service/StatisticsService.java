package vn.ithcmute.service;

import java.util.List;

import vn.ithcmute.model.StatisticsModel;

public interface StatisticsService {
	List<StatisticsModel> getListAllReceipt(int sID);

	List<StatisticsModel> getListDeliveredReceipt(int sID);

	List<StatisticsModel> getStatisticsCategory(int sID);

	List<StatisticsModel> getStatisticsProduct(int sID);

	List<StatisticsModel> getStatistics(String sql, int sID);

	
}
