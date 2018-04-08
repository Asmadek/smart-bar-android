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

import com.innopolis.zelenyichai.smartbar.Fragment.ChatFragment;
import com.innopolis.zelenyichai.smartbar.Fragment.DrinksFragment;
import com.innopolis.zelenyichai.smartbar.R;

import java.math.BigDecimal;
import java.math.BigInteger;

import static android.view.Gravity.CENTER;

public class DrinkActivity extends Activity implements View.OnClickListener {

    private Bundle bundle;
    private ChatFragment chatFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BigDecimal totalAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Button orderButton = findViewById(R.id.btn_order);
        orderButton.setOnClickListener(this);
        bundle = new Bundle();
        totalAmount = new BigDecimal(BigInteger.ZERO);
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
                showOrderMessage("Заказ отправлен...");
                // TODO необходимо собирать итоговую сумму, в случае нескольких выбранных напитков
                totalAmount.add(new BigDecimal(279));
                TextView totalAmount = findViewById(R.id.total_amount);
                totalAmount.setText(totalAmount + " rub");
                chatFragment.addMessage(getIntent().getExtras(), "Красава ваще!!!");
                break;
        }
    }

    private void showOrderMessage(final String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(CENTER, 0, 0);
        toast.show();
    }
}
