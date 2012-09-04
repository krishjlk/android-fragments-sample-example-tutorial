package com.androidsnippets.wordpress.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidsnippets.wordpress.fragmentutils.MyBaseFragment;
import com.androidsnippets.wordpress.testfragments.NewActivity;
import com.androidsnippets.wordpress.testfragments.R;

public class FragmentB2 extends MyBaseFragment
{
	private FragmentActivity activity; // activity/context you can use to call any explicit activities like email,sms,etc...
    private int layout_to_inflate; // layout which you want to show
    private Bundle bundle; // Arguments which you want to pass to fragment
	
    
	public FragmentB2(int layout) 
	{
	  layout_to_inflate = layout;
	}
	
	public FragmentB2() 
	{
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		activity = super.getActivity();
		LinearLayout ll = (LinearLayout) inflater.inflate(layout_to_inflate, container, false);
		
		ll.findViewById(R.id.btn_home).setVisibility(View.GONE);
		
		ll.findViewById(R.id.btn_back).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				showExistingFragment(FragmentB1.class.getSimpleName(), false);
			}
		});
		
		Button btn_next = (Button) ll.findViewById(R.id.btn_next); 
		btn_next.setText("Start New Activity");
		
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(v.getContext(),NewActivity.class);
				startActivityForResult(intent,585);
			}
		});
	    
		return ll;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if(data!=null && data.hasExtra("result"))
		{ 	
		  TextView textView = (TextView) getActivity().findViewById(R.id.txt_fragment);
		  textView.append("\nResult : "+data.getStringExtra("result"));
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    bundle = getArguments();
	}
	
	@Override
	public void onDestroy() 
	{
		super.onDestroy();
	}
}