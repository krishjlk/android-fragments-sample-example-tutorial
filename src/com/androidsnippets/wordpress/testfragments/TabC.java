package com.androidsnippets.wordpress.testfragments;

import android.os.Bundle;

import com.androidsnippets.wordpress.fragments.FragmentC1;
import com.androidsnippets.wordpress.fragmentutils.MyBaseFragmentActivity;
import com.androidsnippets.wordpress.testfragments.R;

public class TabC extends MyBaseFragmentActivity
{
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
	   super.onCreate(savedInstanceState);
	   
	   FragmentC1 fragmentC1 = new FragmentC1(R.layout.fragment_layout_c1);
	   navigateTo(fragmentC1,fragmentC1.getClass().getSimpleName());
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