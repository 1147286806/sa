package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.mapper.ProductMapper;
import com.situ.mall.service.IProductService;
import com.situ.mall.util.MD5Util;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductMapper productMapper;
		
	@Override
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit,Product product) {
		//1�����÷�ҳ
		PageHelper.startPage(page, limit);
		//2��ִ�в�ѯ ����ҳ֮������ݣ�
		List<Product> list = productMapper.pageList(product);
		//3��count
		//��һ�֣���ҳʱ��ʵ�ʷ��صĽ��list������Page<E>�������ȡ����ҳ��Ϣ����Ҫǿ��ת��ΪPage<E>
		Integer count = (int) ((Page) list).getTotal();
		//�ڶ��֣���PageInfo�Խ�����а�װ
		//PageInfo pageInfo = new PageInfo(list);
		//Integer count = (int) pageInfo.getTotal();
		return ServerResponse.createSuccess("��ѯ�ɹ�", count, list);
	}
}
