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
	
	private EditText RegisterUserTel;// ע��ID
	private EditText RegisterPassWord;// ע������
	private EditText ConfirmPassWord;// ȷ�������Ƿ���ȷ
	private EditText RegisterUserPostcode;// ע���ʱ���Ϣ
	private EditText RegisterUserAddress;// ע���ַ��Ϣ
	private EditText RegisterUserName;//ע���ǳ�

	private String Tel;
	private String Password;
	private String Password_;
	private String PostCode;
	private String Add;
    private String Name;
	
	private SharedPreferences UserP;
	private SharedPreferences.Editor UserE;
	// ��ʼ�������ĺ���
	private void initdate() {
		Tel = RegisterUserTel.getText().toString();
		Password = RegisterPassWord.getText().toString();
		Password_ = ConfirmPassWord.getText().toString();
		Add = RegisterUserAddress.getText().toString();
		Name = RegisterUserName.getText().toString();
		PostCode = RegisterUserPostcode.getText().toString();
	}

	// ��ʼ��View�ĺ���
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
		// ��ʱ�Ĳ��Լ�����
		Register = (Button) findViewById(R.id.RegisterButton);
		Register.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initdate();
				if(Name == null ||Tel == null||Password == null||PostCode ==null){
					Toast t = Toast.makeText(RegisterActivity.this, "����ȫѡ��", 100);
					t.show();
				}else if(Tel.length()!=11){
					Toast t = Toast.makeText(RegisterActivity.this, "����д��ȷ���ֻ�����", 100);
					t.show();
				}else if(!Password.equals(Password_)){
					Toast t = Toast.makeText(RegisterActivity.this, "�ظ����벻��ȷ", 100);
					t.show();
				}else{
					UserE.putString("Tel", Tel);
					UserE.putString("PW", Password);
					UserE.putString("PC", PostCode);
					UserE.putString("Add", Add);
					UserE.putString("Name", Name);
					UserE.commit();
					Toast t = Toast.makeText(RegisterActivity.this, "ע��ɹ�", 100);
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
