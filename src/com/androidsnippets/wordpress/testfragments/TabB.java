package com.androidsnippets.wordpress.testfragments;

import android.os.Bundle;

import com.androidsnippets.wordpress.fragments.FragmentB1;
import com.androidsnippets.wordpress.fragmentutils.MyBaseFragmentActivity;
import com.androidsnippets.wordpress.testfragments.R;

public class TabB extends MyBaseFragmentActivity
{
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
	   super.onCreate(savedInstanceState);
	   FragmentB1 fragmentB1 = new FragmentB1(R.layout.fragment_layout_b1);
	   navigateTo(fragmentB1,fragmentB1.getClass().getSimpleName());
   }
   
    @Override
	protected void onDestroy() 
    {
		super.onDestroy();
	}
    
    @Override
    protected void onResume() 
    {
       super.onResume();
    }
}