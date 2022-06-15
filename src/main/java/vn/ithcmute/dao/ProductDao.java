package vn.ithcmute.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;

public interface ProductDao {

	void update(ProductModel pModel);

	void insert(ProductModel pModel);

	ProductModel get(int id);

	void activeProduct(int pID, int state);

	List<ProductModel> search(String txt);

	List<ProductModel> getProductByCID(int cateID);


	List<ProductModel> getNoActiveProduct(int sID);

	List<ProductModel> getOutOfStockProduct(int sID);


	List<ProductModel> getTop8New();
	List<ProductModel> getTop8BestSeller();
	int countAll();
	int countCid(int cid);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> pagingProductByCID(String cid, int index);
	List<ProductModel> getProductBySID(int sID);
	
	//Admin
	int getTotalSoldProductByShop();
	
	Map<String, Integer> getTop6ShopByProduct();
	
	Map<ShopModel, Integer> getAllShopByProduct();
	
	//Seller
	
	
	int countNoActiveProduct(int sID);

	int countActiveProduct(int sID);
	
	HashMap<Integer, Integer> getSoldAmount();


	List<ProductModel> getTop4BestSeller(int sID);

	List<ProductModel> getTop4NewProduct(int sID);

	List<ProductModel> getActiveProduct(int sID);

	int countNoneProduct(int sID);
	List<ProductModel> getAllByShop(int sID);

	int countProduct(int sID);
}
