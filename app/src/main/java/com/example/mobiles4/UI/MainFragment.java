package com.example.mobiles4.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobiles4.R;

public class MainFragment extends Fragment {
    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button b_left = view.findViewById(R.id.b_left);
        Button b_right = view.findViewById(R.id.b_right);
        Button b_statistics = view.findViewById(R.id.b_statistics);
        EditText e_qcount = view.findViewById(R.id.e_qcount);
        b_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = e_qcount.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("CreateList", true);
                if (!str.isEmpty() && str.matches("\\d+")) {
                    bundle.putInt("qCount", Integer.parseInt(str));
                }
                Navigation.findNavController(v).navigate(R.id.a_left, bundle);
            }
        });
        b_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = e_qcount.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putBoolean("CreateList", true);
                if (!str.isEmpty() && str.matches("\\d+")) {
                    bundle.putInt("qCount", Integer.parseInt(str));
                }
                Navigation.findNavController(v).navigate(R.id.a_right, bundle);
            }
        });
        b_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.a_statistics);
            }
        });
    }
}