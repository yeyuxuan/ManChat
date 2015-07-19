package com.userBase;

import java.text.DateFormat;
import java.util.Date;

import android.graphics.Bitmap;

public class User {
	public String ID;// 用户ID
	public String passWord;//用户密码
	public String date;// 注册日期
	public String UserName;// 用户昵称
	public String address;// 地址
	public String postCode;// 邮编
	public String Tel;// 手机号
	public Bitmap headPhoto;// 头像
	int num = 1;// 本日注册编号

	// 构造函数
	public User(String UserName, String address, String postCode, String Tel,
			Bitmap headPhoto) {
		// date的构造由Date类完成
		Date now = new Date();
		DateFormat df = DateFormat.getDateInstance();
		this.date = df.format(now);

		this.UserName = UserName;
		this.address = address;
		this.postCode = postCode;
		this.Tel = Tel;
		this.headPhoto = headPhoto;

	}

	// 生成ID的函数，将num和date和Tel连接起来
	public void createUserID() {
		this.ID = this.num + this.date + this.Tel;
		this.num++;
	}
}

/*
 * 判断昵称是否存在 public boolean ifIdIsExsit() { return false; }
 */
