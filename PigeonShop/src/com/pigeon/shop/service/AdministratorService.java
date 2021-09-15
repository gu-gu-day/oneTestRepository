package com.pigeon.shop.service;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.AdministratorDao;
import com.pigeon.shop.entity.Administrator;
import com.pigeon.shop.entity.User;

@Transactional
public class AdministratorService {
	private AdministratorDao dao;


	public void setDao(AdministratorDao dao) {
		this.dao = dao;
	}
	
	public Administrator findByAccount(String account){
		System.out.println("service");
		System.out.println(account);
		return dao.findByAccount(account);
	}
	//注册业务
	public void save(Administrator ad) {
		//将数据存入数据库
		//ad.setState(0);//0未激活 1已激活  用户状态
		//String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//ad.setCode(code);//设置激活码
		dao.save(ad);
	}
	
	public Administrator login(Administrator ad) {
		System.out.println("service"+ad.getAccount());
		return dao.login(ad);
	}
}
