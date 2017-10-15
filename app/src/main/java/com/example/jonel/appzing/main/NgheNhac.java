package com.example.jonel.appzing.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.jonel.appzing.R;
import com.example.jonel.appzing.model.ListNhac;
import com.example.jonel.appzing.model.AudioPlayer;
import com.example.jonel.appzing.adapter.ListSingAdapter;

import java.util.List;


public class NgheNhac extends AppCompatActivity {
    private ListNhac listNhac;

    private List<AudioPlayer> listSing;
    private ListView listView;
    private ListSingAdapter listSingAdapter;
    private LinearLayout hearderListSing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_nhac);
        initListSing();
        getViews();
    }

    private void initListSing() {
        Log.d("NghetNhac","initListSing");
        listNhac=new ListNhac(this);
        listNhac.setAudioList(listNhac.getListAudioPlayer());
        listSing=listNhac.getListAudioPlayer();
        listSingAdapter=new ListSingAdapter(this,listSing);
        listView.setAdapter(listSingAdapter);

        LayoutInflater layoutInflater=LayoutInflater.from(this);//khoi tao layoutinflate
        hearderListSing= (LinearLayout) layoutInflater.inflate(R.layout.item_hearder_baihat,listSing,false);
        listView.addHeaderView(hearderListSing);
//        hearderListSing.findViewById(R.id.btn_play_all_sing).setOnClickListener(this);
//        hearderListSing.findViewById(R.id.btn_ss_ten).setOnClickListener(this);
        // add su kien
//        listSing.setOnItemClickListener(this);
//        listSing.setOnItemLongClickListener(this);

    }
    public int getViews() {
        return R.layout.activity_ds_nhac;
    }

}
