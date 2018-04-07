package com.innopolis.zelenyichai.smartbar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AssistentFragment extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private int imageId;
    private String assistantName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assistant_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        imageView = view.findViewById(R.id.image_portrait);
        textView = view.findViewById(R.id.tv_assistant_name);
        imageView.setImageResource(imageId);
        textView.setText(assistantName);
    }

    @Override
    public void setArguments(Bundle args) {
        imageId = args.getInt("imageId");
        assistantName = args.getString("name");
    }
}
