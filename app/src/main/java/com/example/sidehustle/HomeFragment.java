package com.example.sidehustle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    private ImageView jatraImage;
    private View mainView;
    private TextView homeText;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_home, container, false);

        findView();

        return mainView;
    }



    public void findView(){

        jatraImage = mainView.findViewById(R.id.image_jatra);
        jatraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Fragment fragment = new TrackFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                    Bundle bundle = new Bundle();
                    bundle.putString("name", "bijen shrestha new author");

                    fragment.setArguments(bundle);


                    fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });


        homeText = mainView.findViewById(R.id.text_home);
        homeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), GraphActivity.class);
                startActivity(intent);
            }
        });
    }


}