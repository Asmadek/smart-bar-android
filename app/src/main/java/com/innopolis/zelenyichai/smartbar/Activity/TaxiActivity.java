package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.R;

import java.util.ArrayList;

public class TaxiActivity extends Activity implements View.OnClickListener{

    private Bundle bundle;
    private ChatFragment chatFragment;
    private Button withTaxi, withoutTaxi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);

        withTaxi = findViewById(R.id.btn_with_taxi);
        withoutTaxi = findViewById(R.id.btn_without_taxi);
        withTaxi.setOnClickListener(this);
        withoutTaxi.setOnClickListener(this);

        bundle = new Bundle();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        chatFragment = new ChatFragment();
        fragmentTransaction.add(R.id.fragment_chat_desicion, chatFragment);
        fragmentTransaction.commit();
        chatFragment.addMessages((ArrayList<BaseMessage>) getIntent().getExtras().getSerializable("log"));
        chatFragment.addMessage(composeBundle(R.mipmap.elon_round, "Илон Маск"), "Может закажем такси?");
    }

    private Bundle composeBundle(int id, String name){
        bundle.putInt("id", id);
        bundle.putString("name", name);
        return bundle;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_with_taxi:
                chatFragment.addMessage(composeBundle(1, "you"), "ПОЕХАЛИ!");
                intent = new Intent(this, DrinkActivity.class);
                intent.putExtra("log", chatFragment.getMessageList());
                startActivity(intent);
                break;
            case R.id.btn_without_taxi:
                chatFragment.addMessage(composeBundle(1, "you"), "Я сам");
                intent = new Intent(this, DrinkActivity.class);
                intent.putExtra("log", chatFragment.getMessageList());
                startActivity(intent);
                break;
        }
    }

}
