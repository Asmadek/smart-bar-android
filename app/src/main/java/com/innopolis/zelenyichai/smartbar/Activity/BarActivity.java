package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.Fragment.BarListFragment;
import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.R;

import java.util.ArrayList;

public class BarActivity extends Activity implements View.OnClickListener{

    private Bundle bundle;
    private ChatFragment chatFragment;
    private Button map, list;

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
        chatFragment.addMessage(composeBundle(R.mipmap.elon_round, "Илон Маск"), "В какой бар пойдем?");
        BarListFragment barListFragment = (BarListFragment) fragmentManager.findFragmentById(R.id.fragment_bar_list);
        barListFragment.setMessageList(chatFragment.getMessageList());
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        BarListFragment barListFragment;

        switch (v.getId()){

            case R.id.btn_list:
                findViewById(R.id.image_barmap).animate().alpha(0.0f);
                findViewById(R.id.image_barmap).setVisibility(View.INVISIBLE);
                fragmentManager = this.getFragmentManager();
                fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                barListFragment = (BarListFragment) fragmentManager.findFragmentById(R.id.fragment_bar_list);
                fragmentTransaction.show(barListFragment);
                fragmentTransaction.commit();
                break;
            case R.id.btn_map:
                fragmentManager = this.getFragmentManager();
                fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                barListFragment = (BarListFragment) fragmentManager.findFragmentById(R.id.fragment_bar_list);
                fragmentTransaction.hide(barListFragment);
                fragmentTransaction.commit();
                findViewById(R.id.image_barmap).setVisibility(View.VISIBLE);
                findViewById(R.id.image_barmap).animate().alpha(1.0f);
                break;
        }

        }


    private Bundle composeBundle(int id, String name){
        bundle.putInt("id", id);
        bundle.putString("name", name);
        return bundle;
    }
}
