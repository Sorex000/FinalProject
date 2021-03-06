package com.example.ishmeet.finalproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ishmeet.finalproject.audio.BaseAudioOb;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.ishmeet.finalproject.Adapter.MainViewPagerAdapter;
import com.example.ishmeet.finalproject.audio.BaseAudioOb;
import com.example.ishmeet.finalproject.audio.MusicController;
import com.example.ishmeet.finalproject.view.PlayListView;
import com.example.ishmeet.finalproject.view.PlayView;

public class MusicActivity extends BaseActivity{

    @BindView(R.id.main_view_pager) ViewPager viewPager;
    private ArrayList<BaseAudioOb> contentList = new ArrayList<BaseAudioOb>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        initInfo();
        initViewPager();
    }

    private void initViewPager() {
        ArrayList<View> viewList = new ArrayList<View>();
        viewList.add(new PlayView(this));
        viewList.add(new PlayListView(this));
        viewPager.setAdapter(new MainViewPagerAdapter(viewList));
    }

    private void initInfo() {


        AudioOb m1 = new AudioOb();
        m1.setURL("http://other.web.rh01.sycdn.kuwo.cn/resource/n3/77/1/1061700123.mp3");
        m1.setName("One Moment");

        AudioOb m2 = new AudioOb();
        m2.setURL("http://other.web.rn01.sycdn.kuwo.cn/resource/n3/51/70/1282895259.mp3");
        m2.setName("I will remember you");

        AudioOb m3 = new AudioOb();
        m3.setURL("http://other.web.ra01.sycdn.kuwo.cn/resource/n2/128/72/74/2639398911.mp3");
        m3.setName("Young for you");

        contentList.add(m1);
        contentList.add(m2);
        contentList.add(m3);
    }

    public ArrayList<BaseAudioOb> getContent(){
        return contentList;
    }

    @Override
    protected void onDestroy(){
        MusicController controller = MusicController.getInstance(this);
        controller.destroy();
        super.onDestroy();
    }
}