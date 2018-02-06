package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.User;
import com.situ.mall.mapper.UserMapper;
import com.situ.mall.service.IUserService;
import com.situ.mall.util.MD5Util;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
		
	@Override
	public ServerResponse<User> login(String username, String password) {
		int resultCount = userMapper.checkUsername(username);
		if (resultCount == 0) {
			return ServerResponse.createError("�û���������");
		}
		String md5Password = MD5Util.EncodeUtf8(password);
		//User user = userMapper.selectLogin(username, md5Password);
		User user = userMapper.selectLogin(username, password);
		if (user == null) {
			return ServerResponse.createError("�������");
		}
		
		//user.setPassword(StringUtils.EMPTY);
		user.setPassword("");
		return ServerResponse.createSuccess("��¼�ɹ�", user);
	}

	@Override
	public ServerResponse<List<User>> pageList(Integer page, Integer limit) {
		//1�����÷�ҳ
		PageHelper.startPage(page, limit);
		//2��ִ�в�ѯ ����ҳ֮������ݣ�
		List<User> list = userMapper.pageList();
		//3��count
		//��һ�֣���ҳʱ��ʵ�ʷ��صĽ��list������Page<E>�������ȡ����ҳ��Ϣ����Ҫǿ��ת��ΪPage<E>
		//Integer count = (int) ((Page) list).getTotal();
		//�ڶ��֣���PageInfo�Խ�����а�װ
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();
		return ServerResponse.createSuccess("��ѯ�ɹ�", count, list);
	}
	
	
	
	

}
