package com.mailBase;

public class DIYCard implements sendInterface {

	public String sendDate;// 发送时间
	public String sendId;// 发件人ID
	public String aimId;// 收件人ID

	@Override
	public boolean ifText() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		
	}

}
