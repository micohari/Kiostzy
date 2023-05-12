package com.kiostzy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homeFragment extends Fragment {



    private FirebaseUser firebaseUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textName = (TextView) view.findViewById(R.id.nama);
        ImageButton Fgalvalum = (ImageButton) view.findViewById(R.id.Fgalvalum);
        ImageButton alumunium = (ImageButton) view.findViewById(R.id.btn_alumunium);
        ImageButton kayu = (ImageButton) view.findViewById(R.id.btn_kayu);
        ImageButton galvalum = (ImageButton) view.findViewById(R.id.btn_galvalum);
        ImageButton container1 = (ImageButton) view.findViewById(R.id.btn_container);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser.getDisplayName()!=null){
            textName.setText(firebaseUser.getDisplayName());
        }else{
            textName.setText("Login Gagal");
        }


        Fgalvalum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, new galvalumFragment());
                fragmentTransaction.commit();
            }
        });

        alumunium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, new alumuniumFragment());
                fragmentTransaction.commit();
            }
        });

        kayu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, new kayuFragment());
                fragmentTransaction.commit();
            }
        });

        galvalum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, new galvalumFragment());
                fragmentTransaction.commit();
            }
        });

        container1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, new containerFragment());
                fragmentTransaction.commit();
            }
        });




        return view;
    }
}