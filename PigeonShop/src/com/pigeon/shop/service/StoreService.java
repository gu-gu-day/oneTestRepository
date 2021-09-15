package com.pigeon.shop.service;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.StoreDao;
import com.pigeon.shop.entity.Store;
import com.pigeon.shop.entity.User;

@Transactional
public class StoreService {
	//ע��userdao
	private StoreDao dao;


	public void setDao(StoreDao dao) {
		this.dao = dao;
	}
	
	public Store findByAccount(String account){
		System.out.println("service");
		System.out.println(account);
		return dao.findByAccount(account);
	}
	//ע��ҵ��
	public void save(Store store) {
		//�����ݴ������ݿ�
		//ad.setState(0);//0δ���� 1�Ѽ���  �û�״̬
		//String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//ad.setCode(code);//���ü�����
		dao.save(store);
	}

	public Store login(Store store) {
		// TODO Auto-generated method stub
		return dao.login(store);
	}
	
}
