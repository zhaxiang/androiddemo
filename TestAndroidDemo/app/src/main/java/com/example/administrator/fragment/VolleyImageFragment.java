package com.example.administrator.fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.BaseApplication;
import com.example.administrator.data.AppInfo;
import com.example.administrator.utils.Constants;
import com.example.administrator.fragment.adapter.AppInfoAdapter;
import com.example.administrator.testandroiddemo.R;
import com.example.administrator.view.AutoListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/11.
 */
public class VolleyImageFragment extends BaseFragment
{
    private final  String TAG = VolleyFragment.class.getSimpleName();

    private ImageView imageView1 = null;
    private ImageView imageView2 = null;
    private ImageView imageView3 = null;
    private ImageView imageView4 = null;

    private TextView textView1 = null;
    private TextView textView2 = null;
    private TextView textView3 = null;
    private TextView textView4 = null;

    private AutoListView listView;
    private AppInfoAdapter appInfoAdapter;

    @Override
    protected void findViews(View v)
    {
        imageView1 = (ImageView)(v.findViewById(R.id.firstItem)).findViewById(R.id.iconImageView);
        imageView2 = (ImageView)(v.findViewById(R.id.secondItem)).findViewById(R.id.iconImageView);
        imageView3 = (ImageView)(v.findViewById(R.id.thirdItem)).findViewById(R.id.iconImageView);
        imageView4 = (ImageView)(v.findViewById(R.id.fourthItem)).findViewById(R.id.iconImageView);

        textView1 = (TextView)(v.findViewById(R.id.firstItem)).findViewById(R.id.appNameLabel);
        textView2 = (TextView)(v.findViewById(R.id.secondItem)).findViewById(R.id.appNameLabel);
        textView3 = (TextView)(v.findViewById(R.id.thirdItem)).findViewById(R.id.appNameLabel);
        textView4 = (TextView)(v.findViewById(R.id.fourthItem)).findViewById(R.id.appNameLabel);

        listView = (AutoListView)v.findViewById(R.id.volleyList);
    }

    @Override
    protected void initViews(Bundle var)
    {
        BaseApplication.application.getVolleyManager().getImageByUrl(Constants.imageUrl[0], imageView1);
        BaseApplication.application.getVolleyManager().getImageByUrl(Constants.imageUrl[1], imageView2);
        BaseApplication.application.getVolleyManager().getImageByUrl(Constants.imageUrl[2], imageView3);
        BaseApplication.application.getVolleyManager().getImageByUrl(Constants.imageUrl[3], imageView4);

        ArrayList<AppInfo> infos = new ArrayList<AppInfo>();

        for(int i = 0; i < 40; i++)
        {
            AppInfo info = new AppInfo();
            String url = "http://img1.3lian.com/img2011/w10/1019/5/" + (i + 1) + ".jpg";
            info.setAppUrl(url);
            info.setAppName(String.valueOf(i));
            infos.add(info);
        }

        appInfoAdapter = new AppInfoAdapter(getActivity(), infos);
        listView.setAdapter(appInfoAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.v(TAG, "position =" + position);
                Toast.makeText(getActivity().getApplicationContext(), "current item pos index = " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData(Bundle var)
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(null !=  appInfoAdapter)
        {
            if(appInfoAdapter.getInfos().size() > 0)
            {
                Log.v(TAG, "onCreate size > 0");
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_volley_image, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        Log.v(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        Log.v(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        initViews(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Log.v(TAG, "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }
}
