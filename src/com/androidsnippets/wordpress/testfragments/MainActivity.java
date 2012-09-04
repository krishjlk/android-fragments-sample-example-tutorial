package com.androidsnippets.wordpress.testfragments;

import com.androidsnippets.wordpress.testfragments.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity  
{
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);
      
        setupTabLayout();
    }

	private void setupTabLayout() 
	{
		  
        TabHost tabHost = getTabHost();
        
        
        TabHost.TabSpec tabA = tabHost.newTabSpec("tag1")
        		                      .setContent(new Intent(this, TabA.class))
        		                      .setIndicator("Tab A"); 
        tabHost.addTab(tabA);
        
        
        TabHost.TabSpec tabB =  tabHost.newTabSpec("tag2")
                					   .setContent(new Intent(this, TabB.class))
                					   .setIndicator("Tab B"); 
        tabHost.addTab(tabB);
        
        
        
        TabHost.TabSpec tabC = tabHost.newTabSpec("tag3")
                					  .setContent(new Intent(this, TabC.class))
                					  .setIndicator("Tab C"); 
        tabHost.addTab(tabC);
 
        
        if(Build.VERSION.SDK_INT>=8)
        {
        	//tabHost.getTabWidget().setStripEnabled(false);
        }
        
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setCurrentTab(0);
	}
}
