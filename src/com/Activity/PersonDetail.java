package com.Activity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class PersonDetail extends Activity {
	private EditText changeName;
	private EditText changeAdd;
	private EditText changePC;
	private EditText changeMottoo;
	
	private SharedPreferences S;
	private SharedPreferences.Editor E;
	
	private Button CommitChange;
	private Button Back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_detail);
		changeName = (EditText)findViewById(R.id.ChangeName);
		changeAdd =(EditText)findViewById(R.id.ChangeAdd);
		changePC =(EditText)findViewById(R.id.ChangePC);
		changeMottoo =(EditText)findViewById(R.id.ChangeMottoo);
		
		CommitChange = (Button)findViewById(R.id.CommitChange);
		Back = (Button)findViewById(R.id.Up_detail);
		
		S = getSharedPreferences("User", MODE_WORLD_WRITEABLE);
		E = S.edit();
		
		CommitChange.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				E.putString("Name", changeName.getText().toString());
				E.putString("Add", changeAdd.getText().toString());
				E.putString("PC", changePC.getText().toString());
				E.putString("Mottoo", changeMottoo.getText().toString());
				E.commit();
				PersonDetail.this.finish();
			}
		});
		
		Back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PersonDetail.this.finish();
			}
		});
	}
}
