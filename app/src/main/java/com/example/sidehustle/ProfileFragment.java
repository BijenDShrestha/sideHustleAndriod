package com.example.sidehustle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ProfileFragment extends Fragment {
    private View mainView;
    private AppCompatButton editButton;
    private TextView mobileDetail;
    private TextView emailDetail;
    private TextView addressDetail;
    private TextView dobDetail;

    private ImageView imageView;
    private Integer imageResource;


    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_profile, container, false);
        findView();
        return mainView;
    }

    private void findView(){
        editButton = mainView.findViewById(R.id.button_account_info_edit);

        imageResource = R.drawable.img_bijen;

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Fragment fragment = new ProfileEditFragment();



                mobileDetail = mainView.findViewById(R.id.text_mobile_detail);
                emailDetail = mainView.findViewById(R.id.text_email_detail);
                addressDetail = mainView.findViewById(R.id.text_address_detail);
                dobDetail = mainView.findViewById(R.id.text_dob_detail);

//                imageView = mainView.findViewById(R.id.image_profile);
//                imageView.setTag(R.drawable.img_bijen);
//                imageResource = (Integer)imageView.getTag();


                Bundle bundle = new Bundle();
                bundle.putString("mobileDetail", mobileDetail.getText().toString());
                bundle.putString("emailDetail", emailDetail.getText().toString());
                bundle.putString("addressDetail", addressDetail.getText().toString());
                bundle.putString("dobDetail", dobDetail.getText().toString());
                bundle.putString("imageResource", imageResource.toString());


                fragment.setArguments(bundle);



                fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
            }
        });

        imageView = mainView.findViewById(R.id.image_profile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] imageArray = {R.drawable.img_bijen, R.drawable.img_jatra, R.drawable.img_child};
                Random random = new Random();
                Integer i = random.nextInt(imageArray.length);
                imageView.setImageResource(imageArray[i]);
                imageResource = imageArray[i];
            }
        });



    }
}