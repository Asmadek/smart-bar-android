package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.Fragment.AlcoFragment;
import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.Fragment.DrinksFragment;
import com.innopolis.zelenyichai.smartbar.R;

import java.util.ArrayList;

public class AlcoActivity extends Activity {


    Bundle bundle;
    AlcoFragment alcoFragment;
    ChatFragment chatFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcotrip);
        bundle = new Bundle();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        AlcoFragment alcoFragment= new AlcoFragment();
        fragmentTransaction.add(R.id.fragment_alco, alcoFragment);
        fragmentTransaction.commit();
        fragmentTransaction = fragmentManager.beginTransaction();
        chatFragment = new ChatFragment();
        fragmentTransaction.add(R.id.fragment_alco_chat, chatFragment);
        fragmentTransaction.commit();
        chatFragment.addMessages((ArrayList<BaseMessage>) getIntent().getExtras().getSerializable("log"));
        chatFragment.addMessage(composeBundle(R.mipmap.elon_round, "Elon Mask"), "Choose your way wisely, my friend!");
    }
    private Bundle composeBundle(int id, String name){
        bundle.putInt("id", id);
        bundle.putString("name", name);
        return bundle;
    }
}
