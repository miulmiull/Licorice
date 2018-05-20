package com.nekogee.licorice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hui jie on 2018/4/6.
 */

public class StoreActivity extends Fragment {
    private List<StoreItem> storeItemList = new ArrayList<>();
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_store ,container,false);
        recyclerView = view.findViewById(R.id.store_recyclerView);
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(1);
        dividerLine.setColor(0xFFDDDDDD);
        recyclerView.addItemDecoration(dividerLine);
        recyclerView.addItemDecoration(dividerLine);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createStore();
        Log.d("hhh", "onActivityCreated: ");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        StoreItemAdapter adapter = new StoreItemAdapter(storeItemList);
        Log.d("hhh", "onActivityCreated: ");
        recyclerView.setAdapter(adapter);
    }
    private void createStore() {
        for (int i = 0; i < 3; ++i) {
            StoreItem storeItem1 = new StoreItem(R.drawable.pic_b2,"大自然的声音","1");
            storeItemList.add(storeItem1);
            StoreItem storeItem2 = new StoreItem(R.drawable.pic_b5,"女声","12");
            storeItemList.add(storeItem2);
            StoreItem storeItem3 = new StoreItem(R.drawable.pic_b6,"钢琴旋律","23");
            storeItemList.add(storeItem3);
            StoreItem storeItem4 = new StoreItem(R.drawable.pic_b7,"经典采样","65");
            storeItemList.add(storeItem4);
            StoreItem storeItem5 = new StoreItem(R.drawable.pic_b8,"Loops","34");
            storeItemList.add(storeItem5);
            StoreItem storeItem6 = new StoreItem(R.drawable.pic_b1,"声音特效","61");
            storeItemList.add(storeItem6);
            StoreItem storeItem7 = new StoreItem(R.drawable.pic_store_1,"声音特效","61");
            storeItemList.add(storeItem7);
            StoreItem storeItem8 = new StoreItem(R.drawable.pic_store_2,"声音特效","61");
            storeItemList.add(storeItem8);
            StoreItem storeItem9 = new StoreItem(R.drawable.pic_store_3,"声音特效","61");
            storeItemList.add(storeItem9);
        }
    }
}
