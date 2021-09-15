package com.pigeon.shop.service;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.UserDao;
import com.pigeon.shop.entity.User;

@Transactional
public class UserService {
	//ע��userdao
	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	public User findByUsername(String username){
		System.out.println("service");
		System.out.println(username);
		return dao.findByUsername(username);
	}
	//ע��ҵ��
	public void save(User user) {
		//�����ݴ������ݿ�
		//ad.setState(0);//0δ���� 1�Ѽ���  �û�״̬
		//String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//ad.setCode(code);//���ü�����
		dao.save(user);
	}

	public User login(User user) {
		System.out.println("service"+user.getUsername());
		return dao.login(user);
	}
	
}
