package com.nekogee.licorice;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;



/**
 * Created by hui jie on 2018/4/6.
 */

public class MainActivity extends  AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(Color.BLACK);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        //startActivity(intent);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        //未读消息提示
        TextBadgeItem numberBadgeItem=new TextBadgeItem();

        BottomNavigationBar bottomNavigationBar= (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        //bottomNavigationBar.setFab(floatingActionButton);
        bottomNavigationBar.clearAll();

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        // bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_black_36dp,"首页").setActiveColorResource(R.color.colorMain))
                .addItem(new BottomNavigationItem(R.drawable.ic_view_module_black_24dp,"分区").setActiveColorResource(R.color.colorMain))
                .addItem(new BottomNavigationItem(R.drawable.ic_view_day_black_24dp, "动态").setActiveColorResource(R.color.colorMain))
                .addItem(new BottomNavigationItem(R.drawable.ic_perm_identity_black_36dp, "我的").setActiveColorResource(R.color.colorMain))
                .setFirstSelectedPosition(0)
                .initialise();
        //默认初始活动
        replaceFragment(new HomePageActivity());

        //下方导航栏的选择事件
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0: {
                        Log.d("qqqq","000b");
                        replaceFragment(new HomePageActivity());
                        Log.d("qqqq","000a");
                    }
                        break;
                    case 1:  {
                        Log.d("qqqq","111b");
                        replaceFragment(new CategoryActivity());
                        Log.d("qqqq","111b");
                    }
                        break;
                    case 2: replaceFragment(new TrendActivity());
                        break;
                    case 3: replaceFragment(new UserHomeActivity());
                        break;
                    default:
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    private void replaceFragment(android.support.v4.app.Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        Log.d("qqqq","ino");
        transaction.commit();
    }
}
