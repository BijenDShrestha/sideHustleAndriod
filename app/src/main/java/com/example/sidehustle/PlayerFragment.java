package com.example.sidehustle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlayerFragment extends Fragment implements View.OnClickListener {
    private View mainView;
    private AppCompatButton play;
    private AppCompatButton pause;
    private AppCompatButton stop;
    private MediaPlayer mediaPlayer;



    public PlayerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_player, container, false);

        findView();
        return mainView;
    }

    private void findView() {
        play = mainView.findViewById(R.id.button_play);
        play.setOnClickListener(this);
        pause = mainView.findViewById(R.id.button_next_play);
        pause.setOnClickListener(this);
        stop = mainView.findViewById(R.id.button_previous_play);
        stop.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.music);
//        mediaPlayer.start();

//        try {
////            mediaPlayer.setDataSource("/res/raw/music.mp3");
//            mediaPlayer.prepare();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_play:
                mediaPlayer.start();
                break;
            case R.id.button_next_play:
                mediaPlayer.pause();
                break;
            case R.id.button_previous_play:
                mediaPlayer.stop();
                break;

        }

    }
}