package com.androidsnippets.wordpress.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.androidsnippets.wordpress.fragmentutils.MyBaseFragment;
import com.androidsnippets.wordpress.testfragments.R;

public class FragmentC1 extends MyBaseFragment
{
	private FragmentActivity activity; // activity/context you can use to call any explicit activities like email,sms,etc...
    private int layout_to_inflate; // layout which you want to show
    private Bundle bundle; // Arguments which you want to pass to fragment
	
	public FragmentC1(int layout) 
	{
	  layout_to_inflate = layout;
	}
	
	public FragmentC1() 
	{
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		activity = super.getActivity();
		LinearLayout ll = (LinearLayout) inflater.inflate(layout_to_inflate, container, false);
		ll.findViewById(R.id.btn_home).setVisibility(View.GONE);
		ll.findViewById(R.id.btn_next).setVisibility(View.GONE);
		ll.findViewById(R.id.btn_back).setVisibility(View.GONE);
	    return ll;
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