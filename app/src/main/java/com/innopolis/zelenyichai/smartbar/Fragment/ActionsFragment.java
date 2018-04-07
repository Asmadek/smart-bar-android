package com.innopolis.zelenyichai.smartbar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.innopolis.zelenyichai.smartbar.Activity.BarActivity;
import com.innopolis.zelenyichai.smartbar.R;

public class ActionsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.actions_layout, null);
        Button buttonBar = view.findViewById(R.id.btn_bar);
        Button buttonAlcoTrip = view.findViewById(R.id.btn_alcotrip);

        buttonBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BarActivity.class));
            }
        });

        buttonAlcoTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // inflater.inflate(R.layout.actions_layout, container, false)

        return view;
    }
}
