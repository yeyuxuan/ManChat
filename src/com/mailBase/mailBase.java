package com.mailBase;

import java.text.DateFormat;
import java.util.Date;

public class mailBase implements sendInterface {

	public String sendDate;// ����ʱ��
	public String sendId;// ������ID
	public String aimId;// �ռ���ID
	public String content;// �ż����ı�����

	// �ż���Ĺ��캯��
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

/*	// get�ż��ı����ݣ����ڽ��մ�Activity�з��͹������ı�
	public String getContext() {
		return Context;

	}
*/
}
