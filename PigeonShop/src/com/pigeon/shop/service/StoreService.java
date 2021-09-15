package com.pigeon.shop.service;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.StoreDao;
import com.pigeon.shop.entity.Store;
import com.pigeon.shop.entity.User;

@Transactional
public class StoreService {
	//注入userdao
	private StoreDao dao;


	public void setDao(StoreDao dao) {
		this.dao = dao;
	}
	
	public Store findByAccount(String account){
		System.out.println("service");
		System.out.println(account);
		return dao.findByAccount(account);
	}
	//注册业务
	public void save(Store store) {
		//将数据存入数据库
		//ad.setState(0);//0未激活 1已激活  用户状态
		//String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//ad.setCode(code);//设置激活码
		dao.save(store);
	}

	public Store login(Store store) {
		// TODO Auto-generated method stub
		return dao.login(store);
	}
	
}
