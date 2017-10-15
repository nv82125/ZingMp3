package com.example.jonel.appzing.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.jonel.appzing.adapter.ListSingAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListNhac {

    private static final String tag = ListNhac.class.getSimpleName();
    private ListView listSing;
    private ListSingAdapter listSingAdapter;
    private List<AudioPlayer> audioList;
    private View view;
    private Context mContext;
    ListNhac ngheNhac;

    public ListNhac(Context mContext) {
        //la lop dung de lay thong tin bai hat , ca si , album
        this.mContext = mContext;
    }

    public List<AudioPlayer> getListAudioPlayer() {
        //dua ra cac bai hat co trong may
        List<AudioPlayer> players = new ArrayList<>();
        Uri uri; // get con tro file(Uri) den bang audio
        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] m_data = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST,
//                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA};
//lay ra ra contro cursor tro den tung hang
        Cursor c = mContext.getContentResolver().query(uri, m_data, MediaStore.Audio.Media.IS_MUSIC + "=1", null,
                MediaStore.Audio.Media.TITLE + " ASC");
        if (c == null || c.getCount() == 0) {
            return players;
        }
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String title, album, artist, path;
//            int duration;
            title = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
            album = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
            artist = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
//            duration = (int) (c.getInt(c.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
            path = c.getString(c.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
            AudioPlayer ap = new AudioPlayer(path, title, artist, album);
            players.add(ap);
        }
        return players;
//        if ( c == null || c.getCount() == 0) {
//            return players;
//        }
//        int indexData = c.getColumnIndex(MediaStore.Audio.Media.DATA);
//        int indexName = c.getColumnIndex(MediaStore.Audio.Media.TITLE);
//        int indexDuration = c.getColumnIndex(MediaStore.Audio.Media.DURATION);
//        int indexAlbum = c.getColumnIndex(MediaStore.Audio.Media.ALBUM);
//        int indexArtist = c.getColumnIndex(MediaStore.Audio.Media.ARTIST);
//        c.moveToFirst();
//
//        while ( !c.isAfterLast() ) {
//            String data = c.getString(indexData);
//            String name = c.getString(indexName);
//            int duration = c.getInt(indexDuration);
//            String album = c.getString(indexAlbum);
//            String artist = c.getString(indexArtist);
//
//            //them phan tu AudioPlayer vao list
//            players.add(new AudioPlayer(data, name, artist,album, duration));
//
//            //tro den hang tiep theo
//            c.moveToNext();
//        }
//        return players;
    }

    public void setAudioList(List<AudioPlayer> audioList) {
        this.audioList = audioList;
    }

    public Context getContext() {
        return mContext;
    }

    public AudioPlayer getAudioPlayser(String s) {
        //lay bai het theo ten
        List<AudioPlayer> audioPlayers=new ArrayList<>();
        for (AudioPlayer audioPlayer:getListAudioPlayer()){
            if (audioPlayer.getTitle().equals(s)){
                return audioPlayer;
            }
        }
        return null;
    }

}
