package com.Activity;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Activity.R;
import com.useFileInSD.*;

;
public class LogInActivity extends Activity {
	private TextView Register;
	private Button LogIn;
	private EditText UT;
	private EditText PassWord;
	public String Tel;// 用户ID
	public String PW;// 用户密码
	
	private SharedPreferences SP;

	boolean ifLogSuccess = true;// 登陆成功标记

	SharedPreferences preference;
	SharedPreferences.Editor LogEditor;
	/*
	 * private void initView() { Register = (TextView)
	 * findViewById(R.id.Register); }
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		Register = (TextView) findViewById(R.id.Register);
		LogIn = (Button) findViewById(R.id.LogIn);
		UT = (EditText)findViewById(R.id.UserAccount);
		PassWord = (EditText)findViewById(R.id.PassWord);
		SP=getSharedPreferences("User", MODE_WORLD_WRITEABLE);

		// 设置登陆按钮监视器
		LogIn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Tel = UT.getText().toString();
				PW = PassWord.getText().toString();
				if(Tel.equals(SP.getString("Tel", null))&&PW.equals(SP.getString("PW", null))){
					Toast t = Toast.makeText(LogInActivity.this, "登陆成功:)", 100);
					t.show();
					Intent i = new Intent();
					i.setClass(LogInActivity.this,MenuActivity.class );
					startActivity(i);
					LogInActivity.this.finish();
					}
				else{
					Toast t = Toast.makeText(LogInActivity.this, "密码错误：（", 100);
					t.show();
					PassWord.setText("");
					}
				}
			});
		// 设置注册监听器
		Register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LogInActivity.this,
						RegisterActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
