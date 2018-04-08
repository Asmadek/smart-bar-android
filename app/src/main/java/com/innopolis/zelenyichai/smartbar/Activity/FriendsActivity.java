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

public class FriendsActivity extends Activity implements View.OnClickListener{

    private Bundle bundle;
    private ChatFragment chatFragment;
    private Button callFriends, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        callFriends = findViewById(R.id.btn_call_friends);
        back = findViewById(R.id.btn_back);
        callFriends.setOnClickListener(this);
        back.setOnClickListener(this);

        bundle = new Bundle();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        chatFragment = new ChatFragment();
        fragmentTransaction.add(R.id.fragment_chat, chatFragment);
        chatFragment.addMessages((ArrayList<BaseMessage>) getIntent().getExtras().getSerializable("log"));
        fragmentTransaction.commit();
    }

    private Bundle composeBundle(int id, String name){
        bundle.putInt("id", id);
        bundle.putString("name", name);
        return bundle;
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        chatFragment.addMessages((ArrayList<BaseMessage>) getIntent().getExtras().getSerializable("log"));
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_call_friends:
                chatFragment.addMessage(composeBundle(R.mipmap.elon_round, "Elon Mask"), "Алексей Бандура будет ждать тебя в баре!");
                intent = new Intent(this, DesicionActivity.class);
                intent.putExtra("log", chatFragment.getMessageList());
                startActivity(intent);
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
