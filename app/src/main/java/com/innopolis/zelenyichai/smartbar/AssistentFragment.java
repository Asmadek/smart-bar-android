package com.innopolis.zelenyichai.smartbar;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AssistentFragment extends Fragment implements View.OnClickListener {

    private ImageView imageView;
    private TextView textView;
    private int imageId;
    private String assistantName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assistant_layout, container, false);
        view.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), DesicionActivity.class);
        intent.putExtra("name", assistantName);
        intent.putExtra("imageId", imageId);
        startActivity(intent);
    }
}
