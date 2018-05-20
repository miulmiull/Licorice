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

import com.google.android.exoplayer2.SimpleExoPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class HomePageActivity extends Fragment {
    private List<HomepageFeed> homepageFeedList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_feed, container, false);
        FloatingActionButton PresentLoc = (FloatingActionButton) view.findViewById(R.id.wishFab);
        PresentLoc.setOnClickListener(new LocationCheckedListener());

        recyclerView = (RecyclerView) view.findViewById(R.id.homepage_recyclerView);

        return view;
    }

    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), PerformActivity.class);
            getActivity().startActivity(intent);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createWish();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        HomepageFeedAdapter adapter = new HomepageFeedAdapter(homepageFeedList);
        recyclerView.setAdapter(adapter);
    }

    private void createWish() {
        for (int i = 0; i < 3; ++i) {
            HomepageFeed homepageFeed1 = new HomepageFeed(R.drawable.user_img1, "crybaby",R.drawable.pic_b1, "我的freestyle", "Nekogee",R.raw.freestyle);
            homepageFeedList.add(homepageFeed1);
            HomepageFeed homepageFeed2 = new HomepageFeed(R.drawable.user_img2, "nekogee",R.drawable.pic_b2, "my song", "Nekogee",R.raw.intro);
            homepageFeedList.add(homepageFeed2);
            HomepageFeed homepageFeed3 = new HomepageFeed(R.drawable.user_img3, "miumiu",R.drawable.pic_b3, "licorice", "Nekogee",R.raw.tiny_piano);
            homepageFeedList.add(homepageFeed3);
        }
    }
}
