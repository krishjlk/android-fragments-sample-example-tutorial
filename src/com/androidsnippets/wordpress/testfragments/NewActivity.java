package com.androidsnippets.wordpress.testfragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.androidsnippets.wordpress.testfragments.R;

public class NewActivity extends FragmentActivity
{
  @Override
protected void onCreate(Bundle savedInstanceState) 
  {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.new_activity);
	
	findViewById(R.id.btn_back).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) 
		{
			finish();
		}
	});
    
	
	findViewById(R.id.btn_send_result).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) 
		{
			EditText editText = (EditText) findViewById(R.id.et_result);
			String result = editText.getText().toString().trim();
			
			Intent intent = new Intent();
			intent.putExtra("result",result);
			setResult(Activity.RESULT_OK, intent);
			
			finish();
		}
	});
  }
}
