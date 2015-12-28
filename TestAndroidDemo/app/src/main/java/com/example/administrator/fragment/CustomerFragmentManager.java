package com.example.administrator.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.administrator.testandroiddemo.R;

/**
 * Created by Administrator on 2015/12/7.
 */
public class CustomerFragmentManager
{
    private FragmentManager fragmentManager = null;
    private Activity mActivity = null;
    private int fragmentContent;

    public static CustomerFragmentManager forContainer(Activity activity, int contentId, FragmentManager fragmentManager)
    {
         return new CustomerFragmentManager(activity, contentId, fragmentManager);
    }

    CustomerFragmentManager(Activity activity, int contentId, FragmentManager fragmentManager)
    {
        this.mActivity = activity;
        fragmentContent = contentId;
        if(fragmentManager == null)
        {
            this.fragmentManager = activity.getFragmentManager();
        }
        else
        {
            this.fragmentManager = fragmentManager;
        }


    }

    void initFragmentContent(int id)
    {
        fragmentContent = id;
    }

    void setFragmentContent(int id)
    {
        fragmentContent = id;
    }

    int getFragmentContent()
    {
        return fragmentContent;
    }

    Activity getFramentContentActivity(){return mActivity;}

    public Fragment findFragmentById(int id)
    {
        if(fragmentManager != null)
            return fragmentManager.findFragmentById(id);
        return null;
    }

    public void replaceFragment(Fragment fragment, boolean isAddToBack)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(fragmentContent, fragment);
        if(isAddToBack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    };

    public boolean popFragment()
    {
        return fragmentManager.popBackStackImmediate();
    }
}
