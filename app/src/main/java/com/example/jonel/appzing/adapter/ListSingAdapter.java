package com.example.jonel.appzing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jonel.appzing.model.AudioPlayer;
import com.example.jonel.appzing.R;

import java.util.List;

public class ListSingAdapter extends BaseAdapter {
    private static final String TAG = ListSingAdapter.class.getSimpleName();
    private List<AudioPlayer> audioPlayers;

    private Context context;

    public ListSingAdapter(Context context, List<AudioPlayer> audioPlayers) {
        this.context=context;
        this.audioPlayers=audioPlayers;
    }

    public void setAudioPlayers(List<AudioPlayer> audioPlayers) {
        this.audioPlayers = audioPlayers;
    }

    @Override
    public int getCount() {
        return audioPlayers.size();
    }

    @Override
    public Object getItem(int position) {
        return audioPlayers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HollerView hollerView;
        if (convertView==null){
            LayoutInflater layoutInflater= LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.item_baihat,parent,false);
            hollerView=new HollerView();
            hollerView.tvTenBaiHat= convertView.findViewById(R.id.title); //ep kieu  (TextView)
            hollerView.tvAlbum= convertView.findViewById(R.id.album); //(TextView)
            hollerView.tvTenCaSi= convertView.findViewById(R.id.artist); //(TextView)
            convertView.setTag(hollerView);
        }else {
            hollerView=(HollerView)convertView.getTag();
        }
        AudioPlayer audioPlayer= (AudioPlayer) getItem(position);
        hollerView.tvTenCaSi.setText(audioPlayer.getTenCS());
        hollerView.tvTenBaiHat.setText(audioPlayer.getTitle());
        hollerView.tvAlbum.setText(audioPlayer.getAlbum());

        return convertView;
    }

    private class HollerView{
        private TextView tvTenBaiHat;
        private TextView tvTenCaSi;
        private TextView tvAlbum;
    }
}
