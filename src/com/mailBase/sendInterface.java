package com.mailBase;

public interface sendInterface {

	// �ж��Ƿ��Ǵ��ı��ż�
	public boolean ifText();

	// �Ƿ�ͼƬ�ļ�
	public boolean ifPicture();

	// �Ƿ�ɹ�����
	public boolean ifSendSuccess();

	// ���Ͷ���
	public void send();

	// ���浽����
	public void save();
	
	//�������
	public void makePackage();
	
	//���÷���ʱ��
	public void setSendTime();
	
	

}
