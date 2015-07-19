package com.Activity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class Welcome extends Activity {
	private SharedPreferences S;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		S = getSharedPreferences("User", MODE_WORLD_WRITEABLE);
		setContentView(R.layout.activity_welcome);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				if(S.contains("Name"))
				{
					Intent mainIntent = new Intent(Welcome.this,MenuActivity.class); 
					Welcome.this.startActivity(mainIntent);                                
					Welcome.this.finish();                               
					overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				}
				else{
					Intent mainIntent = new Intent(Welcome.this,LogInActivity.class); 
					Welcome.this.startActivity(mainIntent);                                
					Welcome.this.finish();                               
					overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
					
				}
			}                
		}, 5000);		
	}
}
