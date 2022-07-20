package com.example.sidehustle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileEditFragment extends Fragment {
    private View mainView;
    private TextView hintMobile;
    private TextView hintEmail;
    private TextView hintAddress;
    private TextView hintDob;
    private ImageView profileImage;

    public ProfileEditFragment() {
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
        mainView = inflater.inflate(R.layout.fragment_profile_edit, container, false);
        findView();
        return mainView;
    }


    private void findView() {
        hintMobile = mainView.findViewById(R.id.edit_name);
        hintMobile.setText(getArguments().getString("mobileDetail"));

        hintEmail = mainView.findViewById(R.id.edit_email);
        hintEmail.setText(getArguments().getString("emailDetail"));

        hintAddress = mainView.findViewById(R.id.edit_address);
        hintAddress.setText(getArguments().getString("addressDetail"));

        hintDob = mainView.findViewById(R.id.edit_dob);
        hintDob.setText(getArguments().getString("dobDetail"));

        profileImage = mainView.findViewById(R.id.edit_profile_image);
        profileImage.setImageResource(Integer.parseInt(getArguments().getString("imageResource")));


    }

}