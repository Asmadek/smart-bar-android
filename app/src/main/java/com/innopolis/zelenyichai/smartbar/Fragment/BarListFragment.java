package com.innopolis.zelenyichai.smartbar.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innopolis.zelenyichai.smartbar.Activity.TaxiActivity;
import com.innopolis.zelenyichai.smartbar.R;

public class BarListFragment extends Fragment implements View.OnClickListener{

    CardView cardView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        cardView = view.findViewById(R.id.card_108);
        cardView.setOnClickListener(this);
        cardView = view.findViewById(R.id.card_trinity);
        cardView.setOnClickListener(this);
        cardView = view.findViewById(R.id.card_NY);
        cardView.setOnClickListener(this);
        cardView = view.findViewById(R.id.card_zhig);
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), TaxiActivity.class);
        startActivity(intent);

    }
}
