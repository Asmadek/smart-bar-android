package com.innopolis.zelenyichai.smartbar.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.innopolis.zelenyichai.smartbar.Activity.DesicionActivity;
import com.innopolis.zelenyichai.smartbar.R;

public class AssistentFragment extends Fragment implements View.OnClickListener {

    private ImageView imageView;
    private TextView textView, mDescription;
    private int imageId;
    private String assistantName, assistentDescription;

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
        mDescription = view.findViewById(R.id.tv_assistant_description);
        imageView.setImageResource(imageId);
        textView.setText(assistantName);
        mDescription.setText(assistentDescription);
    }

    @Override
    public void setArguments(Bundle args) {
        imageId = args.getInt("imageId");
        assistantName = args.getString("name");
        assistentDescription = args.getString("description");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), DesicionActivity.class);
        intent.putExtra("name", assistantName);
        intent.putExtra("id", imageId);
        startActivity(intent);
    }
}
