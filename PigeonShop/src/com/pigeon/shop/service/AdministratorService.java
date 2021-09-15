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
	//ע��ҵ��
	public void save(Administrator ad) {
		//�����ݴ������ݿ�
		//ad.setState(0);//0δ���� 1�Ѽ���  �û�״̬
		//String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//ad.setCode(code);//���ü�����
		dao.save(ad);
	}
	
	public Administrator login(Administrator ad) {
		System.out.println("service"+ad.getAccount());
		return dao.login(ad);
	}
}
