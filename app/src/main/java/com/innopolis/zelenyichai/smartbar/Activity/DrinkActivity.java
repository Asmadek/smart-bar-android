package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.innopolis.zelenyichai.smartbar.BaseMessage;
import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.Fragment.DrinksFragment;
import com.innopolis.zelenyichai.smartbar.R;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import static android.view.Gravity.CENTER;

public class DrinkActivity extends Activity {

    private Bundle bundle;
    private ChatFragment chatFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BigDecimal totalAmount;
    int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        bundle = new Bundle();
        totalAmount = new BigDecimal(BigInteger.ZERO);
        fragmentManager = getFragmentManager();
        chatFragment = new ChatFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_bar_chat, chatFragment);
        fragmentTransaction.commit();
        chatFragment.addMessages((ArrayList<BaseMessage>)getIntent().getExtras().getSerializable("log"));
        chatFragment.addMessage(composeBundle(R.mipmap.elon_round, "Илон Маск"),"Я советую начать с моего фирменного коктейля: Комический Тесла.");
        buildDrinks();
    }

    private void buildDrinks() {
        DrinksFragment drinksFragment = (DrinksFragment) fragmentManager.findFragmentById(R.id.fragment_drinks);
        drinksFragment.setMessageList(chatFragment.getMessageList());
    }

    private void showOrderMessage(final String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(CENTER, 0, 0);
        toast.show();
    }


    private Bundle composeBundle(int id, String name){
        bundle.putInt("id", id);
        bundle.putString("name", name);
        return bundle;
    }
}
