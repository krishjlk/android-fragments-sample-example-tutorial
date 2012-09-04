package com.androidsnippets.wordpress.testfragments;

import android.os.Bundle;

import com.androidsnippets.wordpress.fragments.FragmentA1;
import com.androidsnippets.wordpress.fragmentutils.MyBaseFragmentActivity;
import com.androidsnippets.wordpress.testfragments.R;

public class TabA extends MyBaseFragmentActivity
{
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
	   super.onCreate(savedInstanceState);

	   FragmentA1 fragmentA1 = new FragmentA1(R.layout.fragment_layout_a1);
	   Bundle bundle = new Bundle();
	   bundle.putString("hi", "asdasd");
	   fragmentA1.setArguments(bundle);
	   
	   navigateTo(fragmentA1,fragmentA1.getClass().getSimpleName());
   }
   
    @Override
	protected void onDestroy() 
    {
		super.onDestroy();
	}
    
     @Override
    	protected void onStop() 
        {
    		super.onStop();
    	}
    
    
        @Override
    	protected void onResume() 
       {
    		super.onResume();
       }
}