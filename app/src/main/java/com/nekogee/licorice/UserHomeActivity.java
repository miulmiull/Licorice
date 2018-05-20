package com.nekogee.licorice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class UserHomeActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("qqqq","out");

        View view = inflater.inflate(R.layout.activity_user_home, container, false);

        Log.d("qqqq","out");

        LinearLayout linearLayout = view.findViewById(R.id.tab_2);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Log.d("pppp","b4add");
                Intent intent = new Intent(getActivity().getApplicationContext(),StoreREALActivity.class);
                Log.d("pppp","b4add");
                //tartActivity(intent);
                //Intent intent = new Intent(UserHomeActivity.this,UserHomePageActivity.class);
                startActivity(intent);
                //replaceFragment(new StoreActivity());
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("qqqq","in");
        super.onActivityCreated(savedInstanceState);
        Log.d("qqqq","in");

    }
    private void changeToAnotherFragment(){
        //如果是用的v4的包，则用getActivity().getSuppoutFragmentManager();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        //注意v4包的配套使用
        Fragment fragment = new UserHomeActivity();
        fm.beginTransaction().replace(R.id.fragment,fragment).commit();
    }

    private void replaceFragment(android.support.v4.app.Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        Log.d("qqqq","ino");
        transaction.commit();
        Log.d("qqqq","ino!!!");
    }
}
