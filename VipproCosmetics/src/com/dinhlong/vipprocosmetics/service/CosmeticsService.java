package com.dinhlong.vipprocosmetics.service;

import java.util.List;

import com.dinhlong.vipprocosmetics.dao.CosmeticsDao;
import com.dinhlong.vipprocosmetics.entity.Cosmetics;

public class CosmeticsService {
	// hiển thị
	public List<Cosmetics> getAllCosmetics() {
		CosmeticsDao cosmeticsDao = new CosmeticsDao();
		return cosmeticsDao.getAllCosmetics();
	}

	// tìm kiếm
	public List<Cosmetics> findCosmeticsByName(String name) {
		CosmeticsDao cosmeticsDao = new CosmeticsDao();
		return cosmeticsDao.findCosmeticsByName(name);
	}

	public void insertCosmetics(String code, String name, String trademark, String type, String description,
			String origin, String expirydate, String dateofmanufacture, int quantity,long price, String image) {
		Cosmetics newCosmetics = new Cosmetics();
		CosmeticsDao cosmeticsDao = new CosmeticsDao();

		newCosmetics.setCode(code);
		newCosmetics.setName(name);
		newCosmetics.setTrademark(trademark);
		newCosmetics.setType(type);
		newCosmetics.setDescription(description);
		newCosmetics.setOrigin(origin);
		newCosmetics.setExpirydate(expirydate);
		newCosmetics.setDateofmanufacture(dateofmanufacture);
		newCosmetics.setQuantity(quantity);
		newCosmetics.setPrice(price);
		newCosmetics.setImage(image);

		cosmeticsDao.insertCosmetics(newCosmetics);

	}

	// sửa
	public void updateCosmetics( String id,String code, String name, String trademark, String type, String description,
			String origin, String expirydate, String dateofmanufacture, int quantity,long price, String image) {
		Cosmetics newCosmetics = new Cosmetics();
		CosmeticsDao cosmeticsDao = new CosmeticsDao();
		
		newCosmetics.setId(id);
		newCosmetics.setCode(code);
		newCosmetics.setName(name);
		newCosmetics.setTrademark(trademark);
		newCosmetics.setType(type);
		newCosmetics.setDescription(description);
		newCosmetics.setOrigin(origin);
		newCosmetics.setExpirydate(expirydate);
		newCosmetics.setDateofmanufacture(dateofmanufacture);
		newCosmetics.setQuantity(quantity);
		newCosmetics.setPrice(price);
		newCosmetics.setImage(image);

		cosmeticsDao.updateCosmetics(newCosmetics);

	}

	// xoá
	public void deleteCosmetics(int id) {
		CosmeticsDao cosmeticsDao = new CosmeticsDao();
		cosmeticsDao.deleteCosmetics(id);
	}

	public Cosmetics getCosmetics(String id) {
		CosmeticsDao cosmeticsDao = new CosmeticsDao();
		return cosmeticsDao.findById(id);
	}

}
