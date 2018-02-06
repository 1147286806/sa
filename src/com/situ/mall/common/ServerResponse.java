package com.situ.mall.common;

import java.io.Serializable;
import java.util.List;

import com.situ.mall.entity.User;

public class ServerResponse<T> implements Serializable {
	//��ǰ״̬������Ա�ж�״̬��:�ɹ���ʧ�ܡ�δ��¼��û��Ȩ��
	private Integer status;
	//������Ϣ����Ҫ�Ǹ��û�������ʾ��Ϣ��
	private String msg;
	//������
	private Integer count;
	//��̨���ظ�ǰ�˵�����
	private T data;

	private ServerResponse() {
	}

	private ServerResponse(Integer status) {
		this.status = status;
	}

	private ServerResponse(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	private ServerResponse(Integer status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	

	public ServerResponse(Integer status, String msg, Integer count, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	//ֻ�Ǹ���ǰ̨���ɹ�����״̬
	public static <T> ServerResponse<T> createSuccess() {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
	}

	//����ǰ̨��status,msg
	public static <T> ServerResponse<T> createSuccess(String msg) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
	}

	//����ǰ̨��status,msg,data
	public static <T> ServerResponse<T> createSuccess(String msg, T data) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
	}
	
	//����ǰ̨��code,msg,count,data
	public static <T> ServerResponse<T> createSuccess(String msg, Integer count, T data) {
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, count, data);
	}

	//ֻ�Ǹ���ǰ̨��ʧ������״̬
	public static <T> ServerResponse<T> createError() {
		return new ServerResponse<>(ResponseCode.ERROR.getCode());
	}

	//����ǰ̨��status,msg
	public static <T> ServerResponse<T> createError(String msg) {
		return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg);
	}

	//����ǰ̨��status,msg,data
	public static <T> ServerResponse<T> createError(String msg, T data) {
		return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg, data);
	}

	public boolean isSuccess() {
		return status == ResponseCode.SUCCESS.getCode();
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public static void main(String[] args) {
		System.out.println(ResponseCode.ERROR.getCode());
	}

}
