package com.mailBase;

import java.text.DateFormat;
import java.util.Date;

public class mailBase implements sendInterface {

	public String sendDate;// 发送时间
	public String sendId;// 发件人ID
	public String aimId;// 收件人ID
	public String content;// 信件的文本内容

	// 信件类的构造函数
	public mailBase() {
		setSendTime();

	}

	@Override
	public boolean ifText() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean ifPicture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ifSendSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makePackage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSendTime() {
		Date now = new Date();
		DateFormat df = DateFormat.getDateInstance();
		sendDate = df.format(now);

		// TODO Auto-generated method stub

	}

/*	// get信件文本内容，用于接收从Activity中发送过来的文本
	public String getContext() {
		return Context;

	}
*/
}
