package com.nekogee.licorice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private List<StoreItem> storeItemList = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        createStore();
        recyclerView = (RecyclerView) findViewById(R.id.store_recyclerView);
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(1);
        dividerLine.setColor(0xFFDDDDDD);
        recyclerView.addItemDecoration(dividerLine);
        recyclerView.addItemDecoration(dividerLine);
        Log.d("hhh", "onActivityCreated: ");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        StoreItemAdapter adapter = new StoreItemAdapter(storeItemList);
        Log.d("hhh", "onActivityCreated: ");
        recyclerView.setAdapter(adapter);


        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
