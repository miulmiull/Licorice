package com.nekogee.licorice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class TrendActivity extends Fragment {
    private List<Trend> TrendList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trend, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.trend_recyclerView);

        return view;
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createTrend();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TrendAdapter adapter = new TrendAdapter(TrendList);
        recyclerView.setAdapter(adapter);
    }

    private void createTrend() {
        for (int i = 0; i < 3; ++i) {
            Trend trend1 = new Trend(R.drawable.user_img1, "crybaby",R.drawable.pic_b1, "我的freestyle", "Nekogee",R.raw.freestyle);
            TrendList.add(trend1);
            Trend trend2 = new Trend(R.drawable.user_img1, "crybaby",R.drawable.pic_b1, "我的freestyle", "Nekogee",R.raw.freestyle);
            TrendList.add(trend2);
            Trend trend3 = new Trend(R.drawable.user_img1, "crybaby",R.drawable.pic_b1, "我的freestyle", "Nekogee",R.raw.freestyle);
            TrendList.add(trend3);
            Trend trend4 = new Trend(R.drawable.user_img1, "crybaby",R.drawable.pic_b1, "我的freestyle", "Nekogee",R.raw.freestyle);
            TrendList.add(trend4);
        }
    }
}
