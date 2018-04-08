package com.innopolis.zelenyichai.smartbar.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.Fragment.DrinksFragment;
import com.innopolis.zelenyichai.smartbar.R;

public class DrinkActivity extends Activity implements View.OnClickListener {

    private Bundle bundle;
    private ChatFragment chatFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Button orderButton = findViewById(R.id.btn_order);
        orderButton.setOnClickListener(this);
        bundle = new Bundle();

        fragmentManager = getFragmentManager();
        buildDrinks();

        chatFragment = new ChatFragment();
        fragmentTransaction.add(R.id.fragment_chat, chatFragment);
        fragmentTransaction.commit();
        chatFragment.addMessage(getIntent().getExtras(), "I recommend you the Long Island cocktail");
    }

    private void buildDrinks() {
        fragmentTransaction = fragmentManager.beginTransaction();
        DrinksFragment drinksFragment = new DrinksFragment();
        fragmentTransaction.add(R.id.fragment_drinks, drinksFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_order:
                // TODO в зависимости от того, какой коктейл выбрал, менять сообщение
                chatFragment.addMessage(getIntent().getExtras(), "Красава ваще!!!");
                break;
        }
    }
}
