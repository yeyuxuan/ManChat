package com.Activity;

import org.w3c.dom.Text;

import com.Activity.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private Button BackToLog = null;
	private Button Register = null;
	
	private EditText RegisterUserTel;// 注册ID
	private EditText RegisterPassWord;// 注册密码
	private EditText ConfirmPassWord;// 确认密码是否正确
	private EditText RegisterUserPostcode;// 注册邮编信息
	private EditText RegisterUserAddress;// 注册地址信息
	private EditText RegisterUserName;//注册昵称

	private String Tel;
	private String Password;
	private String Password_;
	private String PostCode;
	private String Add;
    private String Name;
	
	private SharedPreferences UserP;
	private SharedPreferences.Editor UserE;
	// 初始化变量的函数
	private void initdate() {
		Tel = RegisterUserTel.getText().toString();
		Password = RegisterPassWord.getText().toString();
		Password_ = ConfirmPassWord.getText().toString();
		Add = RegisterUserAddress.getText().toString();
		Name = RegisterUserName.getText().toString();
		PostCode = RegisterUserPostcode.getText().toString();
	}

	// 初始化View的函数
	private void initView() {
		RegisterUserTel = (EditText) findViewById(R.id.RegisterUserTel);
		RegisterPassWord = (EditText) findViewById(R.id.RegisterPassWord);
		ConfirmPassWord = (EditText) findViewById(R.id.ConfirmPassWord);
		RegisterUserPostcode = (EditText) findViewById(R.id.RegisterUserPostcode);
		RegisterUserAddress = (EditText) findViewById(R.id.RegisterUserAddress);
		RegisterUserName = (EditText) findViewById(R.id.RegisterUserName);

		UserP = getSharedPreferences("User", MODE_WORLD_WRITEABLE);
		UserE = UserP.edit();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initView();

		BackToLog = (Button) findViewById(R.id.BackToLog);
		// 暂时的测试监听器
		Register = (Button) findViewById(R.id.RegisterButton);
		Register.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initdate();
				if(Name == null ||Tel == null||Password == null||PostCode ==null){
					Toast t = Toast.makeText(RegisterActivity.this, "请填全选项", 100);
					t.show();
				}else if(Tel.length()!=11){
					Toast t = Toast.makeText(RegisterActivity.this, "请填写正确的手机号码", 100);
					t.show();
				}else if(!Password.equals(Password_)){
					Toast t = Toast.makeText(RegisterActivity.this, "重复密码不正确", 100);
					t.show();
				}else{
					UserE.putString("Tel", Tel);
					UserE.putString("PW", Password);
					UserE.putString("PC", PostCode);
					UserE.putString("Add", Add);
					UserE.putString("Name", Name);
					UserE.commit();
					Toast t = Toast.makeText(RegisterActivity.this, "注册成功", 100);
					t.show();
					RegisterActivity.this.finish();
				}
			}
			
		});
		BackToLog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();			
				
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
