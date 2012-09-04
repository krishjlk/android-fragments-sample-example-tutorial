package com.androidsnippets.wordpress.fragmentutils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.LinearLayout;

public abstract class MyBaseFragmentActivity extends FragmentActivity 
{
	LinearLayout tab_content;
	Fragment currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		tab_content = new LinearLayout(this);
		tab_content.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT));
		tab_content.setScrollContainer(true);
		tab_content.setId(585);
		setContentView(tab_content);
	}

	/**
	 * @param newFragment fragment which you want to display in the tab
	 */
	public void navigateTo(Fragment newFragment,String tag) 
	{
		currentFragment = newFragment;
		
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		
		// What if i press home  ????????????????
		
		ft.replace(tab_content.getId(), newFragment,tag);
		ft.addToBackStack(null);
		
		ft.commit();
	}

	@Override
	public void onBackPressed() 
	{
		FragmentManager manager = getSupportFragmentManager();
	
		if(currentFragment!=null)
		{
			String tag = currentFragment.getTag();
			Log.d("tag", ""+tag);
			
			if(tag.equalsIgnoreCase("something"))
			{
				// do something 
			}
		}
		
		if (manager.getBackStackEntryCount() > 1) 
		{
			super.onBackPressed();
		} 
		else 
		{
			finish();
		}
	}
	
	public void clearStack()
	{
		FragmentManager manager = getSupportFragmentManager();
		
		while(manager.getBackStackEntryCount() > 1)
	    manager.popBackStack();
		
	}

}
