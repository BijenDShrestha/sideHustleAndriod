package com.example.sidehustle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class TrackFragment extends Fragment {
    private View mainView;
    private TextView authorNameText;
    private AppCompatButton shareButton;


//    private ConstraintLayout constraintLayout;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_track);
//
//
//        constraintLayout = findViewById(R.id.song_detail_1);
//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TrackActivity.this, PlayerActivity.class);
//                startActivity(intent);
//            }
//        });
//    }


    public TrackFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_track, container, false);

        findView();

        return mainView;
    }

    private void findView() {
//        authorNameText = mainView.findViewById(R.id.text_album_author);
//
//        String newAuthor = getArguments().getString("name", "bijen shrestha default");
//
//        if(newAuthor != null) {
//            authorNameText.setText(newAuthor);
//        }

        shareButton = mainView.findViewById(R.id.button_share);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popUpView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_share, null);

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                PopupWindow popupWindow = new PopupWindow(popUpView, width, height, true);
                popupWindow.showAtLocation(popUpView, Gravity.TOP,100, 750);

                // dismiss the popup when touch
                popUpView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

            }
        });

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        Bundle bundle = getArguments();
//        if(bundle != null) {
//            authorNameText.setText(bundle.getString("name", "Bijen Shrestha default"));
//        }
//    }




}