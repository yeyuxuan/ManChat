package com.userBase;

import java.text.DateFormat;
import java.util.Date;

import android.graphics.Bitmap;

public class User {
	public String ID;// �û�ID
	public String passWord;//�û�����
	public String date;// ע������
	public String UserName;// �û��ǳ�
	public String address;// ��ַ
	public String postCode;// �ʱ�
	public String Tel;// �ֻ���
	public Bitmap headPhoto;// ͷ��
	int num = 1;// ����ע����

	// ���캯��
	public User(String UserName, String address, String postCode, String Tel,
			Bitmap headPhoto) {
		// date�Ĺ�����Date�����
		Date now = new Date();
		DateFormat df = DateFormat.getDateInstance();
		this.date = df.format(now);

		this.UserName = UserName;
		this.address = address;
		this.postCode = postCode;
		this.Tel = Tel;
		this.headPhoto = headPhoto;

	}

	// ����ID�ĺ�������num��date��Tel��������
	public void createUserID() {
		this.ID = this.num + this.date + this.Tel;
		this.num++;
	}
}

/*
 * �ж��ǳ��Ƿ���� public boolean ifIdIsExsit() { return false; }
 */
