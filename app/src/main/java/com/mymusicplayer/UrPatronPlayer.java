package com.mymusicplayer;

import android.animation.ObjectAnimator;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;

import java.util.ArrayList;


public class UrPatronPlayer extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    private Boolean flag = true;


    public UrPatronPlayer(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtName, txtSinger, txtLyric;
        ImageView ivPlay, ivStop, ivText , ivSound;
        SeekBar seekBar, seekBarVol;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtSinger = (TextView) convertView.findViewById(R.id.txtSinger);
            viewHolder.txtLyric = (TextView) convertView.findViewById(R.id.lyric);
            viewHolder.ivPlay = (ImageView) convertView.findViewById(R.id.PlayBtn);
            viewHolder.ivStop = (ImageView) convertView.findViewById(R.id.StopBtn);
            viewHolder.ivText = (ImageView) convertView.findViewById(R.id.TextBtn);
            viewHolder.ivSound = (ImageView) convertView.findViewById(R.id.iSound2);
            viewHolder.seekBar = (SeekBar) convertView.findViewById(R.id.seekBar);
            viewHolder.seekBarVol = (SeekBar) convertView.findViewById(R.id.seekBarSound);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Music music = arrayList.get(position);

        viewHolder.txtName.setText(music.getName());
        viewHolder.txtSinger.setText(music.getSinger());


        // play music
        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){

                    mediaPlayer = MediaPlayer.create(context, music.getSong());
                    mediaPlayer.seekTo(0);
                    viewHolder.seekBar.setMax(mediaPlayer.getDuration());
                    viewHolder.seekBarVol.setProgress(50);
                    flag = false;

                }
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    viewHolder.ivPlay.setImageResource(R.drawable.play);

                } else {
                    mediaPlayer.start();
                    viewHolder.ivPlay.setImageResource(R.drawable.pause);
                    viewHolder.seekBar.setVisibility(TextView.VISIBLE);
                    viewHolder.seekBarVol.setVisibility(TextView.VISIBLE);
                    viewHolder.ivSound.setVisibility(TextView.VISIBLE);
                }
            }
        });


        // stop
        viewHolder.ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHolder.ivPlay.setImageResource(R.drawable.play);
                viewHolder.seekBar.setProgress(0);
                viewHolder.seekBar.setVisibility(TextView.GONE);
                viewHolder.seekBar.setVisibility(TextView.GONE);
                viewHolder.seekBarVol.setVisibility(TextView.GONE);
                viewHolder.ivSound.setVisibility(TextView.GONE);
            }
        });

        viewHolder.ivText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.txtLyric.getText().equals("")){
                    viewHolder.txtLyric.setText(music.getLyric());
                    viewHolder.txtLyric.setVisibility(TextView.VISIBLE);}
                else {
                    viewHolder.txtLyric.setText("");
                    viewHolder.txtLyric.setVisibility(TextView.GONE);}
            }



        });

        viewHolder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                if(isFromUser) {
                    mediaPlayer.seekTo(progress);
                    seekBar.setProgress(progress);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        viewHolder.seekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                float volume = progress / 100f;
                mediaPlayer.setVolume(volume,volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        return convertView;
    }
}
