package com.mailBase;

public interface sendInterface {

	// 判断是否是纯文本信件
	public boolean ifText();

	// 是否纯图片文件
	public boolean ifPicture();

	// 是否成功发送
	public boolean ifSendSuccess();

	// 发送动作
	public void send();

	// 保存到本地
	public void save();
	
	//打包数据
	public void makePackage();
	
	//设置发送时间
	public void setSendTime();
	
	

}
