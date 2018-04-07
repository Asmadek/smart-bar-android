package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.R;

public class DesicionActivity extends Activity implements View.OnClickListener{

    private Bundle bundle;
    private ChatFragment chatFragment;
    Button bars, alcotrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);
        bars = findViewById(R.id.btn_bars);
        alcotrip = findViewById(R.id.btn_alcotrip);
        bars.setOnClickListener(this);
        alcotrip.setOnClickListener(this);
        bundle = new Bundle();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        chatFragment = new ChatFragment();
        fragmentTransaction.add(R.id.fragment_chat, chatFragment);
        fragmentTransaction.commit();
        chatFragment.addMessage(getIntent().getExtras(), "It is time for some alco science!");
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
            case R.id.btn_bars:
                chatFragment.addMessage(composeBundle(1, "you"), "Bars!");
                intent = new Intent(this, BarActivity.class);
                intent.putExtra("log", chatFragment.getMessageList());
                startActivity(intent);
                break;
            case R.id.btn_alcotrip:
                chatFragment.addMessage(composeBundle(1, "you"), "Alcotrip!");
                intent = new Intent(this, AlcotripActivity.class);
                intent.putExtra("log", chatFragment.getMessageList());
                startActivity(intent);
                break;
        }
    }
}
