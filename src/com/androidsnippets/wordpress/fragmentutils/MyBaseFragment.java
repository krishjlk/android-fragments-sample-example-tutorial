package com.androidsnippets.wordpress.fragmentutils;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;

public class MyBaseFragment extends Fragment
{
	private boolean removeFragment = false;
	
	public void removeThisFragment() 
	{
		removeFragment = true;
		
		Fragment fragment = getFragmentManager().findFragmentByTag(getTag());
		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = manager.beginTransaction(); 
		
		fragmentTransaction.remove(fragment);
		
		fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		fragmentTransaction.commit();
	}
	
	public void createNewFragment(Fragment newFragment) 
	{
		Fragment fragment = getFragmentManager().findFragmentByTag(getTag());
		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = manager.beginTransaction(); 
		
		fragmentTransaction.replace(fragment.getId(), newFragment,newFragment.getClass().getSimpleName());
		fragmentTransaction.addToBackStack(null);
		//fragmentTransaction.show(newFragment);
		fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		fragmentTransaction.commit();
	}
	
	public void showExistingFragment(String existingFragmentTagName, boolean clearFragmentTop) 
	{
		
		Fragment fragment = getFragmentManager().findFragmentByTag(getTag());
		Fragment existingFragment = getFragmentManager().findFragmentByTag(existingFragmentTagName);

		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = manager.beginTransaction(); 
		
		
		if(clearFragmentTop)
		{
			int count  = manager.getBackStackEntryCount();
			
			for(int i=(count-1); i>0; i--)
			{
			   BackStackEntry backStackEntry = manager.getBackStackEntryAt(i);
		
			   int id =  backStackEntry.getId();
			   String currentFragmentName =  backStackEntry.getName();
			   
			   //if(currentFragmentName.equalsIgnoreCase(existingFragmentTagName))
			   {
				  manager.popBackStack();
			   }
			}
			
			 //  manager.popBackStack(); // removes the current fragment
			 // manager.popBackStackImmediate(); // removes the current fragment
			
		}
		else
		{
			fragmentTransaction.replace(fragment.getId(),existingFragment);
			//fragmentTransaction.replace(fragment.getId(),getFragmentManager().findFragmentByTag(existingFragmentTagName));
			//fragmentTransaction.show(existingFragment);
		}
		
		fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		fragmentTransaction.commit();
	}
	
	@Override
	public void onDestroyView() 
	{
		super.onDestroyView();
		
		if(removeFragment)
	    getActivity().finish();
	}
}
