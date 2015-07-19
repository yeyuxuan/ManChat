package com.Activity;

import com.Activity.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class Person_Info extends Activity {
	private Button Down;
	private TextView Name;
	private TextView Add;
	private TextView PC;
	private TextView Motto;
	
	private TextView back;
	
	private SharedPreferences S;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person__info);
		Name = (TextView)findViewById(R.id.Name_card);
		Add = (TextView)findViewById(R.id.Add);
		PC = (TextView)findViewById(R.id.PC);
		Motto = (TextView)findViewById(R.id.Mottoo);
		S=getSharedPreferences("User", MODE_WORLD_WRITEABLE);
		Down = (Button)findViewById(R.id.button1);
		back = (TextView)findViewById(R.id.textView1);
		
		Name.setText(S.getString("Name", null));
		Add.setText(S.getString("Add", null));
		PC.setText(S.getString("PC", null));
		Motto.setText(S.getString("Mottoo", null));
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Person_Info.this.finish();
			}
		});
		
		Down.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Person_Info.this,PersonDetail.class);
				startActivity(i);
			}
		});
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		setContentView(R.layout.activity_person__info);
		Name = (TextView)findViewById(R.id.Name_card);
		Add = (TextView)findViewById(R.id.Add);
		PC = (TextView)findViewById(R.id.PC);
		Motto = (TextView)findViewById(R.id.Mottoo);
		S=getSharedPreferences("User", MODE_WORLD_WRITEABLE);
		Down = (Button)findViewById(R.id.button1);
		back = (TextView)findViewById(R.id.textView1);
		
		Name.setText(S.getString("Name", null));
		Add.setText(S.getString("Add", null));
		PC.setText(S.getString("PC", null));
		Motto.setText(S.getString("Mottoo", null));
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Person_Info.this.finish();
			}
		});
		
		Down.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Person_Info.this,PersonDetail.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person__info, menu);
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
