package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.R;

import java.util.ArrayList;
import java.util.List;

public class BarActivity extends AppCompatActivity implements View.OnClickListener {

    private Bundle bundle;
    private ChatFragment chatFragment;
    private Button map, list;
    private static List<String> barsMock = new ArrayList<>();

    static {
        barsMock.add("Rockstar Bar");
        barsMock.add("Twin Peaks");
        barsMock.add("Beer House");
        barsMock.add("Trinity Irish Pub");
        barsMock.add("Cuba Libre");
        barsMock.add("IQ Bar");
        barsMock.add("Fomin");
        barsMock.add("Соль");
        barsMock.add("Бельгиан");
        barsMock.add("Что делать!?");
        barsMock.add("Jam Bar");
        barsMock.add("Дублин");
        barsMock.add("Craft House");
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        bundle = new Bundle();
        map = findViewById(R.id.btn_map);
        list = findViewById(R.id.btn_list);
        map.setOnClickListener(this);
        list.setOnClickListener(this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        chatFragment = new ChatFragment();
        fragmentTransaction.add(R.id.fragment_bar_chat, chatFragment);
        fragmentTransaction.commit();
        chatFragment.addMessages((ArrayList<BaseMessage>) getIntent().getExtras().getSerializable("log"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_list:
                findViewById(R.id.image_barmap).animate().alpha(0.0f).setDuration(500);
                break;

            case R.id.btn_map:
                // TODO отобразить список баров
                break;
        }
    }
}
