package com.Activity;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.Activity.MenuActivity;
import com.Activity.R;
import com.useFileInSD.UseFileInSD;

public class SendMailActivity extends Activity {

	static final int NOTIFICATION_ID = 0x123;
	private ImageButton send;
	private ImageButton back;
	private ImageButton save;

	private EditText mailEd;
	private EditText addresseeEd;

	private String addressee;// 收件人

	private String mailId;
	private NotificationManager nm;
	private UseFileInSD fileInSD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_mail);
		initView();

		// DateFormat df = DateFormat.getDateInstance();

		fileInSD = new UseFileInSD();
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = sDateFormat.format(new java.util.Date());

		mailId = date + "mail";

		// 获取Notification系统服务
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// 返回按钮
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// 保存按钮
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					String mail = mailEd.getText().toString();
					fileInSD.saveMail(mail, mailId);
					Toast.makeText(SendMailActivity.this, "保存成功", 3000).show();

				} catch (Exception e) {
					Toast.makeText(SendMailActivity.this, "保存失败", 3000).show();
					e.printStackTrace();
				}
			}

		});

		// 发送按钮
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String mail = mailEd.getText().toString();

				Toast.makeText(SendMailActivity.this, "信件内容为" + mail, 3000)
						.show();

				Intent intent = new Intent(SendMailActivity.this,
						MenuActivity.class);
				PendingIntent pi = PendingIntent.getActivity(
						SendMailActivity.this, 0, intent, 0);
				Notification notify = new Notification.Builder(
						SendMailActivity.this).setAutoCancel(true)
						.setTicker("信件发送成功")
						.setSmallIcon(R.drawable.ic_launcher_72)
						.setContentTitle("来自ManChat").setContentText(mail)
						.setWhen(System.currentTimeMillis())
						.setContentIntent(pi).build();
				nm.notify(NOTIFICATION_ID, notify);
				//发送文件
				sendMial();

			}

		});
	}

	private void sendMial() {
		// TODO Auto-generated method stub

	}

	public void initView() {
		send = (ImageButton) findViewById(R.id.send);
		back = (ImageButton) findViewById(R.id.back);
		save = (ImageButton) findViewById(R.id.save);
		mailEd = (EditText) findViewById(R.id.mail);
		addresseeEd = (EditText) findViewById(R.id.addressee);

	}
	/*
	 * public void listener() { back.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View v) { finish(); } });
	 * 
	 * save.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View v) { try { UseFileInSD.saveMail(mail,
	 * mailId); } catch (Exception e) { Toast.makeText(SendMailActivity.this,
	 * "保存失败", 3000).show(); e.printStackTrace(); } } }); }
	 */
}
