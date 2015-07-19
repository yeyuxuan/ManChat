package com.Activity;

import com.Activity.R;
import com.Activity.R.string;
import com.userBase.User;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

import com.useFileInSD.*;

public class MenuActivity extends Activity {
	public ImageView UserImg;
	public TextView UserName;
	public ImageButton MyMailBox;
	public ImageButton WritingMail;
	public ImageButton WritingCard;
	public ImageButton WritingWishingCrad;
	public ImageButton SettingMenu;

	private Drawable UserImgDraw;
	private boolean ifHasSD;
	
	private SharedPreferences S;

	private UseFileInSD fileInSD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		intiView();
		Intent intent = getIntent();
		
		UserName.setText("您好：\n"+S.getString("Name", null));
		WritingMail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this,
						SendMailActivity.class);
				startActivity(intent);
			}
		});
		
		UserImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(MenuActivity.this,Person_Info.class);
				startActivity(i);				
			}
		});

		MyMailBox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this,
						MailBoxActivity.class);
				startActivity(intent);
			}
		});

	}

	// 初始化View
	private void intiView() {
		UserImg = (ImageView) findViewById(R.id.UserImg);
		UserName = (TextView) findViewById(R.id.UserName);
		MyMailBox = (ImageButton) findViewById(R.id.my_mail_box);
		WritingMail = (ImageButton) findViewById(R.id.writing_mail);
		WritingCard = (ImageButton) findViewById(R.id.writing_card);
		WritingWishingCrad = (ImageButton) findViewById(R.id.writing_wishingcard);
		SettingMenu = (ImageButton) findViewById(R.id.setting_menu);
		S = getSharedPreferences("User", MODE_WORLD_WRITEABLE);

	}
	@Override
	protected void onResume(){
		super.onResume();
		setContentView(R.layout.activity_menu);
		intiView();
		Intent intent = getIntent();
		
		UserName.setText("您好：\n"+S.getString("Name", null));
		WritingMail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this,
						SendMailActivity.class);
				startActivity(intent);
			}
		});
		
		UserImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(MenuActivity.this,Person_Info.class);
				startActivity(i);				
			}
		});

		MyMailBox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this,
						MailBoxActivity.class);
				startActivity(intent);
			}
		});
	}

	// 下载用户头像函数
	public Drawable getUserImg(String ID) {
		// 1.从服务器端下载到与d登陆ID对应的Bitmap
		// 2.将Bitmap转换为Drawable返回
		Drawable UserImg = null;
		return UserImg;
	}
}
